package com.leetcode;

/**
 * 给定 n 个正整数 a1，a2，...，an，其中每个点的坐标用（i, ai）表示。 画 n 条直线，使得线 i 的两个端点处于（i，ai）和（i，0）处。
 * 请找出其中的两条直线，使得他们与 X 轴形成的容器能够装最多的水。
 * 注意：你不能倾斜容器，n 至少是2。
 *
 * Create by 周云龙 on 2018/4/8
 */
public class ContainerWithMostWater {

	/**
	 * 穷举法O(n2)
	 * @param height
	 * @return
	 */
	public int maxArea_1(int[] height) {
		int maxArea=0;
		int len=height.length;
		for (int i=0;i<len-1;i++){
			for (int j=0;j<len;j++){
				maxArea=Math.max(maxArea,Math.min(height[i],height[j])*(j-i));
			}
		}
		return maxArea;
	}


	/**
	 * O(n)
	 * @param height
	 * @return
	 */
	public int maxArea_2(int[] height) {
		int maxArea=0;
		int low=0;
		int high=height.length-1;
		while (low<high){
			maxArea=Math.max(maxArea,Math.min(height[low],height[high])*(high-low));
			if (height[low]<=height[high]){
				low++;
			}else {
				high--;
			}
		}
		return maxArea;
	}


	public static void main(String[] args) {
		int[] height={10,8,1,1,1,1,1,1,2,1};
		ContainerWithMostWater containerWithMostWater=new ContainerWithMostWater();
		System.out.println(containerWithMostWater.maxArea_1(height));
		System.out.println(containerWithMostWater.maxArea_2(height));
	}
}
