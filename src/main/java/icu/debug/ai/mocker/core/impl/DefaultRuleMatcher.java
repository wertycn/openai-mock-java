package icu.debug.ai.mocker.core.impl;

import icu.debug.ai.mocker.core.iface.RuleMatcher;
import icu.debug.ai.mocker.entity.MockRule;
import icu.debug.ai.mocker.entity.ModelRequest;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-24 4:08
 */
public class DefaultRuleMatcher implements RuleMatcher {
    @Override
    public MockRule match(ModelRequest request) {
        return new MockRule();
    }
}
