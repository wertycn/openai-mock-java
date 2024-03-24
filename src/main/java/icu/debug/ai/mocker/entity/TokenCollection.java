package icu.debug.ai.mocker.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * token收集器
 *
 * @author hanjinxiang@debug.icu
 * @date 2024-03-23 15:44
 */
public class TokenCollection {

    /**
     * 原始token集合，对于中文可能存在多个token对应一个中文文本
     */
    private List<Integer> tokens = new ArrayList<>();

    /**
     * token对应的文本内容
     */
    private StringBuilder contentBuilder = new StringBuilder();

    public TokenCollection() {

    }

    public TokenCollection(List<Integer> tokens, String content) {
        this.tokens.addAll(tokens);
        this.contentBuilder.append(content);
    }

    public int count() {
        return tokens.size();
    }

    public synchronized void addToken(List<Integer> tokens, String content) {
        this.tokens.addAll(tokens);
        this.contentBuilder.append(content);
    }

    public synchronized void merge(TokenCollection collection) {
        this.tokens.addAll(collection.getTokens());
        this.contentBuilder.append(collection.getContent());
    }

    public String getContent() {
        return this.contentBuilder.toString();
    }

    public List<Integer> getTokens() {
        return new ArrayList<>(tokens);
    }
}
