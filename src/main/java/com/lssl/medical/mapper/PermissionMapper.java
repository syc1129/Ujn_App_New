package com.lssl.medical.mapper;

import com.lssl.medical.dto.PermissionDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : 黑渊白花
 * @date : 2024/10/23 20:00
 */
@Component
public interface PermissionMapper {
    List<PermissionDTO> getPermission(String roleName);
}
