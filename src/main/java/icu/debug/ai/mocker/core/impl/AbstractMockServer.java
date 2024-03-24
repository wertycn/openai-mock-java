package icu.debug.ai.mocker.core.impl;

import icu.debug.ai.mocker.core.iface.*;
import icu.debug.ai.mocker.entity.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象mock服务
 *
 * @author hanjinxiang@debug.icu
 * @date 2024-03-19 0:16
 */
public abstract class AbstractMockServer<T> {

    private final RequestResolver requestResolver;
    private final RuleMatcher ruleMatcher;

    private final StreamEventBuilder eventBuilder;

    private final StreamEventExecutor<T> eventExecutor;

    public AbstractMockServer(
            RequestResolver requestResolver,
            RuleMatcher ruleMatcher,
            StreamEventBuilder eventBuilder,
            StreamEventExecutor<T> eventExecutor
    ) {
        this.requestResolver = requestResolver;
        this.ruleMatcher = ruleMatcher;
        this.eventBuilder = eventBuilder;
        this.eventExecutor = eventExecutor;
    }

    public Object mock(HttpRequest request) {
        ModelRequest modelRequest = requestResolver.resolve(request);
        MockRule rule = ruleMatcher.match(modelRequest);
        Context context = new Context(modelRequest, rule);
        // TODO: 非流式响应
        if (!modelRequest.isStream()) {
            return "";
        }
        List<StreamEvent> events = new ArrayList<>(eventBuilder.onStartBuild(context));
        for (Message message : rule.getMessage()) {
            events.addAll(eventBuilder.onRoleStartBuild(context, message));
            events.addAll(eventBuilder.onRoleAnswerBuild(context, message));
            events.addAll(eventBuilder.onRoleCompleteBuild(context, message));
        }
        events.addAll(eventBuilder.onCompleteBuild(context));
        return eventExecutor.execute(events);
    }


}
