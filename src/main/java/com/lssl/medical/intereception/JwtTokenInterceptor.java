package com.lssl.medical.intereception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * jwt令牌校验的拦截器
 */
@Component
@Slf4j
public class JwtTokenInterceptor implements HandlerInterceptor {

    /**
     * 校验jwt
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断当前拦截到的是Controller的方法还是其他资源
        if (!(handler instanceof HandlerMethod)) {
            //当前拦截到的不是动态方法，直接放行
            return true;
        }
        String token = request.getHeader("Authorization");
        response.setContentType("text/json;charset=utf-8");
        //2、校验令牌
        try {
            log.info("jwt校验:{}", token);
            //Claims claims = JwtUtil.parseJWT(jwtProperties.getAdminSecretKey(), token);
            //Long empId = Long.valueOf(claims.get(JwtClaimsConstant.EMP_ID).toString());
           // BaseContext.setCurrentId(empId);
            //log.info("当前员工id：{}", empId);
            //3、通过，放行
            return true;
        } catch (Exception ex) {
            //4、不通过，响应401状态码
            response.setStatus(401);
            return false;
        }


    }
}
