package icu.debug.ai.mocker.core;

import icu.debug.ai.mocker.entity.MockRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-19 0:23
 */
@DisplayName("mock server 测试")
class MockServerTest {


    @Test
    @DisplayName("构建TestMockServer")
    void testBuildTestMockServer() {
        RequestResolver requestResolver = new RequestResolver() {
            @Override
            public MockRequest resolve(HttpServletRequest request) {
                return new MockRequest();
            }
        };
        RuleMatcher ruleMatcher = new RuleMatcher() {
            @Override
            public MockRule match(MockRequest request) {
                return new MockRule();
            }
        };
        ResponseBuilder<String> responseBuilder = new ResponseBuilder<>() {
            @Override
            public SseEmitter buildStream(MockRule rule, MockRequest request) {
                return new SseEmitter(30L);
            }

            @Override
            public String build(MockRule rule, MockRequest request) {
                return "";
            }
        };
        TestMockServer server = new TestMockServer(requestResolver, ruleMatcher, responseBuilder);

        Object result = server.mock(new MockHttpServletRequest());


    }

}