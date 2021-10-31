package Unbounded_Knapsack;

public class CoinChange_MinCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins= {25, 10, 5};
		int sum = 30;
		
		System.out.println("MIn coins: " + countMinCoins(coins, sum));
		
	}
	
	public static int countMinCoins(int[] coins, int sum) {
		int[][] t = new int[coins.length+1][sum+1];
		
		for(int i =0; i<coins.length+1; i++) {
			t[i][0] = 0;
			
		}
		for(int i =0; i<sum+1; i++)
			t[0][i] = Integer.MAX_VALUE-1;
		
		for(int i =1; i<sum+1; i++) {
			if( i % coins[0] == 0)
				t[1][i] = i/coins[0];
			else
				t[1][i] = Integer.MAX_VALUE-1;
			
				
		}
		
		for(int i=1; i< coins.length+1; i++) {
			for(int j=1; j<sum+1; j++) {
				if(coins[i-1]<=j)
					t[i][j] = Math.min(t[i][j - coins[i-1]] + 1 ,t[i-1][j]);
				else
					t[i][j] = t[i-1][j];
			}
			
		}
		return t[coins.length][sum];
	}

}
