package icu.debug.ai.mocker.server.openai;

import icu.debug.ai.mocker.core.iface.*;
import icu.debug.ai.mocker.core.impl.AbstractMockServer;
import icu.debug.ai.mocker.core.impl.DefaultRuleMatcher;
import icu.debug.ai.mocker.core.impl.ServerSentEventExecutor;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

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
