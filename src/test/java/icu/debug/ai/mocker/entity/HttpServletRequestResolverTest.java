package icu.debug.ai.mocker.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-25 0:45
 */
class HttpServletRequestResolverTest {

    @Test
    @DisplayName("测试ServletRequest解析为标准http请求对象")
    void testServletRequestResolver() {
        MockHttpServletRequest servletRequest = new MockHttpServletRequest();
        servletRequest.setContent("name=hello".getBytes(StandardCharsets.UTF_8));
        servletRequest.setRequestURI("/unit_test");
        servletRequest.setParameter("key", "value");
        servletRequest.setRemoteHost("unit.test");
        servletRequest.addHeader("h1", "test");
        servletRequest.addHeader("h1", "test2");
        servletRequest.setContextPath("/servlet/");
        HttpRequest httpRequest = HttpServletRequestResolver.resolve(servletRequest);
        assertEquals("/servlet/unit_test", httpRequest.getUri());
        assertEquals("name=hello", httpRequest.getBodyString());
        assertEquals("value", httpRequest.getParamValue("key").get());
        assertEquals(2, httpRequest.getHeaders().get("h1").size());


    }

}