package com.lyh;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author lyh
 * @date 2022/4/15
 */
public class TestThread22 implements Runnable{

    private String url;   //网络图片地址
    private String name;  //保持的文件名

    public TestThread22(String url,String name){
        this.url= url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader2 webDownloader = new WebDownloader2();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
    }

    //下载图片线程的执行体
    public static void main(String[] args){
        TestThread22 t1 = new TestThread22("https://img2022.cnblogs.com/blog/1470239/202204/1470239-20220414145634719-1648248220.png","风景1.jpg");
        TestThread22 t2 = new TestThread22("https://img2022.cnblogs.com/blog/1470239/202204/1470239-20220414145634719-1648248220.png","风景2.jpg");
        TestThread22 t3 = new TestThread22("https://img2022.cnblogs.com/blog/1470239/202204/1470239-20220414145634719-1648248220.png","风景3.jpg");

        //不同创建线程方法，启动线程区别
        //继承Thread后，启动线程
        //t1.start();
        //t2.start();
        //t3.start();

        //实现Runnable接口后，启动线程
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }


}

//下载器
class WebDownloader2{
    //下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常,downloader方法出现问题");
        }
    }
}
