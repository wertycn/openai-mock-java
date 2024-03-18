package icu.debug.ai.mocker.service;

import icu.debug.ai.mocker.core.AbstractMockServer;
import icu.debug.ai.mocker.core.MockRule;
import icu.debug.ai.mocker.core.MockServer;
import icu.debug.ai.mocker.entity.MockRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ai.openai.metadata.OpenAiChatResponseMetadata;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-19 0:15
 */
public class OpenAiMockServer extends AbstractMockServer<OpenAiChatResponseMetadata> implements MockServer {



    @Override
    public Object mock(HttpServletRequest request) {
        return null;
    }

    @Override
    protected boolean isStream(MockRequest mockRequest, MockRule rule) {
        return false;
    }
}
