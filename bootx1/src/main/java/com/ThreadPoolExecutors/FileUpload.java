package com.ThreadPoolExecutors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class FileUpload {
    @PostMapping("/batch/ss")
    public void handleFileUpload(HttpServletRequest request) throws InterruptedException {

        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        final CountDownLatch dataLatch = new CountDownLatch(files.size());//创建文件计数器  必须记完数，主线程等待等待状态才会结束
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(files.size());
        for (MultipartFile f : files) {
            System.out.println("ka**-*-*-");
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    Upload.handleFileUpload(f);
                    dataLatch.countDown();//执行完就删除一个
                }
            };
            fixedThreadPool.execute(r);
        }
        dataLatch.await();//等待线程执行完毕
        fixedThreadPool.shutdown();
        System.out.println("结束");
    }
}
