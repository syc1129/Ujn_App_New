package com.lssl.medical.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : 黑渊白花
 * @ClassName DrugCompany
 * @date : 2024/10/20 14:35
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugCompany {
    private Long companyId;//公司id
    private String companyName;//公司名
    private String companyPhone;//公司电话
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Gmt+8")
    private Date updatetime;//更新时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Gmt+8")
    private Date createtime;//创建时间
}
