package com.lyh.demo06;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试lock锁
 *
 * @author lyh
 * @date 2022/5/7
 */
public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();

        new Thread(testLock2,"1").start();
        new Thread(testLock2,"2").start();
        new Thread(testLock2,"3").start();

    }
}

class TestLock2 implements Runnable{

    int ticketNums = 10;

    //定义lock锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try{
                //加锁
                lock.lock();
                if(ticketNums>0){
                    System.out.println(Thread.currentThread().getName()+"线程："+ticketNums--);
                }else {
                    break;
                }
            }finally {
                //解锁
                lock.unlock();
            }



        }
    }
}