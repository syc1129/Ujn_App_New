package com.lssl.medical.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lssl.medical.bean.Msg;
import com.lssl.medical.dto.CompanyPolicyDTO;
import com.lssl.medical.entity.CompanyPolicy;
import com.lssl.medical.mapper.CompanyPolicyMapper;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : 黑渊白花
 * @ClassName CompanyPolicyService
 * @date : 2024/10/23 15:42
 * @Description
 */
@Service
public class CompanyPolicyService {
    @Autowired
    private CompanyPolicyMapper companyPolicyMapper;
    public Msg getAllPolicyWithPage(CompanyPolicy param) {
        if (param.getSize() == 0) {
            param.setSize(1);
        }
        PageHelper.startPage(param.getPn(), param.getSize());
        List<CompanyPolicyDTO> list = companyPolicyMapper.getAllPolicy(param);
        PageInfo<CompanyPolicyDTO> info = new PageInfo<>(list,5);
        return Msg.success().data("policyInfo",info);
    }

    public Msg savePolicy(CompanyPolicy param) {
        param.setCreateTime(new DateTime().toDate());
        param.setUpdateTime(new DateTime().toDate());
        CompanyPolicy mpEntity = new CompanyPolicy();
        BeanUtils.copyProperties(param,mpEntity);
        int i = companyPolicyMapper.savePolicy(mpEntity);
        List<CompanyPolicyDTO> allPolicy = companyPolicyMapper.getAllPolicy(null);
        mpEntity.setTotal((long) allPolicy.size());
        if (i > 0) {
            Long num = mpEntity.getTotal() % 5 == 0 ? (mpEntity.getTotal() / 5) : (mpEntity.getTotal() / 5)+1;
            return Msg.success().mess("添加成功").data("numberOfAdd",i).data("pages",num);
        }
        return Msg.fail().mess("添加失败");
    }

    public Msg updatePolicy(Long id, CompanyPolicy param) {
        CompanyPolicy entity = new CompanyPolicy();
        BeanUtils.copyProperties(param,entity);
        entity.setUpdateTime(new DateTime().toDate());
        entity.setId(id);
        int i = companyPolicyMapper.updatePolicy(entity);
        if (i > 0) {
            return Msg.success().mess("修改成功").data("updateData",entity);
        }
        return Msg.fail().mess("修改失败");
    }

    public Msg deletePolicy(Long id) {
        int i = companyPolicyMapper.deletePolicy(id);
        int j =companyPolicyMapper.deletePolicyByCompany(id);
        if (i > 0) {
            return Msg.success().mess("删除成功").data("numberOfDelete",i);
        }
        return Msg.fail().mess("删除失败");
    }

    public List<CompanyPolicyDTO> getFirstPolicyWithPage() {
        PageHelper.startPage(1, 4);
        List<CompanyPolicyDTO> list = companyPolicyMapper.getAllPolicy(new CompanyPolicy());
        PageInfo<CompanyPolicyDTO> info = new PageInfo<>(list,4);
        return info.getList();
    }


}
