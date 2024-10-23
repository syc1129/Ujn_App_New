package com.lssl.medical.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lssl.medical.bean.PageResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : 黑渊白花
 * @ClassName Permission
 * @date : 2024/10/23 15:30
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission extends PageResult {
    @JsonIgnore
    private Integer id;//菜单id
    @JsonIgnore
    private Integer pid;//菜单父id
    private String path;//菜单路径
    private String name;//菜单name
    private String component;//菜单组件
    @JsonIgnore
    private Integer level;//菜单级别
    private List<Permission> children;//子菜单
}
