package icu.debug.ai.mocker.service;

import icu.debug.ai.mocker.core.iface.*;
import icu.debug.ai.mocker.core.impl.AbstractMockServer;
import icu.debug.ai.mocker.core.impl.DefaultRuleMatcher;
import icu.debug.ai.mocker.core.impl.ServerSentEventExecutor;
import icu.debug.ai.mocker.entity.HttpRequest;
import icu.debug.ai.mocker.entity.MockRule;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Map;
import java.util.Optional;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-19 0:15
 */
//@Component
public class OpenAiMockServer extends AbstractMockServer<SseEmitter> implements MockServer {


    public OpenAiMockServer(RequestResolver requestResolver, StreamEventBuilder eventBuilder) {
        super(requestResolver, new DefaultRuleMatcher(), eventBuilder, new ServerSentEventExecutor());
    }
}
