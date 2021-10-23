
public class CountNoSubsets_Diff {

	public static void main(String[] args) {
		int[] a = {1, 1, 2, 3};
		int diff = 1;
		int sum =0;
		for(int i =0 ; i<a.length; i++)
			sum = sum + a[i];
		int newSum = (sum + diff)/2;
		System.out.println("No of subsets with given difference: " + subsetCount_Diff(a, newSum));
	}
	
	public static int subsetCount_Diff(int[] a, int sum) {
		int[][] t = new int[a.length+1][sum+1];
		
		for(int i = 0; i<sum+1; i++)
			t[0][i] = 0;
		for(int i = 0; i<a.length+1; i++)
			t[i][0] = 1;
		
		for(int i = 1; i<a.length+1; i++) {
			for(int j = 1; j<sum+1; j++) {
				if(a[i-1] <= j)
					t[i][j] = t[i-1][j-a[i-1]] + t[i-1][j];
				else
					t[i][j] = t[i-1][j];
			}
		}
		
		return t[a.length][sum];
			
	}
}
