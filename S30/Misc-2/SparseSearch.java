// "static void main" must be defined in a public class.
public class Main {
    public static int binarySearch(String[] strs, String s){
        int low = 0;
        int high = strs.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(strs[mid] == ""){
                int left = mid - 1;
                int right = mid + 1;
                while(true){
                    if(left<low && right>high)return -1;
                    if(left >= low && strs[left] != ""){
                        mid = left;
                        break;
                    }
                    if(right <= high && strs[right] != ""){
                        mid = right;
                        break;
                    }
                }
                
            }
            if(strs[mid] == s)
                return mid;
            else if(s.compareTo(strs[mid])<0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        String[] strs = {"for","","","","","","","","","","","","zebra"};
        System.out.println(binarySearch(strs, "zebra"));
    }
}