package icu.debug.ai.mocker.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * 模拟规则对象
 *
 * @author hanjinxiang@debug.icu
 * @date 2024-03-18 23:54
 */
@Getter
@Builder
@ToString
public class MockRule {

    private String name;

    private List<String> model;

    /**
     * 匹配规则表达式:
     * <<keyword:${word}:${scope}>> scope支持 all,first,last,system等
     */
    private String expression;


    /**
     * 响应消息
     */
    private List<Message> message;

    /**
     * 响应内容，用于非chat模型的简易配置，实际使用时转换为message,role 为空
     */
    private String output;

    /**
     * 流式输出配置
     */
    private StreamOption option;


}
