package LCS;

public class SCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "geek";
		String b = "eke";
		
		System.out.println("Length of Shortest Subsequence: " + SCS_Length(a, b) );
	}
	
	public static int SCS_Length(String a, String b) {
		int[][] t = new int[a.length()+1][b.length()+1];
		
		for(int i = 0; i<a.length()+1; i++)
			t[i][0] = 0;
		for(int i =0; i<b.length()+1; i++)
			t[0][i] = 0;
		
		for(int i=1; i<a.length()+1; i++)
			for(int j=1;j<b.length()+1; j++) {
				if(a.charAt(i-1) == b.charAt(j-1))
					t[i][j] = 1 + t[i-1][j-1];
				else
					t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
			}
		int longSCS = a.length()+b.length();
		
		return longSCS - t[a.length()][b.length()];
	}

}
