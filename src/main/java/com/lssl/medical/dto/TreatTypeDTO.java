package com.lssl.medical.dto;

import com.lssl.medical.bean.PageResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : 黑渊白花
 * @ClassName TreatType
 * @date : 2024/9/25 19:26
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreatTypeDTO extends PageResult {
    private Long id;//诊治类型id
    private String name;//诊治类型名称
}
