package icu.debug.ai.mocker.core.impl;

import icu.debug.ai.mocker.core.iface.Cl100kBaseTokenizer;
import icu.debug.ai.mocker.core.iface.TokenTaskBuilder;
import icu.debug.ai.mocker.core.iface.Tokenizer;
import icu.debug.ai.mocker.entity.StreamOption;
import icu.debug.ai.mocker.entity.TaskCollection;
import icu.debug.ai.mocker.entity.TaskSegment;
import icu.debug.ai.mocker.entity.TokenCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * 默认token任务构建器
 *
 * @author hanjinxiang@debug.icu
 * @date 2024-03-23 23:03
 */
public class DefaultTokenTaskBuilder implements TokenTaskBuilder {

    private final Tokenizer tokenizer;

    public DefaultTokenTaskBuilder(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    public DefaultTokenTaskBuilder() {
        this.tokenizer = new Cl100kBaseTokenizer();
    }

    @Override
    public TaskCollection build(String content, StreamOption option) {
        List<TokenCollection> tokenCollections = this.tokenizer.split(content);
        List<TaskSegment> tasks = new ArrayList<>();
        TaskSegment segment = TaskSegment.init();
        int quantity = option.nextTokenQuantity();
        TokenCollection collect = new TokenCollection();
        for (TokenCollection collection : tokenCollections) {
            collect.merge(collection);
            if (collect.count() >= quantity) {
                int thatDelay = option.nextRandomDelay();
                segment = segment.next(collect, thatDelay);
                tasks.add(segment);
                collect = new TokenCollection();
                quantity = option.nextTokenQuantity();
            }
        }
        if (collect.count() > 0) {
            tasks.add(segment.next(collect, option.nextRandomDelay()));
        }

        //tokenCollections.stream().map(TokenCollection::count)
        // 计算总token数量
        //int total = sum(tokenCollections);
        // TODO: 计算平均延迟 (token 总数*1000/(次数*速度),不考虑随机卡顿导致的时间增加，实际速度变慢
        //int delay = total * 1000 / (option.getSpeed() * tasks.size());
        return new TaskCollection(tasks, option.getSpeed());
    }


}
