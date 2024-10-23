package com.lssl.medical.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lssl.medical.bean.Msg;
import com.lssl.medical.dto.CityDTO;
import com.lssl.medical.dto.CityInfoDTO;
import com.lssl.medical.entity.City;
import com.lssl.medical.mapper.CityMapper;
import com.lssl.medical.mapper.MedicalPolicyMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author : 黑渊白花
 * @ClassName CityService
 * @date : 2024/10/23 16:22
 * @Description
 */
@Service
public class CityService {
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private MedicalPolicyMapper medicalPolicyMapper;
    public PageInfo<CityDTO> getCityWithPage(Integer pn, Integer size, String name) {
        if (pn == null && size == null) {
            pn=1;
            size=0;
        }
        PageHelper.startPage(pn, size);
        List<CityDTO> list = cityMapper.getAllCity(name);
        PageInfo<CityDTO> info = new PageInfo<>(list,5);
        return info;
    }
    public Msg getCityById(Integer id) {
        City city = cityMapper.getCityById(id);

        if(city == null) {
            return Msg.fail().mess("没有找到");
        }
        return Msg.success().data("city", city);
    }

    public Msg saveCity(Integer cityNumber) {
        City city = new City();
        Date d = new Date();
        city.setCityNumber(cityNumber);
        city.setCreatetime(d);
        city.setUpdatetime(d);
        CityInfoDTO ce = new CityInfoDTO();
        BeanUtils.copyProperties(city,ce);//对象拷贝
        int i = cityMapper.saveCity(ce);
        if (i > 0) {
            Long num = ce.getTotal() % 5 == 0 ? (ce.getTotal() / 5) : (ce.getTotal() / 5)+1;
            return Msg.success().data("pages",num).mess("添加成功");
        }
        return Msg.fail().mess("添加失败");
    }

    public Msg deleteCityById(Integer id) {
        int i = cityMapper.deleteCityById(id);
        medicalPolicyMapper.deleteByCity(id);
        if (i > 0) {
            return Msg.success().mess("删除成功");
        } else {
            return Msg.fail().mess("删除失败");
        }
    }

    public int checkCityByName(Integer number) {
        return cityMapper.checkCityByName(number);
    }

}
