// Time Complexity : O(n2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// we use brute force to solve this
// We take diff of next and present
// We check if the same is true for the next , if yes we increase the count

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3)
            return 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int diff = nums[i + 1] - nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[j + 1] - nums[j] == diff)
                    count++;
                else
                    break;
            }
        }
        return count;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// we use dp to solve this
// We create an 1D array
// We check if i - i-1 == i-1 - i-2
// then we take the i-1 value and 1 we calculate count as count + dp [i]
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3)
            return 0;
        int count = 0;
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            int diff = nums[i + 1] - nums[i];
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                count = count + dp[i];
            }
        }
        return count;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// we use dp to solve this
// Instead of an array we use prev variable
// We check if i - i-1 == i-1 - i-2
// then we take the i-1 value and 1 we calculate count as count + prev
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3)
            return 0;
        int count = 0;
        int n = nums.length;
        int prev = 0;
        for (int i = 2; i < n; i++) {

            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                prev = prev + 1;
                count = count + prev;
            } else {
                prev = 0;
            }
        }
        return count;
    }
}