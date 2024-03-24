package icu.debug.ai.mocker.core.iface;

import icu.debug.ai.mocker.entity.StreamOption;
import icu.debug.ai.mocker.entity.TaskCollection;

/**
 * token 计划
 *
 * @author hanjinxiang@debug.icu
 * @date 2024-03-23 22:59
 */
public interface TokenTaskBuilder {

    TaskCollection build(String content, StreamOption option);
}
