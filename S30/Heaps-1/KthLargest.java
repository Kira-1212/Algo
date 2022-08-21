// Time Complexity : O(nlog(n-k))
// Space Complexity : O(n-k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approach

// We use priority queue for this
// we add the nums to the pq
// if the size exceeds nums.length - k
// we poll the pq and compare it with result and store the min and return it as result
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int result = Integer.MAX_VALUE;
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > nums.length - k) {
                result = Math.min(result, pq.poll());
            }
        }
        return result;
    }
}