package icu.debug.ai.mocker.core.iface;

import icu.debug.ai.mocker.entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 输出事件
 *
 * @author hanjinxiang@debug.icu
 * @date 2024-03-23 21:41
 */
public interface StreamEventBuilder {

    /**
     * 开始调用事件构建
     *
     * @param context 事件上下文
     * @return 事件列表
     */
    default List<StreamEvent> onStartBuild(Context context) {
        return new ArrayList<>();
    }

    /**
     * 角色消息开始事件构建
     *
     * @param context 事件上下文
     * @param message 角色消息对象
     * @return 事件列表
     */
    default List<StreamEvent> onRoleStartBuild(Context context, Message message) {
        return new ArrayList<>();
    }

    /**
     * 角色消息回答事件构建
     *
     * @param context 事件上下文
     * @param message 角色消息
     * @return 事件列表
     */
    default List<StreamEvent> onRoleAnswerBuild(Context context, Message message) {
        TaskCollection task = build(context, message);
        return task.getTasks().stream().map(item -> formatter(context, message, item)).toList();
    }

    /**
     * token格式化
     */
    default StreamEvent formatter(Context context, Message message, TaskSegment segment) {
        String data = segment.content();
        // 一般情况业务需要结合上下文生成对应的json输出
        return StreamEvent.builder()
                .data(data)
                .build();
    }

    /**
     * 角色消息结束事件构建
     *
     * @param context 事件上下文
     * @param message 角色消息
     * @return 事件列表
     */
    default List<StreamEvent> onRoleCompleteBuild(Context context, Message message) {
        return new ArrayList<>();
    }

    /**
     * 完成事件构建
     *
     * @param context 事件上下文
     * @return 事件列表
     */
    default List<StreamEvent> onCompleteBuild(Context context) {
        return new ArrayList<>();
    }

    TaskCollection build(Context context, Message message);
}
