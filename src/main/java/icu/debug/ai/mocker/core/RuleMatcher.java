package icu.debug.ai.mocker.core;

import icu.debug.ai.mocker.entity.MockRequest;

/**
 * 规则匹配器
 *
 * @author hanjinxiang@debug.icu
 * @date 2024-03-18 23:53
 */
public interface RuleMatcher {

    MockRule match(MockRequest request);

}
