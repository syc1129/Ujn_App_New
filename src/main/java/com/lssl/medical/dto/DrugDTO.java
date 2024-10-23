package com.lssl.medical.dto;

import com.lssl.medical.entity.Drug;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : 黑渊白花
 * @ClassName DrugDTO
 * @date : 2024/10/23 19:19
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugDTO extends Drug {
    private List<SaleDTO> drugSales;//销售该药的药店地址（集合类型，有多个）

    private String drugSale;//销售该药的药店地址（字符串类型，有多个）
}
