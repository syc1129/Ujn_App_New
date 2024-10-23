package com.lssl.medical.service;

import com.lssl.medical.dto.PermissionDTO;
import com.lssl.medical.entity.Permission;
import com.lssl.medical.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 黑渊白花
 * @ClassName PermissionService
 * @date : 2024/10/23 20:04
 * @Description
 */
@Service
public class PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;


    public List<PermissionDTO> getAllPermission(String roleName) {
        String finalRoleName = "ROLE_"+roleName;
        List<PermissionDTO> allPermission = permissionMapper.getPermission(finalRoleName.trim());
        PermissionDTO fatherPermisson = new PermissionDTO();
        List<PermissionDTO> finalPermisson = new ArrayList<>();
        for (PermissionDTO per:allPermission) {
            if (per.getPid() == 0) {
                finalPermisson.add(selectChildren(per, allPermission,finalRoleName));
            }
        }
        return finalPermisson;
    }

    public PermissionDTO selectChildren(PermissionDTO father, List<PermissionDTO> allPermission,String finalRoleName) {
        List<Permission> list = new ArrayList<>();
        allPermission.forEach(item -> {
            if (!finalRoleName.equals("ROLE_1")) {
                String title = item.getMeta().getTitle().replace("管理", "查询");
                item.getMeta().setTitle(title);
            }
            if (father.getId() == item.getPid()) {
                father.setChildren(list);
                father.getChildren().add(selectChildren(item, allPermission, finalRoleName));
            }
        });
        return father;
    }

}
