package icu.debug.ai.mocker.core.impl;

import icu.debug.ai.mocker.core.iface.RuleMatcher;
import icu.debug.ai.mocker.entity.Message;
import icu.debug.ai.mocker.entity.MockRule;
import icu.debug.ai.mocker.entity.ModelRequest;
import icu.debug.ai.mocker.entity.StreamOption;

import java.util.List;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-24 4:08
 */
public class DefaultRuleMatcher implements RuleMatcher {
    @Override
    public MockRule match(ModelRequest request) {
        return MockRule.builder()
                .model(List.of("gpt-3.5-turbo"))
                .name("openai-test")
                .message(List.of(new Message("ai", "你好，很高兴认识你，你是谁")))
                .option(new StreamOption())
                .build();
    }
}
