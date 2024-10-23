package com.lssl.medical.vo;

import com.lssl.medical.entity.Drug;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : 黑渊白花
 * @ClassName DrugVo
 * @date : 2024/10/23 19:19
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugVo extends Drug {
    private Long[] saleIds;//售卖该药品的药店
}
