package icu.debug.ai.mocker.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

/**
 * 生成配置 用于控制生成速率，延迟等信息
 *
 * @author hanjinxiang@debug.icu
 * @date 2024-03-23 15:26
 */
@Getter
@Setter
@ToString
public class StreamOption {

    private static final Random RANDOM = new Random(1920);

    /**
     * 流式输出速率
     */
    private int speed = 30;

    /**
     * 每次生成的token数,多个随机取一个
     */
    private int[] quantity = {1, 2, 3};

    /**
     * 随机延迟触发概率百分比,[0,100],0不触发，100一定触发
     */
    private int randomDelayRate = 0;

    /**
     * 随机延迟时长，多个随机取一个
     */
    private int[] randomDelayTimes = {0};


    public int nextTokenQuantity() {
        return nextRandomValue(quantity, 1);
    }

    public int nextRandomDelay() {
        int rate = RANDOM.nextInt(100);
        if (randomDelayRate > rate) {
            return 0;
        }
        return nextRandomValue(randomDelayTimes, 0);
    }

    private static int nextRandomValue(int[] arr, int defaultValue) {
        if (arr.length == 0) {
            return defaultValue;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        return arr[RANDOM.nextInt(arr.length - 1)];
    }


}
