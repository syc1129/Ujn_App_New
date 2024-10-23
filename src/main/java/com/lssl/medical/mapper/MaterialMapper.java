package com.lssl.medical.mapper;

import com.lssl.medical.entity.Material;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : 黑渊白花
 * @date : 2024/10/23 19:46
 */
@Component
public interface MaterialMapper {
    /*查询所有的材料*/
    List<Material> getAllMaterial(Material param);

    /*新增材料*/
    int saveMaterial(Material entity);

    /*更新材料*/
    int updateMaterial(Material entity);

    /*删除材料*/
    int deleteMaterial(Long id);
}
