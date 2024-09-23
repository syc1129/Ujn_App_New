package com.lssl.medical.service;

import com.lssl.medical.dto.AccountDTO;
import com.lssl.medical.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : 黑渊白花
 * @ClassName UserDetailsServiceImpl
 * @date : 2024/9/23 16:24
 * @Description
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AccountMapper accountMapper;
    /**
     * 用于对登录用户进行验证以及权限获取，如果不存在则抛出用户不存在异常，否则将用户权限集赋给用户
     * @param username 用户id
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountDTO accountModel = accountMapper.securityLogin(username);
        if (accountModel == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        String role = accountModel.getUtype();
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList(role);
        System.out.println(accountModel.getRealname());
        return new AccountDTO(accountModel.getId(),accountModel.getUname(),accountModel.getRealname(), role,
                new BCryptPasswordEncoder().encode(accountModel.getPassword()), auths);
    }
}
