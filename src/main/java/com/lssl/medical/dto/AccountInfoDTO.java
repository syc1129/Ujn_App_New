package com.lssl.medical.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : 黑渊白花
 * @ClassName AccountInfoDTO
 * @date : 2024/9/23 15:35
 * @Description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountInfoDTO {
    private String realname;
    private String utype;
}
