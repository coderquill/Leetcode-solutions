/* https://leetcode.com/problems/interval-list-intersections/

Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

 

Example 1:



Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 

Note:

0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9

*/



class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) return new int[0][0];

	int len1 = A.length;
	int len2 = B.length;

	List<int[]> result = new ArrayList<>();

	int index1 = 0, index2 = 0;
	while (index1 < len1 && index2 < len2) {
	
		int[] a = A[index1];
		int[] b = B[index2];

		int start = Math.max(a[0], b[0]);
		int end = Math.min(a[1], b[1]);

		if (start <= end) result.add(new int[] {start, end});

		if (a[1] < b[1]) index1++;
		else index2++;
	}
	return result.toArray(new int[result.size()][]);
        
    }
    
    
}
