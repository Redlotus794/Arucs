package com.rdlts.leetcode.solution;

/**
 * 88. 合并两个有序数组

  You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

  Merge nums1 and nums2 into a single array sorted in non-decreasing order.

  The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.



  Example 1:

  Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
  Output: [1,2,2,3,5,6]
  Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
  The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
  Example 2:

  Input: nums1 = [1], m = 1, nums2 = [], n = 0
  Output: [1]
  Explanation: The arrays we are merging are [1] and [].
  The result of the merge is [1].
  Example 3:

  Input: nums1 = [0], m = 0, nums2 = [1], n = 1
  Output: [1]
  Explanation: The arrays we are merging are [] and [1].
  The result of the merge is [1].
  Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.


  Constraints:

  nums1.length == m + n
  nums2.length == n
  0 <= m, n <= 200
  1 <= m + n <= 200
  -109 <= nums1[i], nums2[j] <= 109
 Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 */
public class _88MergeSortedArray {

     public void merge(int[] nums1, int m, int[] nums2, int n) {
         if (n == 0) {
             // 无需合并
             return;
         } else if (m == 0) {
             // nums1 为空, 直接将nums2 copy过来
             if (n >= 0)  {
                 System.arraycopy(nums2, 0, nums1, 0, n);
             }
         }

         // 双指针后向合并排序
         // 最后的位置一定是一个0个数字，并且由于是排序的，所以只要将最大的放到最后即可
         int indexM = m - 1;
         int indexN = n - 1;

         // 到0结束
         for (int i = m + n - 1 ; i >= 0; i--) {
             if (indexN == -1) {
                 nums1[i] = nums1[indexM];
                 indexM--;
             } else if (indexM == -1) {
                 nums1[i] = nums2[indexN];
                 indexN--;
             } else if (nums1[indexM] >= nums2[indexN]) {
                 nums1[i] = nums1[indexM];
                 indexM--;
             } else if (nums2[indexN] > nums1[indexM]) {
                 nums1[i] = nums2[indexN];
                 indexN--;
             }
         }
     }
}
