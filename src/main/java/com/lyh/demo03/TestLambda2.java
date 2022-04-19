package com.lyh.demo03;

/**
 * @author lyh
 * @date 2022/4/19
 */
public class TestLambda2 {



    public static void main(String[] args) {

        //lambda表达式简化
        ILove love = (int a)-> {
                System.out.println("i love you-->"+a);
            };

        //简化1. 去掉  参数类型
        love = (a)-> {
            System.out.println("i love you-->"+a);
        };
        //简化2. 去掉括号
        love = a -> {
            System.out.println("i love you-->"+a);
        };
        //简化3. 去掉花括号
        love = a -> System.out.println("i love you-->"+a);

        love.love(521);
        //总结：
           //lambda表达式只能有一行代码情况下，才能简化花括号
           //前提是函数式接口（接口内只有一个抽象方法）
           //多个参数也可以去掉参数类型，要去掉就都去掉，但必须加上括号 如： （int a, int b） 简化后 （a,b）

    }
}

interface ILove{
    void love(int a);
}

