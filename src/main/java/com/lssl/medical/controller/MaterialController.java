package com.lssl.medical.controller;

import com.lssl.medical.bean.Msg;
import com.lssl.medical.entity.Material;
import com.lssl.medical.service.MaterialService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

/**
 * @author : 黑渊白花
 * @ClassName MaterialController
 * @date : 2024/10/23 19:50
 * @Description
 */
@Api(tags = "必备材料控制器")
@RestController
@RequestMapping("/api/materials")
@CrossOrigin
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping(value = "")
    public Msg getPolicyWithPage(Material param) {
        Msg msg = materialService.getAllMaterialWithPage(param);
        return msg;
    }
    @RolesAllowed({"1"})
    @PostMapping(value = "")
    public Msg saveMedicalPolicy(@RequestBody Material param) {
        Msg msg = materialService.saveMaterial(param);
        return msg;
    }

    @RolesAllowed({"1"})
    @PutMapping(value = "/{id}")
    public Msg updateMedicalPolicy(@PathVariable("id") Integer id, @RequestBody Material param) {
        if (!StringUtils.hasLength(param.getTitle())) {
            return Msg.fail().mess("标题不能为空");
        }
        if (!StringUtils.hasLength(param.getMessage())) {
            return Msg.fail().mess("内容不能为空");
        }
        return materialService.updateMaterial(id, param);
    }

    @RolesAllowed({"1"})
    @DeleteMapping("/{id}")
    public Msg deletePolicy(@PathVariable("id") Long id) {
        return materialService.deleteMaterial(id);
    }
}
