package com.lssl.medical.mapper;

import com.lssl.medical.dto.CompanyPolicyDTO;
import com.lssl.medical.entity.CompanyPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : 黑渊白花
 * @date : 2024/10/23 15:34
 */
@Component
public interface CompanyPolicyMapper {
    /*查询所有的医药公司政策*/
    List<CompanyPolicyDTO> getAllPolicy(CompanyPolicy param);
    /*新增医药公司政策*/
    int savePolicy(CompanyPolicy entity);
    /*更新医药公司政策*/
    int updatePolicy(CompanyPolicy entity);
    /*删除医药公司政策*/
    int deletePolicy(Long id);
    int deletePolicyByCompany(Long id);
}
