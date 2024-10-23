package com.lssl.medical.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : 黑渊白花
 * @ClassName City
 * @date : 2024/10/23 15:14
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City  {
    private Long cityId;//城市id
    private Integer cityNumber;//城市编号
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Gmt+8")
    private Date createtime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Gmt+8")
    private Date updatetime;//修改时间
}
