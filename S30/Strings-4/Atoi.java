// Time Complexity : O(N)   
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We make use of string operations to solve this
class Solution {
    public int myAtoi(String s) {
        if(s==null || s.length() ==0) return 0;
        s= s.trim();
        if(s.length()==0)return 0;
        
        char first = s.charAt(0);
        char sign ='+';
        int result = 0;
        int limit = Integer.MAX_VALUE/10;
        if(first == '-')
            sign = '-';
        
        if(s.charAt(0)!='+' && sign!='-' && !Character.isDigit(first))
            return 0;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                if(sign == '+'){
                    if(result>limit)return Integer.MAX_VALUE;
                    else if(result==limit){
                        if(c-'0'>7)
                            return Integer.MAX_VALUE;
                    }
                }
                else{
                    if(result>limit)return Integer.MIN_VALUE;
                    else if(result==limit){
                        if(c-'0'>8)
                            return Integer.MIN_VALUE;
                    }
                }
                result = result * 10 + (c-'0');
            }
            else if(i!=0){
                break;
            }
        }
        if(sign == '-') return -result;
        else
            return result;
    }
}