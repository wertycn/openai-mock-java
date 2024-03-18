package icu.debug.ai.mocker.core;

import icu.debug.ai.mocker.entity.MockRequest;
import jakarta.servlet.http.HttpServletRequest;

/**
 * 请求解析器
 *
 * @author hanjinxiang@debug.icu
 * @date 2024-03-18 23:52
 */
public interface RequestResolver {

    /**
     * 转换servlet request对象为MockRequest
     *
     * @param request
     * @return
     */
    MockRequest resolve(HttpServletRequest request);
}
