package com.lssl.medical.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lssl.medical.bean.Msg;
import com.lssl.medical.entity.Material;
import com.lssl.medical.mapper.MaterialMapper;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : 黑渊白花
 * @ClassName MaterialService
 * @date : 2024/10/23 19:49
 * @Description
 */
@Service
public class MaterialService {

    @Autowired
    private MaterialMapper materialMapper;

    public Msg getAllMaterialWithPage(Material param) {
        if (param.getSize() == 0) {
            param.setSize(1);
        }
        PageHelper.startPage(param.getPn(), param.getSize());
        List<Material> list = materialMapper.getAllMaterial(param);
        PageInfo<Material> info = new PageInfo<>(list,5);
        return Msg.success().data("materialInfo",info);
    }

    public Msg saveMaterial(Material param) {
        param.setCreatetime(new DateTime().toDate());
        param.setUpdatetime(new DateTime().toDate());
        Material mEntity = new Material();
        BeanUtils.copyProperties(param,mEntity);
        int i = materialMapper.saveMaterial(mEntity);
        List<Material> allMaterial = materialMapper.getAllMaterial(null);
        mEntity.setTotal((long) allMaterial.size());
        if (i > 0) {
            Long num = mEntity.getTotal() % 5 == 0 ? (mEntity.getTotal() / 5) : (mEntity.getTotal() / 5)+1;
            return Msg.success().mess("添加成功").data("numberOfAdd",i).data("pages",num);
        }
        return Msg.fail().mess("添加失败");
    }
    public Msg updateMaterial(Integer id, Material param) {
        Material entity = new Material();
        BeanUtils.copyProperties(param,entity);
        entity.setUpdatetime(new DateTime().toDate());
        entity.setId(id);
        int i = materialMapper.updateMaterial(entity);
        if (i > 0) {
            return Msg.success().mess("修改成功").data("updateData",entity);
        }
        return Msg.fail().mess("修改失败");
    }
    public Msg deleteMaterial(Long id) {
        int i = materialMapper.deleteMaterial(id);
        if (i > 0) {
            return Msg.success().mess("删除成功").data("numberOfDelete",i);
        }
        return Msg.fail().mess("删除失败");
    }

    public List<Material> getFirstMaterialWithPage() {
        PageHelper.startPage(1,4);
        List<Material> list = materialMapper.getAllMaterial(new Material());
        PageInfo<Material> info = new PageInfo<>(list,4);
        return info.getList();
    }
}
