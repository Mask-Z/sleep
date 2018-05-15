package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个含有 n 个整数的数组 S，数列 S 中是否存在元素 a，b，c 和 d 使 a + b + c + d = target ？
 *
 * 请在数组中找出所有满足各元素相加等于特定值 的 不重复 组合。
 *
 * 注意：解决方案集不能包含重复的四元组合。
 *
 * 例如，给定数组 S = [1, 0, -1, 0, -2, 2]，并且给定 target = 0。
 *
 * 示例答案为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 * @author 周云龙
 * @date 2018/4/11 21:46
 */
public class FourSum {

	/**
	 * 4-sum
	 * @param nums
	 * @param target
	 * @return
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();

		//长度小于4,直接返回
		if (null == nums || nums.length < 4){
			return res;
		}

		//排序
		Arrays.sort(nums);

		int len=nums.length;
		//如果4个最小值大于目标 或者 四个最大值小于目标,直接返回
		if (nums[0]* 4 > target || nums[len-1]*4 < target){
			return res;
		}

		for (int i=0;i<len;i++){
			int z1 = nums[i];

			//左右两数相等,continue
			if (i>0 && z1==nums[i-1]){
				continue;
			}

			//z1太小
			if (z1 + 3*nums[len-1]<target){
				continue;
			}


			//z1太大
//			if (z1*4>target || nums[i]+nums[i+1]*3>target){
			if (z1*4>target ){
				break;
			}

//			if (i+3==len-1){
//				if (z1+nums[i+1]+nums[i+2]+nums[i+3]==target){
//					res.add(Arrays.asList(z1,nums[i+1],nums[i+2],nums[i+3]));
//				}
//				break;
//			}
			//z1==target

			if (z1*4==target){
				if (i<len-3&&z1==nums[i+3])
				res.add(Arrays.asList(z1,z1,z1,z1));
				break;
			}
			threeSum(nums,i+1,len-1,target-z1,res,z1);

			
		}



		return res;
	}

	private void threeSum(int[] nums, int i, int len, int target, List<List<Integer>> res, int z1) {
		if (nums[i]* 3 > target || nums[len]*3 < target){
			return ;
		}
		int temp=i;
		for (;i<len;i++){
			int z2=nums[i];
			if (i>temp&&z2==nums[i-1]){
				continue;
			}

			if (z2+2*nums[len]<target){
				continue;
			}

			if (z2*3>target){
				break;
			}

			if (z2*3==target){
				if (i<len-1&&z2==nums[i+2]){
					res.add(Arrays.asList(z1,z2,z2,z2));
				}
				break;
			}
			twoSum(nums,i+1,len,target-z2,res,z1,z2);
		}
	}

	private void twoSum(int[] nums, int i, int len, int target, List<List<Integer>> res, int z1, int z2) {
		if (nums[i]* 2 > target || nums[len]*2 < target){
			return ;
		}
		while (i<len){
			if (nums[i]+nums[len]==target){
				res.add(Arrays.asList(z1,z2,nums[i],nums[len]));
				int x = nums[i];
				while (++i<len&&nums[i]==x){
				}
				int y= nums[len];
				while (i<--len&&nums[len]==y){
				}
			}
			if (nums[i]+nums[len]<target){
				i++;
			}
			if (nums[i]+nums[len]>target){
				len--;
			}
		}
	}

	public static void main(String[] args) {
//		int[] nums={1, 0, -1, 0, -2, 2};
		int[] nums={-1,0,-5,-2,-2,-4,0,1,-2,-9};
		FourSum fourSum=new FourSum();
		List<List<Integer>> lists=fourSum.fourSum(nums,-9);
		System.out.println(lists.size());
	}

}
