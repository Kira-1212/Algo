
public class CountNoSubset_Sum {

	public static void main(String[] args) {
		int[] arr = {2, 3, 5, 6, 8, 10 };
		//int diff = 1;
		int sum = 10;
		System.out.println("Count of subsets Sum: " + subsetCount(arr, sum));
	}
	
	public static int subsetCount(int[] arr, int sum) {
		int[][] t = new int[arr.length+1][sum+1];
		for(int i=0; i<sum+1; i++)
			t[0][i] = 0;
		for(int i = 0; i<arr.length+1; i++)
			t[i][0] = 1;
		
		for(int i=1; i<arr.length+1; i++ ) {
			for(int j =1; j<sum+1; j++) {
				if(arr[i-1]<=j)
					t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
				else
					t[i][j] = t[i-1][j];
			}
		}
		return t[arr.length][sum];
		
	}
}
