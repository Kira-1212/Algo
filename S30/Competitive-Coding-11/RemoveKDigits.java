// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We make use of a stack and greedy approach to do this 
// we can observe that if we remove the numbers that are greater we will get the result( num[i]< num[i-1])
// We use the stack to store the values

class Solution {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0) {
            return "";
        }
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char temp = num.charAt(i);
            while (!s.isEmpty() && k > 0 && s.peek() > temp) {
                k--;
                s.pop();
            }
            s.push(temp);
        }
        for (int i = 0; i < k; i++) {
            s.pop();
        }

        StringBuilder result = new StringBuilder();
        boolean firstZero = true;
        for (char digit : s) {
            if (firstZero && digit == '0')
                continue;
            firstZero = false;
            result.append(digit);
        }

        if (result.length() == 0)
            return "0";
        return result.toString();
    }
}