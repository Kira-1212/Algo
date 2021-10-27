
public class PalindromePartitioning_Recursive {

	
	
	
	public static void main (String[] args) {
		String S = "ababbbabbababa";
		
		System.out.println("Minimum no. of Palindrome Partitions: "+ solve(S, 0, S.length()-1));
	}
	
	public static int solve(String S, int i, int j) {
		if(i>=j)
			return 0;
		if(isPalindrome(S, i, j))
			return 0;
		int min = Integer.MAX_VALUE;
		for(int k = i; k<= j-1; k++ ) {
			int temp = solve(S,i,k) + solve(S,k+1, j) + 1;
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
