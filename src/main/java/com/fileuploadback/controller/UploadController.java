package com.fileuploadback.controller;

import com.fileuploadback.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
public class UploadController {

    @PostMapping("/upload")
    public Result uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return Result.error(0, "文件是空的", null);
        }

        log.info("文件上传 {}", file);

        try {
            String originalFilename = file.getOriginalFilename();
            System.out.println("originalFilename = " + originalFilename);


            Date date = new Date();
            long t = date.getTime();

            // 创建日期格式化对象,在获取格式化对象时可以指定风格
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String str = df.format(date);
            str += Long.toString(t);
            str += "-";
            str += originalFilename;
            System.out.println(str);


            file.transferTo(new File("C:\\Users\\yang99977\\Pictures\\Saved Pictures\\img\\" + str));

            return Result.success();
        } catch (Exception e) {
            log.info("出错了");
            return Result.error(0, "文件上传失败", null);
        }
    }
}
