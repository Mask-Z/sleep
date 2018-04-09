package com.leetcode;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 S，是否存在属于 S 的三个元素 a，b，c 使得 a + b + c = 0 ？找出所有不重复的三个元素组合使三个数的和为零。
 * <p>
 * 注意：结果不能包括重复的三个数的组合。
 * <p>
 * 例如, 给定数组 S = [-1, 0, 1, 2, -1, -4]，
 * 一个结果集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * Create by 周云龙 on 2018/4/8
 */
public class ThreeSum {
	private List<List<Integer>> result = new ArrayList<>();

	/**
	 * K-sum问题
	 *
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		if (null == nums || nums.length < 3) {
			return result;
		}
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i- 1]) {
				continue;
			}
			twoSum(nums, i + 1, nums.length - 1, nums[i]);
		}
		return result;

	}

	private void twoSum(int[] nums, int left, int right, int target) {
		while (left < right) {
			if (nums[left] + nums[right] + target == 0) {
				List<Integer> list = new ArrayList<>();
				list.add(nums[left]);
				list.add(nums[right]);
				list.add(target);
				result.add(list);
				while (left < right && nums[left] == nums[left + 1]) {
					left++;
				}
				while (left < right && nums[right] == nums[right - 1]) {
					right--;
				}
				left++;
				right--;
			} else if (nums[left] + nums[right] + target < 0) {
				left++;
			} else {
				right--;
			}
		}
	}

	public List<List<Integer>> threeSum_2(int[] nums) {
		if(nums == null || nums.length < 3)
			return new LinkedList<>();
		List<List<Integer>> solutions = new LinkedList<>();
		Set<List<Integer>> temp = new HashSet<>();
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 2; i++){
			int j = i+1;
			int k = nums.length-1;
			while (j < k){
				int sum = nums[i] + nums[j] + nums[k];
				if(sum == 0){
					List<Integer> solution = new LinkedList<>();
					solution.add(nums[i]);
					solution.add(nums[j]);
					solution.add(nums[k]);
					temp.add(solution);
					j++;
				}else if(sum > 0){
					k--;
				}else
					j++;
			}
		}
		solutions.addAll(temp);
		return solutions;
	}
	public static void main(String[] args) {
		ThreeSum threeSum = new ThreeSum();
//		int[] nums = {-1, 0, 1, 2, -1, -4};
		int[] nums = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
//		int[] nums = {0,0,0 ,0};
		List<List<Integer>> result = threeSum.threeSum_2(nums);
		System.out.println("OK!" + result.size());

	}
}
