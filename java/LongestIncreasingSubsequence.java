/*

https://leetcode.com/problems/longest-increasing-subsequence

Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.

*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] p = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            p[i] = 1;
        }
        
        for(int i = 1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[j]<nums[i]){
                    p[i] = Math.max(p[i], p[j]+1);
                }
            }
        }
        int max = 0;
        for(int i = 0; i<nums.length; i++){
            max = Math.max(p[i], max);
        }
        
        return max;
    }
}
