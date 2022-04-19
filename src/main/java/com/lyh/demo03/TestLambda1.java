package com.lyh.demo03;

/**
 * 推导lambda表达式(lambda表达式的出现过程)
 *
 * @author lyh
 * @date 2022/4/19
 */
public class TestLambda1 {

    //3.静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

        //4.局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }

        like = new Like3();
        like.lambda();

        //5.匿名内部类,没有类的名称，必须借助接口或者父类
        like = new ILike(){
            @Override
            public void lambda() {
                System.out.println("I like lambda4");
            }
        };
        like.lambda();

        //6.用lambda表达式简化 (JDK8 新特性)
        like = ()-> {
            System.out.println("I like lambda5");
        };
        like.lambda();
    }
}

//1.定义一个函数式接口（只有一个抽象方法的接口称为函数式接口）
interface ILike{
    void lambda();
}

//2.实现类
class Like implements ILike{

    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
}