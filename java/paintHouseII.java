/*
There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

Example
Example 1

Input:
costs = [[14,2,11],[11,14,5],[14,3,10]]
Output: 10
Explanation:
The three house use color [1,2,1] for each house. The total cost is 10.
Example 2

Input:
costs = [[5]]
Output: 5
Explanation:
There is only one color and one house.
Challenge
Could you solve it in O(nk)?

Notice
All costs are positive integers.
*/


public class Solution {
    /**
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        // write your code here
        if(costs.length == 0  || costs = null){
            return 0;
        }
        int prevMin = 0 , prevSecMin = 0, prevColor = -1;
        
        for(int i = 0; i<costs.length; i++){
            int curMin = Integer.MAX_VALUE;
            int curSecMin = Integer.MAX_VALUE;
            int curCol = -1;
            
            for(int j = 0; j<costs[i].length; j++){
                costs[i][j] = costs[i][j] + (prevColor == j ? prevSecMin : prevMin );
                
                if(costs[i][j] < curMin){
                    curSecMin = curMin;
                    curMin = costs[i][j];
                    curCol = j;
                }else if(costs[i][j] <= curSecMin && costs[i][j]>curMin){
                    curSecMin = costs[i][j];
                }
                prevMin = curMin;
                prevSecMin = curSecMin;
                prevColor = curCol;
                
            }
        }
        
        return prevMin;
    }
}
