package MCM;
public class PalindromePartioning_TopDown {
	public static int[][] t = new int[15][15];
	public static void main (String[] args) {
		String S = "ababbbabbababa";
		
		for(int i =0; i<t.length; i++) {
			for(int j =0; j<t.length; j++)
				t[i][j] = -1;
		}
		System.out.println("Minimum no. of Palindrome Partitions: "+ solve(S, 0, S.length()-1));
	}
	
	public static int solve(String S, int i, int j) {
		if(i>=j)
			return 0;
		if(isPalindrome(S, i, j))
			return 0;
		int min = Integer.MAX_VALUE;
		if(t[i][j] != -1)
			return t[i][j];
		for(int k = i; k<= j-1; k++ ) {
			int left =0, right =0;
			if(t[i][k] != -1)
				left = t[i][k];
			else
				left = solve(S,i,k);
			
			if(t[k+1][j] != -1)
				right = t[k+1][j];
			else
				right = solve(S,k+1, j);
			
			int temp =  left + right + 1;
			min = Math.min(temp, min);
			
		}
		
		
		
		return min;
	}
	
	public static boolean isPalindrome(String S, int i, int j) {
		if(i >= j)
			return true;
		else {
			while(i<j) {
				if(S.charAt(i) != S.charAt(j))
					return false;
				i++;
				j--;
			}
		return true;
		}
		
	}
}
