package icu.debug.ai.mocker.config;

import icu.debug.ai.mocker.core.impl.DefaultTokenTaskBuilder;
import icu.debug.ai.mocker.server.openai.OpenAiMockServer;
import icu.debug.ai.mocker.server.openai.OpenAiRequestResolver;
import icu.debug.ai.mocker.server.openai.OpenAiStreamEventBuilder;
import lombok.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-26 1:02
 */
@Configuration
public class DefaultBeanConfiguration {

    @Bean
    public OpenAiMockServer getOpenAiMockServer() {
        return new OpenAiMockServer(new OpenAiRequestResolver(), new OpenAiStreamEventBuilder(new DefaultTokenTaskBuilder()));
    }

}
