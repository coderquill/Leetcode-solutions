/*https://leetcode.com/problems/permutations/

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

*/


class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList();        
        permute(nums, 0);            
        return ans;        
    }
    
    private void permute(int[] nums, int index){                
        if(index == nums.length-1){
            addToAnswer(nums);
            return;
        }
        
        for(int i = index; i < nums.length; i++){                
            //Swap numbers
            swap(nums, i, index);            
            //Continue down tree
            permute(nums, index+1);                            
            //Undo the swap to continue from this position with next number
            swap(nums, i, index);            
        }
    }
    
    /*** Utility functions ***/
    
    public void addToAnswer(int[] nums){
        List<Integer> newList = new ArrayList();
        for(int n : nums){
            newList.add(n);
        }
        ans.add(newList);
    }
    
    public void swap(int[] nums, int i, int j){        
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;        
    }
}
