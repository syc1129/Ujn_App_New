package com.lssl.medical.controller;

import com.lssl.medical.bean.Msg;
import com.lssl.medical.entity.MedicalPolicy;
import com.lssl.medical.service.MedicalPolicyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

/**
 * @author : 黑渊白花
 * @ClassName MedicalPolicyController
 * @date : 2024/10/23 18:21
 * @Description
 */
@Api(tags = "医保政策控制器类")
@RestController
@RequestMapping("/api/medical_policys")
@CrossOrigin
public class MedicalPolicyController {

    @Autowired
    private MedicalPolicyService medicalPolicyService;
    @GetMapping(value = "")
    public Msg getMedicalPolicyWithPage(MedicalPolicy param) {
        Msg msg = medicalPolicyService.getMedicalPolicyWithPage(param);
        return msg;
    }

    @RolesAllowed({"1"})
    @PostMapping(value = "")
    public Msg saveMedicalPolicy(@RequestBody MedicalPolicy param) {
        Msg msg = medicalPolicyService.saveMedicalPolicy(param);
        return msg;
    }

    @RolesAllowed({"1"})
    @PutMapping(value = "/{id}")
    public Msg updateMedicalPolicy(@PathVariable("id") Long id, @RequestBody MedicalPolicy param) {
        if (!StringUtils.hasLength(param.getTitle())) {
            return Msg.fail().mess("标题不能为空");
        }
        if (!StringUtils.hasLength(param.getMessage())) {
            return Msg.fail().mess("内容不能为空");
        }
        if (param.getCityId() == null) {
            return Msg.fail().mess("城市不能为空");
        }
        return medicalPolicyService.updateMedicalPolicy(id, param);
    }

    @RolesAllowed({"1"})
    @DeleteMapping("/{id}")
    public Msg deleteMedicalPolicy(@PathVariable("id") Long id) {
        Msg msg = medicalPolicyService.deleteMedicalPolicy(id);
        return msg;
    }


}
