package icu.debug.ai.mocker.core;

import icu.debug.ai.mocker.entity.MockRequest;
import jakarta.servlet.http.HttpServletRequest;

/**
 * 抽象mock服务
 *
 * @author hanjinxiang@debug.icu
 * @date 2024-03-19 0:16
 */
public abstract class AbstractMockServer {

    private final RequestResolver requestResolver;
    private final RuleMatcher ruleMatcher;

    private final ResponseBuilder responseBuilder;

    public AbstractMockServer(RequestResolver requestResolver, RuleMatcher ruleMatcher, ResponseBuilder responseBuilder) {
        this.requestResolver = requestResolver;
        this.ruleMatcher = ruleMatcher;
        this.responseBuilder = responseBuilder;
    }

    public Object mock(HttpServletRequest request) {
        MockRequest mockRequest = requestResolver.resolve(request);
        MockRule rule = ruleMatcher.match(mockRequest);
        // TODO: 通过策略工厂代替此处的 if-else
        if (isStream(mockRequest, rule)) {
            return responseBuilder.buildStream(rule, mockRequest);
        }
        return responseBuilder.build(rule, mockRequest);
    }

    protected abstract boolean isStream(MockRequest mockRequest, MockRule rule);

}
