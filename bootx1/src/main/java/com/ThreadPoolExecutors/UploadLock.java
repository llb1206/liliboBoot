package com.ThreadPoolExecutors;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

class UploadLock implements Runnable{
  
    List<MultipartFile> files;

    public UploadLock(List<MultipartFile> files) {
        this.files = files;
    }

    ReentrantLock lock= new ReentrantLock();  
  
    private  int  i=0;
    @Override
    public void run() {
       while (i<files.size()){
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
         
            lock.lock();
          //  u.handleFileUpload(files,i);
            i++ ;
            lock.unlock();
       }
    }
}
