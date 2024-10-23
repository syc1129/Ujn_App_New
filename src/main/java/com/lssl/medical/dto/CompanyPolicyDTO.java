package com.lssl.medical.dto;

import com.lssl.medical.entity.CompanyPolicy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : 黑渊白花
 * @ClassName CompanyPolicyDTO
 * @date : 2024/10/23 15:33
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyPolicyDTO extends CompanyPolicy {
    private DrugCompanyDTO drugCompanyDTO;

}
