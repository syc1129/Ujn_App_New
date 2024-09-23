package com.lssl.medical.handler.secutity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lssl.medical.bean.Msg;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : 黑渊白花
 * @ClassName MyAccessDeniedHandler
 * @date : 2024/9/23 17:16
 * @Description
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(new ObjectMapper().writeValueAsString(Msg.fail().code(10007).mess("无权限访问")));
    }
}
