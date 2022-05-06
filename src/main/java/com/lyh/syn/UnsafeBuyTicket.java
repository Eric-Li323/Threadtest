package com.lyh.syn;

/**
 * 不安全的买票
 *
 * @author lyh
 * @date 2022/5/6
 */
public class UnsafeBuyTicket {

    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station,"我").start();
        new Thread(station,"你们").start();
        new Thread(station,"可恶的黄牛党").start();
    }
}

class BuyTicket implements Runnable{
    //票
    private int ticketNums = 10;
    boolean flag = true; //外部停止模式

    @Override
    public void run() {
        //买票
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void buy() throws InterruptedException {
        //判断是否有票
        if(ticketNums <= 0){
            flag = false;
            return;
        }
        //模拟延时
        Thread.sleep(100);
        //买票
        System.out.println(Thread.currentThread().getName()+"拿到了"+ticketNums--);
    }
}
