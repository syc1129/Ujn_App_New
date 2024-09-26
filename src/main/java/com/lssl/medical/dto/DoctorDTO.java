package com.lssl.medical.dto;

import com.lssl.medical.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : 黑渊白花
 * @ClassName DoctorDTO
 * @date : 2024/9/25 19:40
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO extends Doctor {
    private String treatType;//诊治类型
    private String doctorLevel;//医师级别
}
