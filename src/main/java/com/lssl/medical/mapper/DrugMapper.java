package com.lssl.medical.mapper;

import com.lssl.medical.dto.DrugDTO;
import com.lssl.medical.entity.Drug;
import com.lssl.medical.vo.DrugVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : 黑渊白花
 * @date : 2024/10/23 19:20
 */
@Component
public interface DrugMapper {
    /*查询所有药品同时,封装药品销售地点*/
    List<DrugDTO> getAllDrug(String name);
    /*新增药品信息*/
    int saveDrug(DrugVo drugParam);

    /*根据id更新药店数据*/
    int updateDrugById(Drug sale);

    /*插入该药店的售卖地点*/
    int insertSalePlace(Long drugId, Long[] saleIds);

    /*根据药品id删除对应的售卖地点*/
    int deleteSaleByDrugId(Long drugId);

    int deleteDrugById(Long drugId);
}
