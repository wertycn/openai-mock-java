package icu.debug.ai.mocker.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公共端点控制器
 *
 * @author hanjinxiang@debug.icu
 * @date 2024-03-19 0:09
 */
@RestController
public class PublicEndpointController {

    /**
     * 匹配任意规则
     *
     * @param request
     * @return
     */
    //@RequestMapping("*")
    public Object endpoint(HttpServletRequest request) {
        return request;
    }

}
