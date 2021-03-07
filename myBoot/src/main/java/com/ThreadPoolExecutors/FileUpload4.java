package com.ThreadPoolExecutors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@RestController
public class FileUpload4 {
    @PostMapping("/batch/c3")
    public void handleFileUpload(HttpServletRequest request) throws InterruptedException, ExecutionException {
    	List<String> result = new ArrayList<>();
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), RejectPolicy.abortPolicy);
        final CountDownLatch dataLatch = new CountDownLatch(files.size());// 创建文件计数器 必须记完数，主线程等待等待状态才会结束
        for (MultipartFile f : files) {
            Callable r = () -> {
                // TODO Auto-generated method stub
                String str = Upload.handleFileUpload(f);
				result.add(str);
                dataLatch.countDown();// 执行完就删除一个
                return str;
            };
			System.out.println("tijiao");
            Future<String> future = executor.submit(r);
            System.out.println(future.get());
        }
        dataLatch.await();// 等待线程执行完毕
        executor.shutdown();
        System.out.println("结束");
    }
}
