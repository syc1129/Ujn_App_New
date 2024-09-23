package com.lssl.medical.filter;

import com.lssl.medical.dto.AccountDTO;
import com.lssl.medical.service.UserDetailsServiceImpl;
import com.lssl.medical.util.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author : 黑渊白花
 * @ClassName JwtFilter
 * @date : 2024/9/23 16:45
 * @Description
 */


@Component
@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsServiceImpl userDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        response.setContentType("text/json;charset=utf-8");
        if (StringUtils.hasLength(token)) {
            String uname = null;
            try {
                uname = (String) JwtUtil.getClaims(token).get("uname");
                System.out.println(uname);
            }
            catch (ExpiredJwtException e) {
                log.info("失效身份");
            }
            if (uname != null) {
                String role = (String) JwtUtil.getClaims(token).get("role");
                UserDetails userDetails = userDetailService.loadUserByUsername(uname);
                AccountDTO model = (AccountDTO) userDetails;
                List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(role);
                UsernamePasswordAuthenticationToken authenticationFilter = new UsernamePasswordAuthenticationToken(model, null, grantedAuthorities);
                authenticationFilter.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationFilter);
            }
        }
        filterChain.doFilter(request, response);
    }
}
