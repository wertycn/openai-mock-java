package icu.debug.ai.mocker.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-23 22:30
 */
@Slf4j
public class ServerSentEvent extends SseEmitter {

    private Consumer<IOException> ioExceptionConsumer;

    public ServerSentEvent() {
        super(30000L);

    }

    public ServerSentEvent(Long timeout) {
        super(timeout);
    }

    public void send(StreamEvent event) {
        try {
            this.send(of(event));
        } catch (IOException e) {
            if (ioExceptionConsumer != null) {
                ioExceptionConsumer.accept(e);
            } else {
                this.completeWithError(e);
            }
        }
    }


    @Override
    protected void extendResponse(ServerHttpResponse outputMessage) {
        super.extendResponse(outputMessage);
        HttpHeaders headers = outputMessage.getHeaders();
        // 重写响应头编码为 text/event-stream;charset=UTF-8 避免浏览器中文乱码
        headers.setContentType(new MediaType(MediaType.TEXT_EVENT_STREAM, StandardCharsets.UTF_8));
    }

    public ServerSentEvent withIOException(Consumer<IOException> ioExceptionConsumer) {
        this.ioExceptionConsumer = ioExceptionConsumer;
        return this;
    }


    public static SseEmitter.SseEventBuilder of(StreamEvent streamEvent) {
        SseEmitter.SseEventBuilder builder = SseEmitter.event();
        if (StringUtils.hasLength(streamEvent.getName())) {
            builder.name(streamEvent.getName());
        }
        if (StringUtils.hasLength(streamEvent.getId())) {
            builder.id(streamEvent.getId());
        }

        if (StringUtils.hasLength(streamEvent.getComment())) {
            builder.comment(streamEvent.getComment());
        }

        return builder.data(streamEvent.getData());
    }

}
