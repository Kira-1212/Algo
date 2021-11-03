package LCS;

public class SCS_PrintString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "geek";
		String b = "eke";
		
		System.out.println("Shortest Supersequence: " + SCS_Print(a, b) );
	}

	private static String SCS_Print(String a, String b) {
		// TODO Auto-generated method stub
		int[][] t = new int[a.length()+1][b.length()+1];
		
		for(int i = 0; i<a.length()+1; i++)
			t[i][0] = 0;
		for(int i =0; i<b.length()+1; i++)
			t[0][i] = 0;
		String result ="";
		for(int i=1; i<a.length()+1; i++)
			for(int j=1;j<b.length()+1; j++) {
				if(a.charAt(i-1) == b.charAt(j-1))
					t[i][j] = 1 + t[i-1][j-1];
				else
					t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
			}
		
		int i = a.length() , j = b.length();
		while(i>0 && j>0) {
			if(a.charAt(i-1) == b.charAt(j-1)) {
				result += a.charAt(i-1);
				i--;
				j--;
				
			}
			else {
				if(t[i-1][j]>t[i][j-1]) {
					result += a.charAt(i-1);
					i--;
					
				}
					
				else {
					result += b.charAt(j-1);
					j--;
				}
					
			}
		}
		while(i>0) {
			result += a.charAt(i-1);
			i--;
		}
		while(j>0) {
			result += b.charAt(j-1);
			j--;
		}
			
		return new StringBuilder(result).reverse().toString();
	}

}
