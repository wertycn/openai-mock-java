package icu.debug.ai.mocker.core.iface;

import icu.debug.ai.mocker.entity.MockRule;
import icu.debug.ai.mocker.entity.ModelRequest;

/**
 * 规则匹配器
 *
 * @author hanjinxiang@debug.icu
 * @date 2024-03-18 23:53
 */
public interface RuleMatcher {

    MockRule match(ModelRequest request);

}
