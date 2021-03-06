/*
https://leetcode.com/problems/max-area-of-island/

Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:

[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.']?{;/[p['['
=';='[[;/.l[;..pki09uj7yt5r33

*/


class Solution {
    
    public int dfs(int[][] grid, int i, int j){
        if(i<0|| i>=grid.length || j<0|| j>=grid[0].length || grid[i][j] == 0)
            return 0;
        else if(grid[i][j] == 1){
            
            
            grid[i][j] = 0;
            int count = 1;
            //System.out.println(grid[i][j]+" i"+i+" j"+j+" count"+count);
             count = count + dfs(grid,i-1, j);
             count = count + dfs(grid,i+1, j);
             count = count + dfs(grid,i, j-1);
             count = count + dfs(grid,i, j+1);
            return count;
        }
        return 0;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    int count = 0;
                    count = dfs(grid,i,j);
                   // System.out.println(" count"+count);
                    area = Math.max(area, count);
                }
                   
            }
        }
        
        return area;
        
    }
    
}
