package icu.debug.ai.mocker.core;

import icu.debug.ai.mocker.core.iface.MockServer;
import icu.debug.ai.mocker.core.iface.RequestResolver;
import icu.debug.ai.mocker.core.iface.ResponseBuilder;
import icu.debug.ai.mocker.core.iface.RuleMatcher;
import icu.debug.ai.mocker.core.impl.AbstractMockServer;
import icu.debug.ai.mocker.entity.HttpRequest;
import icu.debug.ai.mocker.entity.MockRule;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-19 0:25
 */
class TestMockServer extends AbstractMockServer implements MockServer {

    TestMockServer(RequestResolver requestResolver, RuleMatcher ruleMatcher, ResponseBuilder responseBuilder) {
        super(requestResolver, ruleMatcher, responseBuilder);
    }

    @Override
    public boolean isStream(HttpRequest httpRequest, MockRule rule) {
        return false;
    }
}
