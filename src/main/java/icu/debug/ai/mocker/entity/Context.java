package icu.debug.ai.mocker.entity;

import lombok.Getter;
import lombok.ToString;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-23 21:54
 */
@Getter
@ToString
public class Context {

    private final String id;

    /**
     * 模型请求
     */
    private final ModelRequest request;

    private final MockRule rule;

    private final Map<String, String> extensions = new ConcurrentHashMap<>();

    /**
     * 输出token统计
     */
    private int outputTokenCount = 0;

    public Context(ModelRequest request, MockRule rule) {
        this.id = UUID.randomUUID().toString();
        this.request = request;
        this.rule = rule;
    }

    public void setAttr(String key, String value) {
        this.extensions.put(key, value);
    }

    public String getAttr(String key) {
        return this.extensions.get(key);
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
