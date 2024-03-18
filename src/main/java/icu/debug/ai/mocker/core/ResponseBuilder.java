package icu.debug.ai.mocker.core;

import icu.debug.ai.mocker.entity.MockRequest;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * 输出结果构造器
 *
 * @author hanjinxiang@debug.icu
 * @date 2024-03-19 0:04
 */
public interface ResponseBuilder<T> {

    /**
     * 构建流式输出
     *
     * @param rule
     * @param request
     * @return
     */
    SseEmitter buildStream(MockRule rule, MockRequest request);

    /**
     * 构建普通对象输出
     *
     * @param rule
     * @param request
     * @return
     */
    T build(MockRule rule, MockRequest request);

}
