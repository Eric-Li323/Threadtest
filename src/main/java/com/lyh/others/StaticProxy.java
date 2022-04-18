package com.lyh.others;

import java.sql.SQLOutput;

/**
 * 静态代理模式总结：
 * 真实对象和代理对象都要实现同一个接口
 * 代理对象要代理真实角色
 *
 * 好处：代理对象可以做很多真实对象做不了的事情
 *      真实对象专注做自己的事情
 * @author lyh
 * @date 2022/4/18
 */
public class StaticProxy {

    public static void main(String[] args) {

        You you = new You();//你要结婚
        //类别：
        new Thread( ()-> System.out.println("爱老虎油")).start();

        new WeddingCompany(new You()).HappyMarry();

    }
}

interface Marry{
    void HappyMarry();
}

//真实角色，你去结婚
class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("YOU要结婚了，开心~");
    }
}

//代理角色，帮助你结婚
class WeddingCompany implements Marry{

    //代理谁 -> 真实目标角色
    private Marry target;

    public WeddingCompany(Marry target){
        this.target =target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();//这就是真实对象
        after();
    }

    private void before() {
        System.out.println("结婚之前，布置现场");
    }
    private void after() {
        System.out.println("结婚之后，收尾款");
    }
}


