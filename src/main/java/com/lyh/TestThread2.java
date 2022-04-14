package com.lyh;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 练习Thread,实现多线程同步下载图片
 *
 * @author lyh
 * @date 2022/4/14
 */
public class TestThread2 extends Thread{

    private String url;   //网络图片地址
    private String name;  //保持的文件名

    public TestThread2(String url,String name){
        this.url= url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
    }

    //下载图片线程的执行体
    public static void main(String[] args){
        TestThread2 t1 = new TestThread2("https://img2022.cnblogs.com/blog/1470239/202204/1470239-20220414145634719-1648248220.png","风景1.jpg");
        TestThread2 t2 = new TestThread2("https://img2022.cnblogs.com/blog/1470239/202204/1470239-20220414145634719-1648248220.png","风景2.jpg");
        TestThread2 t3 = new TestThread2("https://img2022.cnblogs.com/blog/1470239/202204/1470239-20220414145634719-1648248220.png","风景3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }


}

//下载器
class WebDownloader{
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
