package com.lssl.medical.dto;

import com.lssl.medical.bean.PageResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : 黑渊白花
 * @ClassName Meta
 * @date : 2024/10/23 15:31
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meta extends PageResult {
    private String title;//菜单title
}
