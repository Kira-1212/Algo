// Time Complexity : O(n)    
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We make use of bitwise xor to solve this problem

class Solution {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for(int i = 1; i<nums.length; i++){
            result^= nums[i];
        }
        return result;
    }
    
}