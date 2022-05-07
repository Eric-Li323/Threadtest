package com.lyh.syn;

/**
 * 不安全的取钱
 * 两个人去银行取钱，账户
 * @author lyh
 * @date 2022/5/6
 */
public class UnsafeBank {
    public static void main(String[] args) {
        //账户
        Account account = new Account(100,"结婚基金");

        Drawing you = new Drawing(account,50,"你");
        Drawing girlFfriend = new Drawing(account,100,"girlFfriend");

        you.start();
        girlFfriend.start();
    }
}

//账户
class Account{
    int money; //余额
    String name; //卡名

    public Account(int money,String name){
        this.money = money;
        this.name = name;
    }
}
//银行：模拟取款
class Drawing extends Thread{
    Account account; //账户
    //取了多少钱
    int drawingMoney;
    //现在手里有多少钱
    int nowMoney;

    public Drawing(Account account,int drawingMoney,String name){
        super(name);
        this.account =account;
        this.drawingMoney = drawingMoney;
    }

    //取钱
    //synchronized 默认锁的是this
    @Override
    public void run(){

        //参数填写 需要进行增删改查的共享变量
        synchronized(account){
            //判断有没有钱
            if(account.money-drawingMoney < 0){
                System.out.println(Thread.currentThread().getName()+"钱不够，取不了");
                return;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //卡内余额 = 余额 - 你取的钱
            account.money = account.money -drawingMoney;
            //你手里的钱
            nowMoney = nowMoney + drawingMoney;

            System.out.println(account.name+"余额："+account.money);
            //Thread.currentThread().getName() = this.getName()    这里的this指代 Thread, Drawing类继承了Thread，而Thread类具有get方法获取线程名
            System.out.println(this.getName()+"手里的钱："+nowMoney);
        }
    }
}