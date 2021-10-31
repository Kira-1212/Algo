package Knapsack;

public class Subset_Sum {
	
	public static void main(String[] args) {
		int arr[]  = {2, 3, 7, 8, 10};
		int sum = 11;
		
		
		System.out.println("Sum Possible: " + sumPossible(arr, sum));
		
		
	}
	
	public static boolean sumPossible(int[] arr, int sum) {
		boolean[][] t = new boolean[arr.length+1][sum+1];
		
		for(int i = 0; i < sum+1; i++ )
			t[0][i] = false;
		for(int i = 0; i< arr.length+1; i++)
			t[i][0] = true;
		
		for(int i = 1; i<arr.length+1; i++) {
			for(int j = 1; j<sum+1; j++) {
				if(arr[i-1]<=j) {
					t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
					
				}
				else
					t[i][j] = t[i-1][j];
				
			}
		}
		return t[arr.length][sum];

			
	}
}
