// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We use stack to solve this problem
// we push the index of the element that we need to find the next greater on to stack
// while we go through the array we check if the element at i is greater than the element on top of the stack
// if yes we put i - top in the result array

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0)
            return new int[] {};
        Stack<Integer> s = new Stack();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!s.isEmpty() && temperatures[s.peek()] < temperatures[i]) {
                int top = s.pop();
                result[top] = i - top;
            }
            s.push(i);
        }
        return result;
    }
}