package com.lssl.medical.mapper;

import com.lssl.medical.dto.DoctorDTO;
import com.lssl.medical.dto.DoctorLevelDTO;
import com.lssl.medical.dto.TreatTypeDTO;
import com.lssl.medical.entity.Account;
import com.lssl.medical.entity.Doctor;
import com.lssl.medical.vo.DoctorVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : 黑渊白花
 * @date : 2024/9/25 19:42
 */
@Mapper
public interface DoctorMapper {
    /*获取所有的医师信息*/
    List<DoctorDTO> getAllDoctor(DoctorVo param);
    /*获取所有的医师级别*/
    List<DoctorLevelDTO> getAllLevel();
    /*获取所有的诊治类型*/
    List<TreatTypeDTO> getAllTreatType();
    /*新增医师信息*/
    int saveDoctor(Doctor param);
    /*更新医师信息*/
    int updateDoctor(Doctor param);
    /*根据id删除医师*/
    int deleteDoctorById(Long id);

    Doctor getDoctorById(Long id);


}
