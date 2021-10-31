package LCS;

public class LCS_PrintString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "AGGTAB";
		String b = "GXTXAYB";
		
		
		
		System.out.println("Longest Common Subsequence: " + LCS(a,b));
	}

	private static String LCS(String a, String b) {
		// TODO Auto-generated method stub
		int i = 0,  j = 0;
		String result = "";
		
		int[][] t = new int[a.length()+1][b.length()+1];
		
		for( i = 0 ; i<b.length()+1; i++)
			t[0][i] = 0;
		
		for( i =0; i<a.length()+1; i++)
			t[i][0]  = 0;
		
		for( i = 1; i<a.length()+1; i++)
			for( j=1; j<b.length()+1; j++) {
				if(a.charAt(i-1) == b.charAt(j-1))
					t[i][j] = 1+t[i-1][j-1];
				else
				{
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
					
				}
			}
		i = a.length();
		j = b.length();
		while(i>0 && j>0) {
			if(a.charAt(i-1) == b.charAt(j-1)) {
				result = result + a.charAt(i-1);
				i--;
				j--;
			}
			else {
				if(t[i-1][j] > t[i][j-1])
					i--;
				else
					j--;
			}
			
		}
		
		return new StringBuilder(result).reverse().toString();
	}

}
