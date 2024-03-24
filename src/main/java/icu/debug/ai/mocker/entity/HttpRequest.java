package icu.debug.ai.mocker.entity;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * mock 请求对象
 *
 * @author hanjinxiang@debug.icu
 * @date 2024-03-18 23:32
 */
@Getter
public class HttpRequest {

    /**
     * 请求路径
     */
    String uri;

    /**
     * 请求Header
     */
    Map<String, String[]> headers = new HashMap<>();

    /**
     * 请求body
     */
    String body;

    /**
     * 请求参数
     */
    Map<String, String[]> params = new HashMap<>();

    /**
     * 请求get参数字符串
     */
    String query;

    /**
     * 请求方法
     */
    String method;
}
