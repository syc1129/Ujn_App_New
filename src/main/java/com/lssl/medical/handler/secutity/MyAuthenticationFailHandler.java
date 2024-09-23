package com.lssl.medical.handler.secutity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lssl.medical.bean.Msg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : 黑渊白花
 * @ClassName MyAuthenticationFailHandler
 * @date : 2024/9/23 17:31
 * @Description
 */
@Component
@Slf4j
public class MyAuthenticationFailHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.info("MyAuthenticationFailHandler.request: "+request);
        log.info("MyAuthenticationFailHandler.response: "+response);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(new ObjectMapper().writeValueAsString(Msg.fail().mess("用户名或密码错误")));
    }
}
