/*
https://leetcode.com/problems/sliding-window-maximum

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Follow up:
Could you solve it in linear time?

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 

Constraints:

1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
1 <= k <= nums.length

*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] max = new int[len-k+1];
        
        int maxindex = returnMaxIndex(0,k,nums);
        max[0] = nums[maxindex];
        
        for(int i=1;i<len-k+1;i++){
            if(i>maxindex){
                maxindex = returnMaxIndex(i,k,nums);
            }
            else if(nums[i+k-1]>=nums[maxindex]){
                maxindex = i+k-1;
            }
            max[i] = nums[maxindex];
        }
        return max;
    }
    
    public int returnMaxIndex(int start,int k,int[] nums){
        int curmax = Integer.MIN_VALUE;
        int maxindex = start;
        for(int i=0;i<k;i++){
            if(nums[start+i]>=curmax){
                curmax = nums[start+i];
                maxindex = start+i;
            }
        }
        return maxindex;
    }
}
