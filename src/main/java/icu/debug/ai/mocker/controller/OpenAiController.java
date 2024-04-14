package icu.debug.ai.mocker.controller;

import icu.debug.ai.mocker.entity.HttpServletRequestResolver;
import icu.debug.ai.mocker.entity.ServerSentEvent;
import icu.debug.ai.mocker.entity.StreamEvent;
import icu.debug.ai.mocker.server.openai.OpenAiMockServer;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-18 23:12
 */
@RestController
@RequestMapping("/openai")
public class OpenAiController {

    private final OpenAiMockServer mockServer;

    public OpenAiController(OpenAiMockServer mockServer) {
        this.mockServer = mockServer;
    }

    @RequestMapping("/v1/chat/completions")
    public Object chat(HttpServletRequest request) {
        return mockServer.mock(HttpServletRequestResolver.resolve(request));
    }


    @RequestMapping("/v2/chat/completions/")
    public ServerSentEvent chatV2(HttpServletRequest request) {
        ServerSentEvent serverSentEvent = new ServerSentEvent();
        ExecutorService pool = Executors.newFixedThreadPool(1);
        pool.execute(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    serverSentEvent.completeWithError(e);
                }
                serverSentEvent.send(StreamEvent.builder().data("哈哈" + i).build());
            }
            serverSentEvent.complete();
        });
        return serverSentEvent;
    }
}
