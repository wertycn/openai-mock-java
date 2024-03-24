package icu.debug.ai.mocker.entity;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-23 22:30
 */
public class ServerSentEvent {

    private final SseEmitter sseEmitter;

    public ServerSentEvent() {
        sseEmitter = new SseEmitter(3600L);
    }

    public ServerSentEvent(SseEmitter emitter) {
        sseEmitter = emitter;
    }

    public void send(StreamEvent event) {
        try {
            sseEmitter.send(event);
        } catch (IOException e) {
            sseEmitter.completeWithError(e);
        }
    }

    public void complete() {
        sseEmitter.complete();
    }

    public void completeWithError(Throwable e) {
        sseEmitter.completeWithError(e);
    }

    public static SseEmitter.SseEventBuilder of(StreamEvent streamEvent) {
        SseEmitter.SseEventBuilder builder = SseEmitter.event();
        if (!StringUtils.hasLength(streamEvent.getName())) {
            builder.name(streamEvent.getName());
        }
        if (!StringUtils.hasLength(streamEvent.getId())) {
            builder.id(streamEvent.getId());
        }

        if (!StringUtils.hasLength(streamEvent.getComment())) {
            builder.comment(streamEvent.getComment());
        }

        return builder.data(streamEvent.getData());
    }

    public SseEmitter getSseEmitter() {
        return sseEmitter;
    }
}
