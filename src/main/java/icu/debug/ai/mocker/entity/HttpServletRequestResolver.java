package icu.debug.ai.mocker.entity;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-25 0:26
 */
public class HttpServletRequestResolver {

    public static HttpRequest resolve(HttpServletRequest servletRequest) {
        return HttpRequest.builder()
                .uri(resolveUri(servletRequest))
                .body(resolveBody(servletRequest))
                .query(resolveQuery(servletRequest))
                .method(servletRequest.getMethod())
                .params(resolveParam(servletRequest))
                .headers(resolveHeader(servletRequest))
                .build();
    }

    private static Map<String, List<String>> resolveParam(HttpServletRequest servletRequest) {
        Map<String, List<String>> headers = new HashMap<>();
        Enumeration<String> parameterNames = servletRequest.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            String[] values = servletRequest.getParameterValues(key);
            headers.put(key, List.of(values));
        }
        return headers;
    }

    private static Map<String, List<String>> resolveHeader(HttpServletRequest servletRequest) {
        Map<String, List<String>> headers = new HashMap<>();
        Enumeration<String> headerNames = servletRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            Enumeration<String> values = servletRequest.getHeaders(key);
            headers.put(key, Collections.list(values));
        }
        return headers;
    }

    private static String resolveQuery(HttpServletRequest servletRequest) {
        return servletRequest.getQueryString();
    }

    private static byte[] resolveBody(HttpServletRequest servletRequest) {
        try {
            return servletRequest.getInputStream().readAllBytes();
        } catch (IOException e) {
            throw new IllegalStateException("");
        }
    }

    private static String resolveUri(HttpServletRequest servletRequest) {
        String uri = servletRequest.getRequestURI();
        String contextPath = servletRequest.getContextPath();
        if (!StringUtils.hasLength(contextPath)) {
            return uri;
        }
        // 移除最后一个`/`
        if (contextPath.endsWith("/")) {
            contextPath = contextPath.substring(0, contextPath.lastIndexOf("/"));
        }
        if (uri.startsWith("/")) {
            uri = uri.substring(1);
        }
        return String.format("%s/%s", contextPath, uri);
    }

}
