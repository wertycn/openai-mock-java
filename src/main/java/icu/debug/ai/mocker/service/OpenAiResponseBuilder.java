package icu.debug.ai.mocker.service;

import icu.debug.ai.mocker.core.MockRule;
import icu.debug.ai.mocker.core.ResponseBuilder;
import icu.debug.ai.mocker.entity.MockRequest;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-19 0:42
 */
public class OpenAiResponseBuilder implements ResponseBuilder {
    @Override
    public SseEmitter buildStream(MockRule rule, MockRequest request) {
        SseEmitter sseEmitter = new SseEmitter(120L);

        return sseEmitter;
    }

    @Override
    public Object build(MockRule rule, MockRequest request) {
        return null;
    }
}
