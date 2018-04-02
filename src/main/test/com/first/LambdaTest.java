package com.first;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author 周云龙
 * @date 2018/4/2 13:52
 */
public class LambdaTest {

    private List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

    @Test
    public void lambda1() {
        int a = 10;

        for (; a > 0; a--) {
            com.first.Test test = (b) -> System.out.println("hello world" + b);
            test.test1(a);
        }
    }

    @Test
    public void lambda2() {
        list.forEach(System.out::println);
        int sum = list.stream().map(x -> x * x).reduce((x, y) -> x + y).get();
        System.out.println(sum);
    }

    @Test
    public void lambda3() {
        sum(list, n -> true);
        sum(list, n -> n % 2 == 0);
        sum(list, n -> n > 3);
    }

    public void sum(List<Integer> list, Predicate<Integer> predicate) {
        Integer sum = 0;
        for (int i : list) {
            if (predicate.test(i)) {
                sum += i;
            }
        }
        System.out.println(sum);

        System.out.println(list.stream().reduce((x, y) -> {
            if (predicate.test(x)) {
                return x + y;
            } else {
                return y;
            }
        }).get());


    }
}
