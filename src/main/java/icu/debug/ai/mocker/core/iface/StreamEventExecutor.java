package icu.debug.ai.mocker.core.iface;

import icu.debug.ai.mocker.entity.StreamEvent;

import java.util.List;

/**
 * 流式事件输出执行器
 *
 * @author hanjinxiang@debug.icu
 * @date 2024-03-23 22:16
 */
public interface StreamEventExecutor<T> {

    T execute(List<StreamEvent> events);

}
