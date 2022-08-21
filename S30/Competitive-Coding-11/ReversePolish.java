// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We make use of a stack to do this 
// we push the digits on to stack
// when we encounter an operator we pop the numbers and do the calculations and put the result back into the stack

class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return 0;
        Stack<Integer> s = new Stack<>();
        int ans = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("*") || tokens[i].equals("+") || tokens[i].equals("/") || tokens[i].equals("-")) {
                if (!s.isEmpty()) {
                    int a = s.pop();
                    int b = s.pop();
                    if (tokens[i].equals("*")) {
                        ans = a * b;
                    } else if (tokens[i].equals("+")) {
                        ans = a + b;
                    } else if (tokens[i].equals("-")) {

                        ans = b - a;
                    } else {
                        ans = b / a;
                    }
                }
                s.push(ans);
            } else
                s.push(Integer.parseInt(tokens[i]));
        }
        return s.pop();
    }
}