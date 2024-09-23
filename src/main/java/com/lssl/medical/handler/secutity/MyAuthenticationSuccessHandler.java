package com.lssl.medical.handler.secutity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lssl.medical.bean.Msg;
import com.lssl.medical.dto.AccountDTO;
import com.lssl.medical.dto.AccountInfoDTO;
import com.lssl.medical.util.JwtUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author : 黑渊白花
 * @ClassName MyAuthenticationSuccessHandler
 * @date : 2024/9/23 17:18
 * @Description
 */
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("text/json;charset=utf-8");
        AccountDTO model = (AccountDTO) authentication.getPrincipal();
        String jwtToken = JwtUtil.getJwtToken(model.getId(), model.getUname(), model.getUtype());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        AccountInfoDTO info1 = new AccountInfoDTO();
        info1.setRealname(model.getUrealName());
        info1.setUtype(model.getUtype());
        info1.setUtype(info1.getUtype().substring("ROLE_".length()));
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("token",jwtToken);
        map.put("userInfo", info1);
        response.getWriter().write(new ObjectMapper().writeValueAsString(Msg.success().mess("登陆成功").data("token",jwtToken).data("userInfo", info1)));
    }
}
