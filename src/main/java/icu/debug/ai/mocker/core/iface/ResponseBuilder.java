package icu.debug.ai.mocker.core.iface;

import icu.debug.ai.mocker.entity.MockRule;
import icu.debug.ai.mocker.entity.ModelRequest;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * 输出结果构造器
 *
 * @author hanjinxiang@debug.icu
 * @date 2024-03-19 0:04
 */
public interface ResponseBuilder {

    /**
     * 构建流式输出
     *
     * @param rule
     * @param request
     * @return
     */
    SseEmitter buildStream(MockRule rule, ModelRequest request);

    /**
     * 构建普通对象输出
     *
     * @param rule
     * @param request
     * @return
     */
    Object build(MockRule rule, ModelRequest request);

}
