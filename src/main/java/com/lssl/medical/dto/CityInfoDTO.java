package com.lssl.medical.dto;

import com.lssl.medical.entity.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : 黑渊白花
 * @ClassName CityDTO
 * @date : 2024/10/23 16:16
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityInfoDTO extends City {
    private Long total;
}
