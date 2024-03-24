package icu.debug.ai.mocker.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-23 22:44
 */
@DisplayName("ServerSentEvent对象测试")
class ServerSentEventTest {

    @Test
    @DisplayName("实例构建测试")
    void testCreateServerSentEvent() {
        ServerSentEvent event = new ServerSentEvent();
        event.send(StreamEvent.builder().data("test").build());
        SseEmitter sseEmitter = event.getSseEmitter();
        Long timeout = sseEmitter.getTimeout();
        assertEquals(3600L,timeout);
    }

}