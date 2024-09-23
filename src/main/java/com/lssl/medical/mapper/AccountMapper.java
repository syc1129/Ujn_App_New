package com.lssl.medical.mapper;

import com.lssl.medical.dto.AccountDTO;
import org.springframework.stereotype.Component;

/**
 * @author : 黑渊白花
 * @date : 2024/9/23 15:35
 */
@Component
public interface AccountMapper {
    /*用户登录security*/
    AccountDTO securityLogin(String uname);
}
