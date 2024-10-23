package com.lssl.medical.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lssl.medical.bean.PageResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : 黑渊白花
 * @ClassName Sale
 * @date : 2024/10/23 15:21
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale extends PageResult {
    private Long saleId;//药店id
    private String saleName;//药店名
    private String salePhone;//药店电话
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Gmt+8")
    private Date createtime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Gmt+8")
    private Date updatetime;//修改时间
}
