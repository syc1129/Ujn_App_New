package com.lssl.medical.util;

import com.lssl.medical.bean.Msg;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

/**
 * @author : 黑渊白花
 * @ClassName FileUpload
 * @date : 2024/10/23 19:35
 * @Description
 */
@Service
public class FileUpload {
    public Msg upload(MultipartFile file){
        OutputStream os = null;
        InputStream inputStream = null;
        String fileName = null;
        int len;
        try {
            inputStream = file.getInputStream();
            fileName = UUID.randomUUID()+file.getOriginalFilename();
            String path = "file:D:\\images\\medical";
            byte[] bs = new byte[1024];
            File tmpFile=new File(path);
            if (!tmpFile.exists()) {
                tmpFile.mkdirs();
            }
            os =new FileOutputStream(tmpFile.getPath()+ File.separator+fileName);
            while((len=inputStream.read(bs))!=-1){
                os.write(bs,0,len);
            }
            os.close();
            inputStream.close();
        } catch (IOException e) {
            return Msg.fail().mess("上传失败");
        }
        String url = "http://localhost:8080/image/"+fileName;
        return Msg.success().mess("上传成功").data("url",url);


    }
}
