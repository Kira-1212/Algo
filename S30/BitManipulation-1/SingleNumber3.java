// Time Complexity : O(n)    
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We make use of bitwise xor, 2's complement and bitwise and  to solve this problem
class Solution {
    public int[] singleNumber(int[] nums) {
      if(nums == null || nums.length == 0)  return new int[]{};
      int xor = 0;
        for(int i =0; i<nums.length; i++){
            xor ^=nums[i];
            
        }
        int temp = xor & (-xor);
        int xor2 = 0;
        for(int num : nums){
            if((temp & num) != 0){
                xor2 = xor2 ^ num;
            }
        }
        return new int[]{xor2, xor ^xor2};
    }
}