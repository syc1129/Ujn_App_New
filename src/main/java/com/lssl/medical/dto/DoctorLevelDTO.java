package com.lssl.medical.dto;

import com.lssl.medical.bean.PageResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : 黑渊白花
 * @ClassName DoctorLevel
 * @date : 2024/9/25 19:25
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorLevelDTO extends PageResult {
    private Long id;//级别id
    private String name;//级别名称
}
