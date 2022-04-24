package com.example.forum.common.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.text.StrBuilder;
import com.example.forum.common.exception.MyBusinessException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author 言曌
 * @date 2022/4/16
 */
public class FileUtil {

    public final static String rootPath = "D:\\upload\\";


    /**
     * 上传文件返回URL
     *
     * @param file
     * @return
     */
    public static String upload(MultipartFile file) {
        String path = "";
        try {
            //用户目录
            final StrBuilder uploadPath = new StrBuilder(rootPath);
            final File mediaPath = new File(uploadPath.toString());
            if (!mediaPath.exists()) {
                if (!mediaPath.mkdirs()) {
                    throw new MyBusinessException("上传失败");
                }
            }

            //不带后缀
            String nameWithOutSuffix = file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf('.')).replaceAll(" ", "_").replaceAll(",", "");

            //文件后缀
            final String fileSuffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.') + 1);

            //带后缀
            String fileName = nameWithOutSuffix + "." + fileSuffix;

            //判断文件名是否已存在
            File descFile = new File(mediaPath.getAbsoluteFile(), fileName);
            int i = 1;
            while (descFile.exists()) {
                nameWithOutSuffix = nameWithOutSuffix + "(" + i + ")";
                descFile = new File(mediaPath.getAbsoluteFile(), nameWithOutSuffix + "." + fileSuffix);
                i++;
            }
            file.transferTo(descFile);

            //文件原路径
            final StrBuilder fullPath = new StrBuilder(mediaPath.getAbsolutePath());
            fullPath.append("/");
            fullPath.append(nameWithOutSuffix + "." + fileSuffix);


            //映射路径
            final StrBuilder filePath = new StrBuilder("/upload/");
            filePath.append(nameWithOutSuffix + "." + fileSuffix);
            path = filePath.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
