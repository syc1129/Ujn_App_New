package com.lssl.medical.dto;

import com.lssl.medical.entity.Sale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : 黑渊白花
 * @ClassName SaleDTO
 * @date : 2024/10/23 19:00
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO extends Sale {
    private long total;
}
