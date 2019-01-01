class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
     
        for location, value in enumerate(nums):
            if (target - value) in nums[location + 1:]:
                next_location = nums.index(target - value, location + 1)
                return [location, next_location]
        
