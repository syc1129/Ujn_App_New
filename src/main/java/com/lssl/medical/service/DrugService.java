package com.lssl.medical.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lssl.medical.bean.Msg;
import com.lssl.medical.dto.DrugDTO;
import com.lssl.medical.entity.Drug;
import com.lssl.medical.mapper.DrugMapper;
import com.lssl.medical.vo.DrugVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author : 黑渊白花
 * @ClassName Drugservice
 * @date : 2024/10/23 19:23
 * @Description
 */
@Service
public class DrugService {

    @Autowired
    private DrugMapper drugMapper;

    public PageInfo<DrugDTO> getDrugWithPage(int pn, int size, String name) {
        PageHelper.startPage(pn, size);
        List<DrugDTO> list = drugMapper.getAllDrug(name);
        //list.forEach();
        PageInfo<DrugDTO> info = new PageInfo<>(list,5);
        return info;
    }

    public Msg saveDrug(DrugVo drugParam) {
        drugParam.setCreatetime(new Date());
        drugParam.setUpdatetime(new Date());
        int i = drugMapper.saveDrug(drugParam);
        int j = drugMapper.insertSalePlace(drugParam.getDrugId(), drugParam.getSaleIds());
        //由于前端不好判断插入后的总记录数，所以插入之后返回全部的药品数量
        List<DrugDTO> allDrug = drugMapper.getAllDrug(null);
        drugParam.setTotal((long) allDrug.size());
        if (i > 0 && j > 0) {
            Long num = drugParam.getTotal() % 5 == 0 ? (drugParam.getTotal() / 5) : (drugParam.getTotal() / 5)+1;
            return Msg.success().data("pages",num).mess("添加成功");
        }
        return Msg.fail().mess("添加失败");
    }

    public Msg updateDrug(Long id, DrugVo drugParam) {
        drugParam.setUpdatetime(new Date());
        drugParam.setDrugId(id);
        drugMapper.deleteSaleByDrugId(drugParam.getDrugId());
        drugMapper.insertSalePlace(drugParam.getDrugId(),drugParam.getSaleIds());
        Drug drugEntity = new Drug();
        BeanUtils.copyProperties(drugParam,drugEntity);
        int i = drugMapper.updateDrugById(drugEntity);
        if (i > 0) {
            return Msg.success().mess("修改成功");
        }
        return Msg.fail().mess("修改失败");

    }

    public Msg deleteDrug(Long drugId) {
        int i = drugMapper.deleteDrugById(drugId);
        int j = drugMapper.deleteSaleByDrugId(drugId);
        if (i > 0 && j > 0) {
            return Msg.success().mess("删除成功");
        }
        return Msg.fail().mess("删除失败");

    }



}
