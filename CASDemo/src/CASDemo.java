
/*
* CAS是什么
* 比较并交换
*
* UnSafe类和CAS原理   CPU并发原理
* 缺点：循环执行，资源消耗大，只能保证一个共享变量的原子操作。  会导致ABA问题
* 原子引用更新，如果规避 ABA问题  理解原子引用  AtomicReference，时间戳的原子引用
* */

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);


        System.out.println(atomicInteger.compareAndSet(5,2019)+"\t"+"current data:"+atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5,2014)+"\t"+"current data:"+atomicInteger.get());
    }
}
