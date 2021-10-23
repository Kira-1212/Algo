
public class EqualSumPartition {
	public static void main (String[] args) {
		int[] arr = {1, 5, 11, 5};
		int sum = 0;
		for(int i = 0; i<arr.length; i++) {
			sum = sum + arr[i];
		}
		boolean possible = false;
		if(sum % 2 != 0) {
			possible = false;
		}
		else
			possible = sumPossible(arr, sum/2);
		System.out.println("Equal Sum Partition possible? "+ possible);
	}
	
	
	public static boolean sumPossible(int[] arr, int sum) {
		boolean[][] t = new boolean[arr.length+1][sum+1];
		for(int i = 0; i<sum+1 ; i++)
			t[0][i] = false;
		for(int i = 0; i<arr.length+1;i++)
			t[i][0] = true;
		
		for(int i = 1; i<arr.length+1; i++) {
			for(int j =1; j<sum+1; j++) {
				if(arr[i-1]<= j)
					t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
				else
					t[i][j] = t[i-1][j];
			}
		}
		return t[arr.length][sum];
		 
	}
}
