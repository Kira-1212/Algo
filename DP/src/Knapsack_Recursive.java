
public class Knapsack_Recursive {

	public static int[][] t = new int[5][8];
	public static void main(String[] args) {
		int[] wt = {1,3,4,5};
		int[] val = {1, 4, 5, 7};
		int W = 7;
		int n = 4;
		for(int i=0; i<n+1; i++)
			for(int j=0; j<W+1; j++)
				t[i][j] =-1;
		System.out.println("Max Profit: " + knapsack(wt, val, W, n));
		
	}
	
	public static int knapsack(int[] wt, int[] val, int W, int n) {
		if(n==0 || W ==0)
			return 0;
		if(t[n][W] != -1)
			return t[n][W];
		if(wt[n-1] <= W)
			return t[n][W] = Math.max(val[n-1] + knapsack(wt, val, W - wt[n-1], n-1 ), knapsack(wt, val, W, n-1 ));
		else
			return t[n][W] = knapsack(wt, val, W, n-1 );
			
		
	}
}
