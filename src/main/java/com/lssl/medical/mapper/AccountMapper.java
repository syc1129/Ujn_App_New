package com.lssl.medical.mapper;

import com.lssl.medical.dto.AccountDTO;
import com.lssl.medical.entity.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : 黑渊白花
 * @date : 2024/9/23 15:35
 */
@Mapper
public interface AccountMapper {
    /*用户登录security*/
    AccountDTO securityLogin(String uname);
    /*重置密码*/
    int resetPwd(Long id, String pwd);
    /*注册账号*/
    int regist(Account entity);
    /*更新账户信息*/
    int updateAccount(Account entity);
    /*校验手机号存在*/
    int checkPhone(String phone);
}
