package icu.debug.ai.mocker.entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * 任务集合
 *
 * @author hanjinxiang@debug.icu
 * @date 2024-03-23 15:27
 */
@Getter
public class TaskCollection {

    /**
     * 任务段列表
     */
    private List<TaskSegment> tasks = new ArrayList<>();

    /**
     * 总token数
     */
    private int summary;

    /**
     * 每秒生成token数
     */
    private int speed;

    /**
     * 任务间平均延迟(ms)
     */
    private int avgDelay;

    public TaskCollection(List<TaskSegment> segments, int speed) {
        this.tasks = segments;
        this.summary = sum(segments);
        this.speed = speed;
        this.avgDelay = summary * 1000 / (speed * tasks.size());
    }

    public List<TaskSegment> getTasks() {
        return new ArrayList<>(tasks);
    }

    public int size() {
        return tasks.size();
    }

    private static int sum(List<TaskSegment> segments) {
        int res = 0;
        for (TaskSegment segment : segments) {
            res += segment.count();
        }
        return res;
    }
}
