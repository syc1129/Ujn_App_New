package com.lssl.medical.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lssl.medical.bean.PageResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @author : 黑渊白花
 * @ClassName Doctor
 * @date : 2024/9/25 19:26
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor extends PageResult {
    private Long id;//医师id
    @NotBlank(message = "姓名不能为空")
    @Pattern(regexp = "(^[\u2E80-\u9FFF]{2,4})",message = "姓名只能为汉字,且长度为2-4个汉字")
    private String name;//医师姓名
    @Range(min = 1, max = 130, message = "年龄格式错误")
    @NotNull(message = "年龄不能为空")
    private Integer age;//年龄
    @Range(min = 1, max = 2, message = "性别错误，1代表男，2代表女")
    @NotNull(message = "性别不能为空")
    private Integer sex;//性别：1男，2女
    @NotNull(message = "等级不能为空")
    private Integer levelId;//等级：1主任，2普通
    @NotBlank(message = "手机号不能为空")
    @Length(min = 11, max = 11, message = "手机号格式不正确")
    private String phoneNumber;//电话号
    @NotNull(message = "级别不能为空")
    private Long typeId;//诊治类别id
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Gmt+8")
    private Date createTime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Gmt+8")
    private Date updateTime;//更新时间
    private Long accountId;//账号id
}
