
// Time Complexity : O(n2)    
// Space Complexity : O(n2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We make use of 2d boolean dp array to solve this problem

class Solution {
    public String longestPalindrome(String s) {
       if(s.length() ==0 || s == null)  return "";
        int n = s.length();
        int max=0, start = 0, end =0;
       boolean[][] dp = new boolean[n][n];
        for(int i =0; i<n; i++){
            for(int j =0; j<=i; j++){
                if(s.charAt(i) == s.charAt(j) && ((i-j-1<2) || (dp[i-1][j+1]))){
                    dp[i][j] = true;
                    if(i-j+1>max){
                        max = i-j+1;
                        start = j;
                        end = i;
                    }
                }
            }
        }
        return s.substring(start,end + 1);
    }
}

// Time Complexity : O(n2)    
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We make use of 2 pointers left and right to expand around the center to solve this

class Solution {
    int max, start, end, n;
    public String longestPalindrome(String s) {
       if(s.length() ==0 || s == null)  return "";
       n = s.length();
        for(int i =0; i<n; i++){
            extendAroundCenter(s, i ,i);
            if(i+1<n && s.charAt(i) == s.charAt(i+1)){
                extendAroundCenter(s, i, i+1);
            }
        }
      
        return s.substring(start,end + 1);
    }
    public void extendAroundCenter(String s, int left, int right){
        while(left>=0 && right<n && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        left++;
        right--;
        if(max<right-left+1){
            max = right-left+1;
            start = left;
            end = right;
        }
    }
}