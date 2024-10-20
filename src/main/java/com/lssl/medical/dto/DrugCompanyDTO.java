package com.lssl.medical.dto;

import com.lssl.medical.entity.DrugCompany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : 黑渊白花
 * @ClassName DrugCompanyDTO
 * @date : 2024/10/20 14:40
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugCompanyDTO extends DrugCompany {
    private long total;
}
