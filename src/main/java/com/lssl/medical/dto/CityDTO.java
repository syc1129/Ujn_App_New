package com.lssl.medical.dto;

import com.lssl.medical.entity.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : 黑渊白花
 * @ClassName CityDTO
 * @date : 2024/10/23 16:17
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO extends City {
    private String MerName;//省份
}
