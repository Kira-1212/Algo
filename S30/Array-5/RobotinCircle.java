// Time Complexity : O(n)    
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We make use of dirs array
// When we encounter R or l we compute a value for i
// We add it to the x and y

class Solution {
    public boolean isRobotBounded(String instructions) {
        if(instructions == null || instructions.length() ==0)
            return true;
        
        int[][] dirs = {{0,1},{1,0},{0,-1}, {-1,0}};
        
        int x =0, y =0;
        int i =0;
        for(int j =0; j<instructions.length(); j++){
            char c = instructions.charAt(j);
            if(c == 'R')
                i = (i+1)%4;
            else if(c == 'L')
                i = (i + 3) % 4;
            else{
                x = x + dirs[i][0];
                y = y + dirs[i][1];
            }
        }
        return (x==0 && y==0) || i !=0;
    }
}