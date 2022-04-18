package com.lyh.demo02;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * 线程创建方式三：实现callable接口
 *
 * callable的优点：
 *               1.可以定义返回值
 *               2.可以抛出异常
 * @author lyh
 * @date 2022/4/18
 */
public class TestCallable implements Callable<Boolean> {

    private String url;   //网络图片地址
    private String name;  //保持的文件名

    public TestCallable(String url,String name){
        this.url= url;
        this.name = name;
    }

    //下载图片线程的执行体
    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
        return true;
    }

    //下载图片线程的执行体
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://img2022.cnblogs.com/blog/1470239/202204/1470239-20220414145634719-1648248220.png","风景1.jpg");
        TestCallable t2 = new TestCallable("https://img2022.cnblogs.com/blog/1470239/202204/1470239-20220414145634719-1648248220.png","风景2.jpg");
        TestCallable t3 = new TestCallable("https://img2022.cnblogs.com/blog/1470239/202204/1470239-20220414145634719-1648248220.png","风景3.jpg");

        //创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> result1 = service.submit(t1);
        Future<Boolean> result2 = service.submit(t2);
        Future<Boolean> result3 = service.submit(t3);
        //获取结果
        boolean r1 = result1.get();
        boolean r2 = result2.get();
        boolean r3 = result3.get();

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        //关闭服务
        service.shutdownNow();

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
