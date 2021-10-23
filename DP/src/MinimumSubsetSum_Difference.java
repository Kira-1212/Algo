import java.util.ArrayList;
import java.util.List;

public class MinimumSubsetSum_Difference {

	public static void main(String[] args) {
		int[] arr = {1, 6, 11, 5};
		int sum = 0;
		for(int i = 0; i<arr.length; i++)
			sum = sum + arr[i];
		System.out.println("Minimum Subset Difference: " + subsetDifference(arr, sum));
	}
	
	public static int subsetDifference(int[] arr, int sum) {
		
		boolean[][] t = new boolean[arr.length+1][sum+1];
		
		for(int i=0; i<sum+1;i++)
			t[0][i] = false;
		for(int i=0; i<arr.length+1; i++ )
			t[i][0] = true;
		
		for(int i = 1; i<arr.length+1; i++ ) {
			for(int j=1; j<sum+1; j++) {
				if(arr[i-1]<=j) 
					t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
				else
					t[i][j] = t[i-1][j];
				
						
				}
			}
		List<Integer> lastRow = new ArrayList<>();
		for(int j = 1 ;j<(sum+1)/2; j++) {
			if(t[arr.length][j]==true)
				lastRow.add(j);
		}
		int min = Integer.MAX_VALUE;
		for(int i : lastRow)
			min = Math.min(min, sum - 2*i);
		
		return min;
			
	}
	

}
