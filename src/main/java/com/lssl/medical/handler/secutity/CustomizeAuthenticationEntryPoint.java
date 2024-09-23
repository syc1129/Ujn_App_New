package com.lssl.medical.handler.secutity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lssl.medical.bean.Msg;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : 黑渊白花
 * @ClassName CustomizeAuthenticationEntryPoint
 * @date : 2024/9/23 17:11
 * @Description
 */
@Component
public class CustomizeAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(new ObjectMapper().writeValueAsString(Msg.fail().mess("未登录或登录失效").code(10006)));
    }

}
