package icu.debug.ai.mocker.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模型请求
 *
 * @author hanjinxiang@debug.icu
 * @date 2024-03-23 15:13
 */
@Getter
@Setter
@ToString
public class ModelRequest {

    /**
     * 原始http请求参数对象
     */
    private HttpRequest httpRequest;

    /**
     * 模型请求prompt
     */
    private String prompt;

    /**
     * chat模型message参数
     */
    private List<Message> messages;

    /**
     * 请求的模型
     */
    private String model;

    /**
     * 默认为流式请求
     */
    private boolean stream = true;

    /**
     * 模型参数
     */
    private Double topP;

    /**
     * 扩展参数
     */
    private Map<String, Object> extension = new HashMap<>();


}
