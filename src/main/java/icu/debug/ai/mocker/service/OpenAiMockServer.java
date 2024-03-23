package icu.debug.ai.mocker.service;

import icu.debug.ai.mocker.core.*;
import icu.debug.ai.mocker.entity.MockRequest;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-19 0:15
 */
//@Component
public class OpenAiMockServer extends AbstractMockServer implements MockServer {

    public OpenAiMockServer(RequestResolver requestResolver, RuleMatcher ruleMatcher) {
        super(requestResolver, ruleMatcher, new OpenAiResponseBuilder());
    }


    @Override
    protected boolean isStream(MockRequest mockRequest, MockRule rule) {
        return Optional
                .ofNullable(mockRequest.getBody())
                .orElse("")
                .contains("\"stream\":true")
                ||
                Optional
                        .ofNullable(mockRequest.getHeaders())
                        .orElse(Map.of())
                        .containsKey("stream");
    }
}
