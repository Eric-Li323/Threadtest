package com.lyh.demo05;

/**
 * 测试守护线程
 *  用户线程  守护线程区别：
 *  用户线程：一般创建线程默认都为用户线程，虚拟机执行用户线程时必须执行执行完毕
 *  守护线程： 虚拟机不用等待守护线程执行完毕。（守护线程举例：日志记录、监控内存、垃圾回收）
 * @author lyh
 * @date 2022/5/5
 */
public class TestDaemon {

    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true); //默认是false 表示是用户线程，正常的线程都是用户线程

        thread.start(); //上帝守护线程启动

        new Thread(you).start(); //你  用户线程启动
    }
}

//上帝
class God implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("上帝保佑你");
        }
    }
}

//你
class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36000; i++) {
            System.out.println("你一生都开心的活着");
        }
        System.out.println("======goodbye! world!");
    }
}