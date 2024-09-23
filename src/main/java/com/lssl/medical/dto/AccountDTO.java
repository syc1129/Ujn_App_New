package com.lssl.medical.dto;

import com.lssl.medical.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @author : 黑渊白花
 * @ClassName AccountDTO
 * @date : 2024/9/23 15:31
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO extends Account implements UserDetails {
    private String urealName; //用户真实姓名
    private Collection<? extends GrantedAuthority> authorities; //认证集

    public AccountDTO(Long id, String uname, String realname, String role, String pwd, List<GrantedAuthority> auths) {
        super(id, uname, pwd, role);
        this.authorities = auths;
        this.urealName=realname;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return super.getPwd();
    }

    @Override
    public String getUsername() {
        return super.getUname();
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
