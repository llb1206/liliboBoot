package com.ThreadPoolExecutors;


import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

public  class Upload {


    public static String handleFileUpload(MultipartFile file) {

       BufferedOutputStream stream = null;
       String filePath = "C:/Users/lilibo/Desktop/F2/";
       // 获取文件名
       String fileName = file.getOriginalFilename();
      // System.out.println("上传的文件名为：" + fileName);
       // 获取文件的后缀名
       String suffixName = fileName.substring(fileName.lastIndexOf("."));
       if (!file.isEmpty()) {
           try {
               if(Thread.currentThread().getName().equals("pool-1-thread-2")){
                   System.out.println(Thread.currentThread().getName()+"正在堵塞**");
                   Thread.sleep(1000000);
               }
               System.out.println(Thread.currentThread().getName()+"正在执行呢");
               byte[] bytes = file.getBytes();
               stream = new BufferedOutputStream(new FileOutputStream(
                       new File(filePath + Thread.currentThread().getName()+"---SSS---"+UUID.randomUUID().toString().replace("-","").substring(1,5)+suffixName)));//设置文件路径及名字
               stream.write(bytes);// 写入
               stream.close();
           } catch (Exception e) {
               stream = null;
           }
       }
       return Thread.currentThread().getName();
   }
}