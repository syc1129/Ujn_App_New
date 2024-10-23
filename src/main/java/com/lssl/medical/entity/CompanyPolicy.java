package com.lssl.medical.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lssl.medical.bean.PageResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : 黑渊白花
 * @ClassName CompanyPolicy
 * @date : 2024/10/23 15:10
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyPolicy extends PageResult {
    private Long id;//医药公司政策id
    private String title;//医药公司政策标题
    private String message;//医药公司政策内容
    private Long companyId;//医药公司id
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Gmt+8")
    private Date createTime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Gmt+8")
    private Date updateTime;//发布时间
}
