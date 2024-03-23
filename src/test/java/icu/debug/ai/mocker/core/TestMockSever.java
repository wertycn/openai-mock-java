package icu.debug.ai.mocker.core;

import icu.debug.ai.mocker.entity.MockRequest;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-19 0:25
 */
class TestMockServer extends AbstractMockServer implements MockServer{

    TestMockServer(RequestResolver requestResolver, RuleMatcher ruleMatcher, ResponseBuilder responseBuilder) {
        super(requestResolver, ruleMatcher, responseBuilder);
    }

    @Override
    public boolean isStream(MockRequest mockRequest, MockRule rule) {
        return false;
    }
}
