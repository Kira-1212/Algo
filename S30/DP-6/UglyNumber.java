// Time Complexity : O(n(logk))    
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We make use of the HashSet and priority queue to solve this problem

class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1) return n;
        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add((long)1);
        set.add((long)1);
        int count =0;
        long curr =1;
        int[] primes = {2, 3, 5};
        while(count<n){
            curr = pq.poll();
            count++;
            for(int prime : primes){
                long num = prime * curr;
                if(!set.contains(num)){
                    set.add(num);
                    pq.add(num);
                }
            }
        }
        return (int)curr;
    }
}

// Time Complexity : O(n)    
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We make use of an array and three pointers to solve this problem

class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1) return n;
        int[] nums = new int[n];
        int p2 = 0, p3 = 0, p5 = 0;
        int n2 = 2, n3 = 3, n5 = 5;
        nums[0] = 1;
        for(int i = 1 ;i<n; i++){
            int min = Math.min(n2, Math.min(n3,n5));
            nums[i] = min;
            if(n2 == min){
                p2++;
                n2 = nums[p2] * 2;
            }
            if(n3== min){
                p3++;
                n3= nums[p3] * 3;
            }
            if(n5 == min){
                p5++;
                n5 = nums[p5] * 5;
            }
        }
        return nums[n-1];
    }
}