// Time Complexity : O(exponential)   
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We can solve this using bfs
class Solution {
    public int brokenCalc(int startValue, int target) {
        if(startValue == target) return 0;
        int ops =1;
        Queue<Integer> q = new LinkedList<>();
        q.add(startValue);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i<size; i++){
                int curr = q.poll();
                if(curr -1 == target || 2*curr == target)
                    return ops;
                if(curr > target){
                    q.add(curr-1);

                }
                else{
                    q.add(curr -1);
                    q.add(curr *2);

                }
            }
            ops++;
        }
        return 7378134;
    }
}

// Time Complexity : O(logn)   
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We can solve this greedy and complementary operations
class Solution {
    public int brokenCalc(int startValue, int target) {
        if(startValue == target) return 0;
        int count =0;
        while(target>startValue){
            if(target%2 ==0)
                target/=2;
            else
                target+=1;
            count++;
                
        }
        return count+startValue-target;
    }
}