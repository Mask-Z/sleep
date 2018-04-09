package com.leetcode;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 S，找出 S 中的三个整数使得他们的和与给定的数 target 最接近。返回这三个数的和。假定每组输入只存在一个答案。
 * <p>
 * 例如，给定数组 S = {-1 2 1 -4}, 并且 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * @author 周云龙
 * @date 2018/4/9 21:13
 */
public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		if(null==nums || nums.length<3){
			throw new IllegalArgumentException("no answer");
		}
		Arrays.sort(nums);
		int sum=nums[0]+nums[1]+nums[2];
		int diff=Math.abs(target-sum);
		for (int i=0;i<nums.length-2;i++){
			int letf=i+1,right=nums.length-1;
			while (letf<right){
				int newSum=nums[i]+nums[letf]+nums[right];
				int newDiff=Math.abs(target-newSum);
				if (diff>newDiff){
					diff=newDiff;
					sum=newSum;
				}
				if (newSum<target){
					letf++;
				}else {
					right--;
				}

			}
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] nums={-1,2,1,-4};
		ThreeSumClosest threeSumClosest=new ThreeSumClosest();
		System.out.println(threeSumClosest.threeSumClosest(nums,1));
	}
}
