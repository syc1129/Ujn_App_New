package com.lssl.medical.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lssl.medical.bean.Msg;
import com.lssl.medical.dto.DoctorDTO;
import com.lssl.medical.dto.DoctorLevelDTO;
import com.lssl.medical.dto.TreatTypeDTO;
import com.lssl.medical.entity.Account;
import com.lssl.medical.entity.Doctor;
import com.lssl.medical.mapper.AccountMapper;
import com.lssl.medical.mapper.DoctorMapper;
import com.lssl.medical.vo.DoctorVo;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : 黑渊白花
 * @date : 2024/9/25 19:49
 */
@Service
@Slf4j
public class DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private AccountMapper accountMapper;
    public Msg getDoctorWithPage(DoctorVo param) {
        if (param.getSize() == 0) {
            param.setSize(1);
        }
        PageHelper.startPage(param.getPn(), param.getSize());
        List<DoctorDTO> list = doctorMapper.getAllDoctor(param);
        PageInfo<DoctorDTO> info = new PageInfo<>(list,5);
        return Msg.success().data("doctorInfo",info);
    }
    public Msg getLevelAndType() {
        List<TreatTypeDTO> allTreatType = doctorMapper.getAllTreatType();
        List<DoctorLevelDTO> allLevel = doctorMapper.getAllLevel();
        return Msg.success().data("allTreatType",allTreatType).data("allLevel",allLevel);
    }

   /**
            * 添加医师，为医师创建账号密码
     * @param param
     * @return
    * */
    public Msg saveDoctor(DoctorVo param) {
        int i,j;
        Account aEntity = new Account();
        aEntity.setPhoneNumber(param.getPhoneNumber());
        aEntity.setUname(param.getName()+param.getPhoneNumber().substring(7));//医生用户名姓名+手机号后四位
        aEntity.setRealname(param.getName());
        aEntity.setPwd(new BCryptPasswordEncoder().encode(param.getPwd()));
        aEntity.setCreatetime(new DateTime().toDate());
        aEntity.setUpdatetime(new DateTime().toDate());
        aEntity.setUtype("ROLE_2");
        int checkPhone = accountMapper.checkPhone(param.getPhoneNumber());
        if (checkPhone > 0) {
            return Msg.fail().code(10001).mess("手机号已被使用");
        }
        try {
            i = accountMapper.regist(aEntity);
        } catch (DuplicateKeyException e) {
            return Msg.fail().mess("该账号已经注册");
        }
        Doctor de = new Doctor();
        BeanUtils.copyProperties(param,de);
        de.setCreateTime(new DateTime().toDate());
        de.setUpdateTime(new DateTime().toDate());
        de.setAccountId(aEntity.getId());
        j = doctorMapper.saveDoctor(de);
        if (i > 0 && j > 0) {
            List<DoctorDTO> allDoctor = doctorMapper.getAllDoctor(null);
            de.setTotal((long) allDoctor.size());
            param.setPwd("");
            Long num = de.getTotal() % 5 == 0 ? (de.getTotal() / 5) : (de.getTotal() / 5)+1;
            return Msg.success().mess("添加成功").data("pages",num).data("addData",param);
        }
        return Msg.fail().mess("添加失败");
    }
    /**
     * 修改医师信息
     * @param param
     * @return
     */
    public Msg updateDoctor(Long id, DoctorVo param) {
        int checkPhone = accountMapper.checkPhone(param.getPhoneNumber());
        if (checkPhone > 0) {
            return Msg.fail().code(10001).mess("手机号已被使用");
        }
        Account ae = new Account();
        ae.setId(param.getAccountId());
        log.info("accountID",param.getAccountId());
        ae.setUpdatetime(new DateTime().toDate());
        ae.setUname(param.getName()+param.getPhoneNumber().substring(7));
        ae.setPhoneNumber(param.getPhoneNumber());
        int j = accountMapper.updateAccount(ae);//
        Doctor de = new Doctor();
        BeanUtils.copyProperties(param, de);
        de.setId(id);
        de.setUpdateTime(new DateTime().toDate());
        int i = doctorMapper.updateDoctor(de);
        if (i > 0 && j > 0) {
            param.setPwd("");
            return Msg.success().mess("修改成功").data("updateData", param);
        }
        return Msg.fail().mess("修改失败");
    }

    /**
     * 根据id删除医师并且删除所在账号
     * @param id
     * @return
     */
    public Msg deleteDoctorById(Long id) {
        int i = doctorMapper.deleteDoctorById(id);
        if (i >= 2) {
            return Msg.success().mess("删除成功").data("deleteDocInfo",1).data("deleteDocAccount",1);
        }
        return Msg.fail().mess("删除失败");
    }

    /**
     * 重置医师密码
     * @param id
     * @return
     */
    public Msg resetPwd(Long id) {
        String newPwd = new BCryptPasswordEncoder().encode("123456");
        int i = accountMapper.resetPwd(id,newPwd);
        if (i > 0) {
            return Msg.success().mess("重置成功");
        }
        return Msg.fail().mess("重置失败");
    }



}
