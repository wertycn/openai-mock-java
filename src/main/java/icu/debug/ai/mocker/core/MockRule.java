package icu.debug.ai.mocker.core;

/**
 * 模拟规则对象
 *
 * @author hanjinxiang@debug.icu
 * @date 2024-03-18 23:54
 */
public class MockRule {

    /**
     * 触发条件
     */
    String trigger;

    /**
     * 输出结果
     * TODO: 支持变量替换
     */
    String output;

}
