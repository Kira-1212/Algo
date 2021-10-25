
public class LCS_Recursive {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "AGGTAB";
		String b = "GXTXAYB";
		
		int m = a.length();
		int n = b.length();
		
		System.out.println("Length of Longest Common Subsequence: " + LCS(a,b,m,n));
	}
	
	
	public static int LCS(String a, String b, int m, int n) {
		if(m==0 || n==0)
			return 0;
		if(a.charAt(m-1) == b.charAt(n-1))
			return 1 + LCS(a,b,m-1,n-1);
		else
			return Math.max(LCS(a,b,m-1,n), LCS(a,b,m,n-1));
			
	}

}
