package com.lssl.medical.controller;

import com.lssl.medical.bean.Msg;
import com.lssl.medical.service.PermissionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : 黑渊白花
 * @ClassName PermissionController
 * @date : 2024/10/23 20:07
 * @Description
 */
@Api(tags = "权限菜单控制器")
@RestController
@RequestMapping("/api/permissions")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @GetMapping(value = "")
    public Msg getAllPermission(String roleName) {
        return Msg.success().data("permissions", permissionService.getAllPermission(roleName));
    }
}
