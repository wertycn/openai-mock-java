package icu.debug.ai.mocker.server.openai;

import icu.debug.ai.mocker.core.iface.StreamEventBuilder;
import icu.debug.ai.mocker.core.iface.TokenTaskBuilder;
import icu.debug.ai.mocker.core.impl.DefaultTokenTaskBuilder;
import icu.debug.ai.mocker.entity.Context;
import icu.debug.ai.mocker.entity.Message;
import icu.debug.ai.mocker.entity.TaskCollection;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-25 1:06
 */
public class OpenAiStreamEventBuilder implements StreamEventBuilder {

    private final TokenTaskBuilder taskBuilder;

    public OpenAiStreamEventBuilder(DefaultTokenTaskBuilder taskBuilder) {
        this.taskBuilder = taskBuilder;
    }

    @Override
    public TaskCollection build(Context context, Message message) {
        return taskBuilder.build(message.getContent(), context.getRule().getOption());
    }
}
