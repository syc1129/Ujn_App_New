package com.lssl.medical.controller;

import com.lssl.medical.bean.Msg;
import com.lssl.medical.util.FileUpload;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.RolesAllowed;

/**
 * @author : 黑渊白花
 * @ClassName FileUploadController
 * @date : 2024/10/23 19:35
 * @Description
 */
@Api(tags = "文件上传控制器")
@RestController
@RequestMapping("/api/base/upload")
@CrossOrigin
public class FileUploadController {
    @Autowired
    private FileUpload fileUploadService;

    @RolesAllowed({"1","2"})
    @PostMapping(value = "")
    public Msg fileUpload(MultipartFile file) {
        Msg msg = fileUploadService.upload(file);
        return msg;
    }
}
