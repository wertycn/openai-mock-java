package icu.debug.ai.mocker.core.impl;

import icu.debug.ai.mocker.entity.StreamOption;
import icu.debug.ai.mocker.entity.TaskCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-24 3:00
 */
@DisplayName("默认Token任务构建器测试")
class DefaultTokenTaskBuilderTest {

    @Test
    @DisplayName("测试任务构建")
    void testTaskBuild() {
        DefaultTokenTaskBuilder builder = new DefaultTokenTaskBuilder();
        StreamOption option = new StreamOption();
        option.setSpeed(1);
        option.setQuantity(new int[]{1});
        TaskCollection collection = builder.build("很久之前", option);
        assertEquals(4,collection.size());



    }
}