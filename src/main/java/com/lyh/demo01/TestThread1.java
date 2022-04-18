package com.lyh.demo01;

/**
 * 创建线程方式一： 1.继承Thread类，并重写run方法
 *               2.调用start方法开启线程
 * 注意：线程开启不一定立即执行，有CPU调度执行
 *
 * @author lyh
 * @date 2022/4/14
 */
public class TestThread1 extends Thread {
    @Override
    public void run() {
        //run方法线程体
        for(int i=0;i< 20;i++){
            System.out.println("在看代码ing---"+i);
        }
    }

    public static void main(String[] args){
        //main线程，主线程

        //创建一个线程对象
        TestThread1 testThread1 = new TestThread1();
        //调用start()方法开启线程
        testThread1.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习多线程--"+i);
        }
    }
}
