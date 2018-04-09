package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 有两个大小为 m 和 n 的排序数组 nums1 和 nums2 。
 * 请找出两个排序数组的中位数并且总的运行时间复杂度为 O(log (m+n)) 。
 * <p>
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 中位数是 2.0
 * <p>
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 中位数是 (2 + 3)/2 = 2.5
 */
public class MedianofTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for (int i : nums1) {
			list1.add(i);
		}

		for (int i : nums2) {
			list2.add(i);
		}
		list1.addAll(list2);
		list1.sort(Integer::compare);
		int size = list1.size();
		if (size % 2 == 0) {
			return (list1.get(size / 2) + list1.get(size / 2 - 1)) / 2.0;
		} else {
			return list1.get(size / 2);
		}
	}

	//别人的答案
	//经典分治算法(https://blog.csdn.net/hk2291976/article/details/51107778)
	public double findMedianSortedArrays(int[] A, int[] B, String overload) {
		int m = A.length;
		int n = B.length;
		if (m > n) { // to ensure m<=n
			int[] temp = A;
			A = B;
			B = temp;
			int tmp = m;
			m = n;
			n = tmp;
		}
		int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
		while (iMin <= iMax) {
			int i = (iMin + iMax) / 2;
			int j = halfLen - i;
			if (i < iMax && B[j - 1] > A[i]) {
				iMin = iMin + 1; // i is too small
			} else if (i > iMin && A[i - 1] > B[j]) {
				iMax = iMax - 1; // i is too big
			} else { // i is perfect
				int maxLeft = 0;
				if (i == 0) {
					maxLeft = B[j - 1];
				} else if (j == 0) {
					maxLeft = A[i - 1];
				} else {
					maxLeft = Math.max(A[i - 1], B[j - 1]);
				}
				if ((m + n) % 2 == 1) {
					return maxLeft;
				}

				int minRight = 0;
				if (i == m) {
					minRight = B[j];
				} else if (j == n) {
					minRight = A[i];
				} else {
					minRight = Math.min(B[j], A[i]);
				}

				return (maxLeft + minRight) / 2.0;
			}
		}
		return 0.0;
	}

	//分治算法(https://blog.csdn.net/hk2291976/article/details/51107778)
	public double findMedianSortedArrays_2(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		//让A数组最短(为了效率，我们肯定是选长度较短的做二分)
		if (m > n) {
			return findMedianSortedArrays_2(B, A);
		}
		int c1, c2, L1 = 0, R1 = 0, L2 = 0, R2 = 0, low = 0, high = 2 * m ;
		while (low <= high) {
			c1 = (low + high) / 2;
			c2 = m + n - c1;
			L1 = c1 == 0 ? Integer.MIN_VALUE : A[(c1 - 1)/2];
			R1 = c1 == 2 * m ? Integer.MAX_VALUE : A[c1/2];
			L2 = c2 == 0 ? Integer.MIN_VALUE : B[(c2 - 1)/2];
			R2 = c2 == 2 * n ? Integer.MAX_VALUE : B[c2/2];
			if (L1 > R2) {
				high = c1 - 1;
			} else if (L2 > R2) {
				low = c1 + 1;
			} else {
				break;
			}
		}

		return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
	}

	public static void main(String[] args) {
		MedianofTwoSortedArrays medianofTwoSortedArrays = new MedianofTwoSortedArrays();
		int[] num1 = new int[]{1, 2,3};
		int[] num2 = new int[]{3, 4};

		System.out.println(medianofTwoSortedArrays.findMedianSortedArrays(num1, num2, ""));
		System.out.println(medianofTwoSortedArrays.findMedianSortedArrays_2(num1, num2));
	}
}
