package com.lssl.medical.mapper;

import com.lssl.medical.dto.SaleDTO;
import com.lssl.medical.entity.Sale;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : 黑渊白花
 * @date : 2024/10/23 19:00
 */
@Component
public interface SaleMapper {
    /*获取所有药店信息,name不为空则模糊查询*/
    List<Sale> getAllSale(String name);

    /*根据id查找一个药店信息*/
    Sale getSaleById(Integer id);
    /*添加一个药店信息*/
    int saveSale(SaleDTO sale);

    /*根据id删除药店信息*/
    int deleteSaleById(Integer id);

    /*根据id更新药店数据*/
    int updateSaleById(Sale sale);
}
