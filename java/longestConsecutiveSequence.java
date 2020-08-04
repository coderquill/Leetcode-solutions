/* https://leetcode.com/problems/longest-consecutive-sequence/

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

*/

class Solution {
    public int longestConsecutive(int[] nums) { 
        Set<Integer> lhs = new LinkedHashSet<Integer>();
        for(int i = 0; i<nums.length; i++){
            lhs.add(nums[i]);
        }
        int max = 0;
        for(int x : lhs){
            if(!lhs.contains(x-1)){
                int m = x+1;
                while(lhs.contains(m)){
                    ++m;
                }
                max = Math.max(max, m-x);
            }
        }
        
        return max;
        
    }
}
