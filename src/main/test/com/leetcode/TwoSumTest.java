package com.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class TwoSumTest {
	@Test
	public void testFun() {
		Integer[] integers = new Integer[]{2, 7, 11, 15};
		Integer target = 9;
		Integer[] result1 = TwoSum.fun1(integers, target);
		Integer[] result2 = TwoSum.fun2(integers, target);
		Integer[] result3 = TwoSum.fun3(integers, target);
		Arrays.asList(result1).forEach(System.out::print);
		Arrays.asList(result2).forEach(System.out::print);
		Arrays.asList(result3).forEach(System.out::print);
	}
}
