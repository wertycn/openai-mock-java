package icu.debug.ai.mocker.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-18 23:12
 */
@RestController
@RequestMapping("/openai")
public class OpenAiController {


    @RequestMapping("/v1/chat/completions")
    public Object chat(HttpServletRequest request) {
        if (isStream()) {
            return new SseEmitter();
        }
        return "";
    }

    private boolean isStream() {
        return false;
    }

}
