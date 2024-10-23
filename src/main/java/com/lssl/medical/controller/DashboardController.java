package com.lssl.medical.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lssl.medical.bean.Msg;
import com.lssl.medical.service.DashboardService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

/**
 * @author : 黑渊白花
 * @ClassName DashboardController
 * @date : 2024/10/23 20:13
 * @Description
 */
@Api(tags = "数据面板控制器类")
@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin
public class DashboardController {
    @Autowired
    DashboardService dashboardService;


    @RolesAllowed({"1","2"})
    @GetMapping(value = "")
    public Msg getDashboardController(){
        ObjectNode node = dashboardService.getDashboardData();
        return Msg.success().data("data",node);
    }
}
