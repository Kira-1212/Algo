
public class RodCutting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] length = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
		int N = 8;
		int size = length.length;
		
		System.out.println("Max Profit: " + cuttingRod(length, price, N, size));
	}
	public static int cuttingRod(int[] wt, int[] val, int W, int n) {
		int[][] t = new int[n+1][W+1];
		
		for(int i =0; i< n+1; i++) {
			for(int j=0; j<W+1; j++) {
				if(i==0||j==0)
					t[i][j] = 0;
				
			}
		}
		
		for(int i=1; i< n+1; i++) {
			for(int j=1; j<W+1; j++) {
				if(wt[i-1]<=j)
					t[i][j] = Math.max(val[i-1] + t[i][j - wt[i-1]], t[i-1][j]);
				else
					t[i][j] = t[i-1][j];
			}
			
		}
		return t[n][W];
	}
}
