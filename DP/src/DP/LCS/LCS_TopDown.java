
public class LCS_TopDown {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "AGGTAB";
		String b = "GXTXAYB";
		int[][] t = new int[a.length()+1][b.length()+1];
		int m = a.length();
		int n = b.length();
		
		for(int i = 0; i<a.length()+1 ; i++)
			for(int j=0; j<b.length()+1 ; j++)
				t[i][j] = -1;
		
		System.out.println("Length of Longest Common Subsequence: " + LCS(a,b,m,n,t));
	}
	
	
	public static int LCS(String a, String b, int m, int n, int[][] t) {
		if(m==0 || n==0)
			return 0;
		if(t[m][n] != -1)
			return t[m][n];
		if(a.charAt(m-1) == b.charAt(n-1))
			return t[m][n] = 1 + LCS(a,b,m-1,n-1,t);
		else
			return t[m][n] = Math.max(LCS(a,b,m-1,n,t), LCS(a,b,m,n-1,t));
			
	}

}

