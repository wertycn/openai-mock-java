package icu.debug.ai.mocker.server.openai;

import icu.debug.ai.mocker.core.iface.StreamEventBuilder;
import icu.debug.ai.mocker.core.iface.TokenTaskBuilder;
import icu.debug.ai.mocker.core.impl.DefaultTokenTaskBuilder;
import icu.debug.ai.mocker.entity.*;

import java.util.ArrayList;
import java.util.List;

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
    public List<StreamEvent> onRoleStartBuild(Context context, Message message) {
        StreamEvent event = StreamEvent.builder().data("on role start build").build();
        return List.of(event);
    }

    @Override
    public List<StreamEvent> onRoleAnswerBuild(Context context, Message message) {
        List<StreamEvent> res = new ArrayList<>();
        TaskCollection taskCollection = this.taskBuilder.build(message.getContent(), context.getRule().getOption());
        for (TaskSegment task : taskCollection.getTasks()) {
            int delayTime = task.getDelay() + taskCollection.getAvgDelay();
            res.add(StreamEvent.builder().data(task.content()).delayTime(delayTime).build());
        }
        return res;
    }

    @Override
    public List<StreamEvent> onCompleteBuild(Context context) {
        return List.of(StreamEvent.builder().data("[DONE]").build());
    }

    @Override
    public TaskCollection build(Context context, Message message) {
        return taskBuilder.build(message.getContent(), context.getRule().getOption());
    }


}
