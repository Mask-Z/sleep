package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数列，找出其中和为特定值的那两个数。
 * 你可以假设每个输入都只会有一种答案，同样的元素不能被重用。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {

	/**
	 * Approach #1 (Brute Force)
	 *
	 * @param integers
	 * @param target
	 * @return
	 */
	public static Integer[] fun1(Integer[] integers, Integer target) {
		Integer[] result = new Integer[2];
		for (int i = 0; i < integers.length - 1; i++) {
			for (int j = i + 1; j < integers.length; j++) {
				if (integers[i] + integers[j] == target) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		throw new IllegalArgumentException("no two sum solution");
	}

	/**
	 * Approach #2 (Two-pass Hash Table)
	 *
	 * @param integers
	 * @param target
	 * @return
	 */
	public static Integer[] fun2(Integer[] integers, Integer target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < integers.length; i++) {
			map.put(integers[i], i);
		}
		for (int i = 0; i < integers.length; i++) {
			Integer temp = target - integers[i];
			if (map.containsKey(temp) && temp != i) {
				return new Integer[]{i, map.get(temp)};
			}
		}
		throw new IllegalArgumentException("no two sum solution");

	}

	/**
	 * Approach #3 (One-pass Hash Table)
	 *
	 * @param integers
	 * @param target
	 * @return
	 */
	public static Integer[] fun3(Integer[] integers, Integer target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < integers.length; i++) {
			Integer temp = target - integers[i];
			if (map.containsKey(temp)) {
				return new Integer[]{map.get(temp), i};
			}
			map.put(integers[i], i);
		}
		throw new IllegalArgumentException("no two sum solution");

	}
}
