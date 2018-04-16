package com.leetcode;

/**
 * 给定一个有序数组，你需要原地删除其中的重复内容，使每个元素只出现一次,并返回新的长度。
 *
 * 不要另外定义一个数组，您必须通过用 O(1) 额外内存原地修改输入的数组来做到这一点。
 *
 * 示例：
 * 给定数组: nums = [1,1,2],
 * 你的函数应该返回新长度 2, 并且原数组nums的前两个元素必须是1和2
 * 不需要理会新的数组长度后面的元素
 *
 * @author 周云龙
 * @date 2018/4/12 8:54
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {

        if (nums==null||nums.length==0){
            return 0;
        }

        if (nums.length==1){
            return 1;
        }

        int len=nums.length;

        int left=0;
        int right =nums.length-1;

        while (left<right){

            int x=nums[left];
            int y=nums[right];

           while (left+1<right && x==nums[left+1]){
               len--;
               left++;
           }

           while (left<right-1 && y==nums[right--]){
               len--;
               right--;
           }

           left++;
           right--;

        }

        return len;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray array=new RemoveDuplicatesFromSortedArray();
        int[] nums={1,1,2};
        System.out.println(array.removeDuplicates(nums));
    }
}
