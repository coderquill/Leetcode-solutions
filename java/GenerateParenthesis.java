/*
https://leetcode.com/problems/generate-parentheses/

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] data = new char[n * 2];
        foo(data, 0, n, 0, ans);
        return ans;
    }
    
	/**
	 * open and closed arguments represent the number of available 
	 * open and closed paranthesis during the current invocation of the method.
	 */
    private void foo(char[] data, int index, int open, int closed, List<String> ans) {
        if (index == data.length) {
            ans.add(new String(data));
            return;
        }
            
        if (open > 0) {
            data[index] = '(';
            foo(data, index + 1, open - 1, closed + 1, ans);
        }
        
        if (closed > 0) {
            data[index] = ')';
            foo(data, index + 1, open, closed -1, ans);
        }
    }
    
}
