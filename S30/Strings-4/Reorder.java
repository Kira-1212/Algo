// Time Complexity : O(M⋅N⋅logN)   
// Space Complexity : O(M⋅N⋅logN)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We make use of custom comparator to solve this
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if(logs.length == 0 || logs == null){
            return logs;
        
        }
        
        Arrays.sort(logs, (s1,s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if(!isDigit1 && !isDigit2){
                int comp = split1[1].compareTo(split2[1]);
                if(comp == 0)
                    return split1[0].compareTo(split2[0]);
                else{
                    return comp;
                }
            }
            else if(isDigit1 && !isDigit2){
                return 1;
            }
            else if(!isDigit1 && isDigit2){
                return -1;
            }
            else{
                return 0;
            }
            
            
        });
        return logs;
    }
}