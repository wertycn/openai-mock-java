package icu.debug.ai.mocker.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-23 21:42
 */
@Getter
@Builder
@ToString
public class StreamEvent {

    /**
     * 事件名称
     */
    private String name;


    /**
     * 事件说明
     */
    private String comment;

    /**
     * 事件类型
     */
    private String id;

    /**
     * 事件数据内容
     */
    private String data;

    /**
     * 发送延迟时长(ms)
     */
    private int delayTime;


}
