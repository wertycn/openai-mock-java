package icu.debug.ai.mocker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 任务段
 * <p>
 * 包含一次流式推送的token序列，当前任务在全局任务中的位置，截至到当前任务累计的token数(包含当前任务的token)等信息
 * </p>
 *
 * @author hanjinxiang@debug.icu
 * @date 2024-03-23 15:41
 */
@Getter
@AllArgsConstructor
public class TaskSegment {

    /**
     * 任务段索引
     */
    private int index;

    /**
     * 截至当前任务段,累计token数
     */
    private int summary;

    /**
     * token 集合
     */
    private TokenCollection tokenCollection;

    /**
     * 输出延迟
     */
    private int delay;

    public String content() {
        return tokenCollection.getContent();
    }

    public int count() {
        return tokenCollection.count();
    }

    public TaskSegment next(TokenCollection tokenCollection, int delay) {
        return new TaskSegment(index + 1, summary + tokenCollection.count(), tokenCollection, delay);
    }

    /**
     * 创建一个初始段，用于后续迭代，当前对象本身不可用
     *
     * @return
     */
    public static TaskSegment init() {
        return new TaskSegment(-1, 0, null, 0);
    }

}
