package com.lssl.medical.controller;

import com.lssl.medical.bean.Msg;
import com.lssl.medical.service.DoctorService;
import com.lssl.medical.vo.DoctorVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

/**
 * @author : 黑渊白花
 * @ClassName DoctorController
 * @date : 2024/9/25 19:54
 * @Description
 */
@RestController
@RequestMapping("/api/doctors")
@CrossOrigin
@Api(tags = "医师控制器类")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @RolesAllowed({"1","2"})
    @GetMapping(value = "")
    public Msg getDoctorWithPage(DoctorVo param) {
        System.out.println(param.toString());
        return doctorService.getDoctorWithPage(param);
    }

    @RolesAllowed({"1","2"})
    @GetMapping("/info")
    public Msg getLevelAndType() {
        return doctorService.getLevelAndType();
    }
    /**
     * 新增医师信息
     * @doctorVo doctorVo
     * @return
     */
    @RolesAllowed({"1","2"})
    @PostMapping(value = "")
    public Msg saveDoctor(@RequestBody @Validated DoctorVo doctorVo){
        return doctorService.saveDoctor(doctorVo);
    }



    /**
     * 修改医师信息
     * @doctorVo doctorVo
     * @return
     */
    @RolesAllowed({"1"})
    @PutMapping("/{id}")
        public Msg updateDoctor(@PathVariable("id") Long id, @RequestBody DoctorVo doctorVo) {
        return doctorService.updateDoctor(id, doctorVo);
    }

    /**
     * 根据id删除医师信息并且删除其账户
     * @param id
     * @return
     */
    @RolesAllowed({"1"})
    @DeleteMapping("{id}")
    public Msg deleteDoctor(@PathVariable("id") Long id) {
        return doctorService.deleteDoctorById(id);
    }

    /**
     * 重置医师密码
     * @param id
     * @return
     */
    @RolesAllowed({"1"})
    @PutMapping("/reset/{id}")
    public Msg resetPwd(@PathVariable Long id) {
        return doctorService.resetPwd(id);
    }




}
