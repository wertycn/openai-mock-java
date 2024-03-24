package icu.debug.ai.mocker.server.openai;

import icu.debug.ai.mocker.core.iface.RequestResolver;
import icu.debug.ai.mocker.entity.HttpRequest;
import icu.debug.ai.mocker.entity.ModelRequest;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @author hanjinxiang@debug.icu
 * @date 2024-03-25 1:03
 */
public class OpenAiRequestResolver implements RequestResolver {
    @Override
    public ModelRequest resolve(HttpRequest request) {
        String body = request.getBodyString();
        // TODO: 待完成

        return new ModelRequest();
    }
}
