package com.lssl.medical.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lssl.medical.bean.PageResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 * @author : 黑渊白花
 * @ClassName Account
 * @date : 2024/9/23 14:59
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account extends PageResult {
    private Long id;
    private String uname;
    private String pwd;
    private String phoneNumber;
    private String utype;   //取值：ROLE_1：管理员、ROLE_2：医生、ROLE_3：患者
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Gmt+8")
    private Date updatetime;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Gmt+8")
    private Date createtime;
    private String realname; //真实姓名

    public Account(Long id, String uname, String pwd, String utype) {
        this.id=id;
        this.uname=uname;
        this.pwd=pwd;
        this.utype=utype;
    }
}
