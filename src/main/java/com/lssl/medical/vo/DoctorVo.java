package com.lssl.medical.vo;

import com.lssl.medical.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : 黑渊白花
 * @ClassName DoctorVo
 * @date : 2024/9/25 19:42
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorVo extends Doctor {
    private String pwd;//新增医师的密码
}
