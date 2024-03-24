//package icu.debug.ai.mocker.core;
//
//import icu.debug.ai.mocker.entity.HttpRequest;
//import icu.debug.ai.mocker.entity.ModelRequest;
//import jakarta.servlet.http.HttpServletRequest;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
//
///**
// * @author hanjinxiang@debug.icu
// * @date 2024-03-19 0:23
// */
//@DisplayName("mock server 测试")
//class MockServerTest {
//
//
//    @Test
//    @DisplayName("构建TestMockServer")
//    void testBuildTestMockServer() {
//        RequestResolver requestResolver = new RequestResolver() {
//            @Override
//            public HttpRequest resolve(HttpServletRequest request) {
//                return new HttpRequest();
//            }
//        };
//        RuleMatcher ruleMatcher = new RuleMatcher() {
//            @Override
//            public MockRule match(ModelRequest request) {
//                return new MockRule();
//            }
//        };
//        ResponseBuilder<String> responseBuilder = new ResponseBuilder() {
//            @Override
//            public SseEmitter buildStream(MockRule rule, HttpRequest request) {
//                return new SseEmitter(30L);
//            }
//
//            @Override
//            public String build(MockRule rule, HttpRequest request) {
//                return "";
//            }
//        };
//        TestMockServer server = new TestMockServer(requestResolver, ruleMatcher, responseBuilder);
//
//        Object result = server.mock(new MockHttpServletRequest());
//
//
//    }
//
//}