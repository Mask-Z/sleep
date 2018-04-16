package com.first;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 周云龙
 * @date 2018/4/11 8:56
 */
public class FanXing {
    public <E> void fun1(  ){
        List<E> list = new ArrayList<E>();
//        list.add(5);
    }
    class Human{
    }
    class Father extends Human{
    }
    class Son extends Father{
    }
    class LeiFeng extends Father {
    }

    public List<Father> fatherList(){
        return null;
    }
    @Test
    private void fun2(){
        /**
         * 总结:1.extends 可用于返回类型限定，不能用于参数类型限定（换句话说：? extends xxx 只能用于方法返回类型限定，jdk能够确定此类的最小继承边界为xxx，只要是这个类的父类都能接收，但是传入参数无法确定具体类型，只能接受null的传入）。
         *     2.super 可用于参数类型限定，不能用于返回类型限定（换句话说：? supper xxx 只能用于方法传参，因为jdk能够确定传入为xxx的子类，返回只能用Object类接收）。
         *     3.? 既不能用于方法参数传入，也不能用于方法返回。
         */
        List<? extends Father> list1=new ArrayList<>();
        List<? super Father> list2=new ArrayList<>();

        /**
         * ? extends Father, 限定了类型的上限,编译器只知道容器内是Father或者它的派生类，
         * 但具体是什么类型不知道。可能是Father？可能是Son？也可能是LeiFeng，XiaoMing.所以不能使用add()
         * 总结:上界? extends T不能往里存，只能往外取.可以添加null,因为null 可以表示任何类型
         */
//        list1.add(new Father()); error
        list1=fatherList();
        list1.add(null);
        Father father1=list1.get(0);
        /**
         * ? super Father,限定了类型的下限,该类型最细粒度也为Father,所以你可以添加Father及其派生类,
         * (个人理解:此时List<? super Father>就相当于List<Father>),读取出来的东西只能存放在Object类里
         */
        list2.add(new Father());
//        Father father2=list2.get(0); error
        Object father2=list2.get(0);
    }

}
