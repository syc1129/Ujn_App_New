package com.lssl.medical.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 封装分页查询结果
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult implements Serializable {

    private long total; //总记录数
    private List records; //当前页数据集合
    @JsonIgnore
    private Integer pn = 1; //当前页
    @JsonIgnore
    private Integer size = Integer.MAX_VALUE; //每页大小
    @JsonIgnore
    private String keyword;//查询关键字

}
