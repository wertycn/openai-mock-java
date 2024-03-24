package icu.debug.ai.mocker.core.impl;

import icu.debug.ai.mocker.core.iface.StreamEventExecutor;
import icu.debug.ai.mocker.entity.ServerSentEvent;
import icu.debug.ai.mocker.entity.StreamEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-23 22:27
 */
@Slf4j
public class ServerSentEventExecutor implements StreamEventExecutor<SseEmitter> {

    public static final int CORE_POOL_SIZE = 200;
    private final ExecutorService threadPool;

    public ServerSentEventExecutor(ExecutorService threadPool) {
        this.threadPool = threadPool;
    }

    public ServerSentEventExecutor() {
        this.threadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, CORE_POOL_SIZE, 3600, TimeUnit.SECONDS, new ArrayBlockingQueue<>(CORE_POOL_SIZE));
    }

    @Override
    public SseEmitter execute(List<StreamEvent> events) {
        ServerSentEvent sse = new ServerSentEvent();
        threadPool.execute(() -> {
            for (StreamEvent event : events) {
                try {
                    waitDelay(event.getDelayTime());
                    sse.send(event);
                } catch (Exception e) {
                    log.error("sse send exception:{}", e.getMessage());
                    sse.completeWithError(e);
                }
            }
            sse.complete();
        });
        return sse.getSseEmitter();
    }

    public void waitDelay(int time) {
        if (time < 1) {
            return;
        }
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException("output delay wait thread interrupted!", e);
        }

    }
}
