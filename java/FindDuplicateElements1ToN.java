/* https://leetcode.com/problems/find-all-duplicates-in-an-array/

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

*/




class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> ans = new ArrayList<Integer>();
        
        for(int i = 0; i<nums.length; i++){
            if(nums[Math.abs(nums[i])-1]<0){
                ans.add(Math.abs(nums[i]));
            }else{
                nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
            }
        }
        return ans;
        
        
        
        /*
        
        using hashset:
        
        Set<Integer> s = new HashSet<Integer>();
        List<Integer> ans = new ArrayList<Integer>();
        for(int x : nums){
            if(s.contains(x)){
                ans.add(x);
            }else{
                s.add(x);
            }
        }
        return ans;*/
    }
}
