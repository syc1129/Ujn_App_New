package com.lssl.medical.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lssl.medical.bean.PageResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : 黑渊白花
 * @ClassName Drug
 * @date : 2024/10/23 15:24
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drug extends PageResult {
    private Long drugId;//药品id
    private String drugName;//药品名称
    private String drugInfo;//药品成分信息
    private String drugEffect;//药品功能作用
    private String drugImg;//药品图片url
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Gmt+8")
    private Date createtime;//药品创建时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Gmt+8")
    private Date updatetime;//药品更新时间
    private String drugPublisher;//药品发布者
}
