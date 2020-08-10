/*
https://leetcode.com/problems/unique-number-of-occurrences/
Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique.

 

Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:

Input: arr = [1,2]
Output: false
Example 3:

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
*/


class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num: arr) {
            if (freq.containsKey(num)) {
                int m = freq.get(num);
                freq.put(num, m + 1);
            }
            else freq.put(num, 1);
        }
        HashMap<Integer, Integer> unique = new HashMap<>();
        for (int f: freq.values()) {
            if (unique.containsKey(f)) return false;
            else unique.put(f, 1);
        }
        return true;
    }
}
