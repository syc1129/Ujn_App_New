package com.lssl.medical.dto;

import com.lssl.medical.entity.Permission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : 黑渊白花
 * @ClassName PermissonDTO
 * @date : 2024/10/23 19:59
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionDTO extends Permission {
    private Meta meta;//存放meta封装的各个属性，icon、title等

}
