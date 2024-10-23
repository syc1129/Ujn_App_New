package com.lssl.medical.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lssl.medical.bean.PageResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @author : 黑渊白花
 * @ClassName MedicalPolicy
 * @date : 2024/10/23 15:16
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalPolicy extends PageResult {
    @Pattern(regexp = "(^[0-9]*)", message = "编号只能为数字")
    private Long id;//政策id
    private String title;//政策标题
    private String message;//政策消息
    private Long cityId;//政策的对应城市
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Gmt+8")
    private Date createtime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Gmt+8")
    private Date updatetime;//发布时间
}
