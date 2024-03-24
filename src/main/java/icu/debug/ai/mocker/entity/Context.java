package icu.debug.ai.mocker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-23 21:54
 */
@Getter
@ToString
public class Context {

    private String id;

    /**
     * 模型请求
     */
    private ModelRequest request;

    private MockRule rule;

    /**
     * 输出token统计
     */
    private int outputTokenCount = 0;

    public Context(ModelRequest request, MockRule rule) {
        this.id = UUID.randomUUID().toString();
        this.request = request;
        this.rule = rule;
    }

    /**
     * 输出token数累加
     *
     * @param count
     */
    public synchronized void addOutputToken(int count) {
        this.outputTokenCount += count;
    }

}
