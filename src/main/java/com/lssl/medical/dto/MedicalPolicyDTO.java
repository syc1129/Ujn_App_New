package com.lssl.medical.dto;

import com.lssl.medical.entity.MedicalPolicy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : 黑渊白花
 * @ClassName MedicalPolocyDTO
 * @date : 2024/10/23 18:13
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalPolicyDTO extends MedicalPolicy {
    private CityDTO cityDTO;
}
