package com.lssl.medical.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lssl.medical.bean.Msg;
import com.lssl.medical.dto.SaleDTO;
import com.lssl.medical.entity.Sale;
import com.lssl.medical.mapper.SaleMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author : 黑渊白花
 * @ClassName SaleService
 * @date : 2024/10/23 19:02
 * @Description
 */
@Service
public class SaleService {

    @Autowired
    private SaleMapper saleMapper;

    public PageInfo<Sale> getSaleWithPage(Integer pn, Integer size, String name) {
        if (pn == null && size == null) {
            pn = 1;
            size = 0;
        }
        PageHelper.startPage(pn, size);
        List<Sale> list = saleMapper.getAllSale(name);
        PageInfo<Sale> info = new PageInfo<>(list,5);
        return info;
    }

    public Msg getSaleById(Integer id) {
        Sale sale = saleMapper.getSaleById(id);
        if(sale == null) {
            return Msg.fail().mess("没有找到");
        }
        return Msg.success().data("sale", sale);
    }

    public Msg saveSale(Sale sale) {
        Date d = new Date();
        sale.setCreatetime(d);
        sale.setUpdatetime(d);
        SaleDTO se = new SaleDTO();
        BeanUtils.copyProperties(sale, se);
        try {
            int i = saleMapper.saveSale(se);
            if (i > 0) {
                Long num = se.getTotal() % 5 == 0 ? (se.getTotal() / 5) : (se.getTotal() / 5)+1;
                return Msg.success().data("pages",num).mess("添加成功");
            }
            return Msg.fail().mess("添加失败");
        } catch (Exception e) {
            return Msg.fail().mess("公司编号已经存在");
        }
    }

    public Msg updateSaleById(Long id, Sale sale) {
        sale.setUpdatetime(new Date());
        sale.setSaleId(id);
        int i = saleMapper.updateSaleById(sale);
        if (i > 0) {
            return Msg.success().mess("修改成功");
        }
        return Msg.fail().mess("修改失败");

    }

    public Msg deleteSaleById(Integer id) {
        int i = saleMapper.deleteSaleById(id);
        if (i > 0) {
            return Msg.success().mess("删除成功");
        } else {
            return Msg.fail().mess("删除失败");
        }

    }




}
