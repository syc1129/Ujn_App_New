package com.lssl.medical.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lssl.medical.bean.Msg;
import com.lssl.medical.dto.MedicalPolicyDTO;
import com.lssl.medical.entity.MedicalPolicy;
import com.lssl.medical.mapper.MedicalPolicyMapper;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : 黑渊白花
 * @ClassName MedicalPolicyService
 * @date : 2024/10/23 18:20
 * @Description
 */
@Service
public class MedicalPolicyService {
    @Autowired
    private MedicalPolicyMapper medicalPolicyMapper;
    public Msg getMedicalPolicyWithPage(MedicalPolicy param) {
        PageHelper.startPage(param.getPn(),param.getSize());
        List<MedicalPolicyDTO> list = medicalPolicyMapper.getAllPolicy(param);
        PageInfo<MedicalPolicyDTO> info = new PageInfo<>(list,5);
        return Msg.success().data("policyInfo",info);
    }

    public Msg saveMedicalPolicy(MedicalPolicy param) {
        param.setCreatetime(new DateTime().toDate());
        MedicalPolicy mpEntity = new MedicalPolicy();
        BeanUtils.copyProperties(param,mpEntity);
        int i = medicalPolicyMapper.saveMedicalPolicy(mpEntity);
        List<MedicalPolicyDTO> allPolicy = medicalPolicyMapper.getAllPolicy(null);
        mpEntity.setTotal((long) allPolicy.size());
        if (i > 0) {
            Long num = mpEntity.getTotal() % 5 == 0 ? (mpEntity.getTotal() / 5) : (mpEntity.getTotal() / 5)+1;
            return Msg.success().mess("添加成功").data("numberOfAdd",i).data("pages",num);
        }
        return Msg.fail().mess("添加失败");
    }
    public Msg updateMedicalPolicy(Long id, MedicalPolicy param) {
        MedicalPolicy mpEntity = new MedicalPolicy();
        BeanUtils.copyProperties(param, mpEntity);
        mpEntity.setId(id);
        int i = medicalPolicyMapper.updateMedicalPolicy(mpEntity);
        if (i > 0) {
            return Msg.success().mess("修改成功").data("updateData",mpEntity);
        }
        return Msg.fail().mess("修改失败");
    }

    public Msg deleteMedicalPolicy(Long id) {
        int i = medicalPolicyMapper.deleteMedicalPolicy(id);
        if (i > 0) {
            return Msg.success().mess("删除成功").data("numberOfMPolicyDelete",i);
        }
        return Msg.fail().mess("删除失败");
    }


}
