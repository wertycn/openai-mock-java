package icu.debug.ai.mocker.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * mock 请求对象
 *
 * @author hanjinxiang@debug.icu
 * @date 2024-03-18 23:32
 */
@Getter
@Builder
@ToString
public class HttpRequest {

    /**
     * 请求路径
     */
    String uri;

    /**
     * 请求Header
     */
    Map<String, List<String>> headers = new HashMap<>();

    /**
     * 请求body
     */
    byte[] body;

    /**
     * 请求参数
     */
    Map<String, List<String>> params = new HashMap<>();

    /**
     * 请求get参数字符串
     */
    String query;

    /**
     * 请求方法
     */
    String method;

    public String getBodyString() {
        return new String(body);
    }

    public Optional<String> getParamValue(String key) {
        if (this.params != null && this.params.containsKey(key)) {
            return Optional.ofNullable(this.params.get(key).get(0));
        }
        return Optional.empty();
    }

    public Optional<String> getHeaderValue(String key) {
        if (this.headers != null && this.headers.containsKey(key)) {
            return Optional.ofNullable(this.headers.get(key).get(0));
        }
        return Optional.empty();
    }
}
