package com.lssl.medical.mapper;

import com.lssl.medical.dto.CityDTO;
import com.lssl.medical.dto.CityInfoDTO;
import com.lssl.medical.entity.City;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : 黑渊白花
 * @ClassName CityMapper
 * @date : 2024/10/23 16:18
 * @Description
 */
@Component
public interface CityMapper {
    /*获取所有城市信息,name不为空则模糊查询*/
    List<CityDTO> getAllCity(String name);

    /*根据id查找一个城市信息*/
    City getCityById(Integer id);

    /*添加一个城市信息*/
    int saveCity(CityInfoDTO city);

    /*根据id删除城市信息*/
    int deleteCityById(Integer id);

    /*查询城市是否存在*/
    int checkCityByName(Integer number);
}
