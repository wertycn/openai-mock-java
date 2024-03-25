package icu.debug.ai.mocker.controller;

import icu.debug.ai.mocker.entity.HttpServletRequestResolver;
import icu.debug.ai.mocker.server.openai.OpenAiMockServer;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
