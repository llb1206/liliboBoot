package com.ThreadPoolExecutors;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.*;

/**
 * submit 提交的必须是Callable，Future接口才会有返回值  实现Runable不会有------对应Callable，，两者都能执行啊
 * execute只能接受Runnable类型的任务
 * submit不管是Runnable还是Callable类型的任务都可以接受，但是Runnable返回值均为void，所以使用Future的get()获得的还是null
 */
@RestController
public class FileUpload1 {
    public static Integer MaxQUEUE = 10;
    public static Integer MaxPoolSize = 5;
    @PostMapping("/batch")
    public void handleFileUpload(HttpServletRequest request) throws InterruptedException{

        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, MaxPoolSize, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(MaxQUEUE - MaxPoolSize), RejectPolicy.discardPolicy);
        final CountDownLatch dataLatch = new CountDownLatch(files.size());// 创建文件计数器 必须记完数，主线程等待等待状态才会结束
        for (MultipartFile f : files) {
            System.out.println("添加了一个线程");
            Runnable r = () -> {
                // TODO Auto-generated method stub
                Upload.handleFileUpload(f);
                dataLatch.countDown();// 执行完就删除一个
            };
            executor.submit(r);//使用call无法 多线程
//            Future future = executor.submit(r);
//            System.out.println(future.get());
        }
        dataLatch.await();// 等待线程执行完毕
        executor.shutdown();
        System.out.println("结束");
    }
}
