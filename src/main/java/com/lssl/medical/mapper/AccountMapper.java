package com.lssl.medical.mapper;

import com.lssl.medical.dto.AccountDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : 黑渊白花
 * @date : 2024/9/23 15:35
 */
@Mapper
public interface AccountMapper {
    /*用户登录security*/
    AccountDTO securityLogin(String uname);
}
