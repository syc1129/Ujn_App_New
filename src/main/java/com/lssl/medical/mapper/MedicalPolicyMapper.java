package com.lssl.medical.mapper;

import com.lssl.medical.dto.MedicalPolicyDTO;
import com.lssl.medical.entity.MedicalPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : 黑渊白花
 * @date : 2024/10/23 18:15
 */
@Component
public interface MedicalPolicyMapper {

    /*医保政策条件查询*/
    List<MedicalPolicyDTO> getAllPolicy(MedicalPolicy param);
    /*新增医保政策*/
    int saveMedicalPolicy(MedicalPolicy param);

    /*更新医保政策*/
    int updateMedicalPolicy(MedicalPolicy param);

    /*根据id删除医保政策*/
    int deleteMedicalPolicy(Long id);
    /*
        根据城市删除医保政策

    */
    int deleteByCity(Integer city);


}
