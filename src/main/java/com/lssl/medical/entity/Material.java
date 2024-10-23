package com.lssl.medical.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lssl.medical.bean.PageResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : 黑渊白花
 * @ClassName Material
 * @date : 2024/10/23 15:28
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Material extends PageResult {
    private Integer id;//材料id
    private String title;//材料标题
    private String message;//材料内容
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Gmt+8")
    private Date createtime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Gmt+8")
    private Date updatetime;//更新时间
}
