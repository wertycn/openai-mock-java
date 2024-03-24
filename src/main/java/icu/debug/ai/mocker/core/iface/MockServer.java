package icu.debug.ai.mocker.core.iface;

import icu.debug.ai.mocker.entity.HttpRequest;
import jakarta.servlet.http.HttpServletRequest;

/**
 * mock 服务
 *
 * @author hanjinxiang@debug.icu
 * @date 2024-03-19 0:11
 */
public interface MockServer {

    Object mock(HttpRequest request);

}
