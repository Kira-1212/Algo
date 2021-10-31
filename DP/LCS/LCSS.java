package LCS;

public class LCSS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "GeeksForGeeks";
		String b = "GeeksQuiz";
		
		
		
		System.out.println("Length of Longest Common SubString: " + LCS_SubString(a,b));
	}
	
	public static int LCS_SubString(String a, String b) {
		int[][] t = new int[a.length()+1][b.length()+1];
		int result =0;
		for(int i = 0; i<a.length()+1; i++)
			t[i][0] = 0;
		for(int i = 0; i<b.length()+1; i++)
			t[0][i] = 0;
		
		for(int i =1 ; i<a.length()+1; i++) {
			for(int j =1 ; j<b.length()+1; j++) {
				if(a.charAt(i-1) == b.charAt(j-1)) {
					t[i][j] = 1 + t[i-1][j-1];
					result = Math.max(result, t[i][j]);
				}
				else
					t[i][j] = 0;
			}
		}
		return result;
		
		
	}

}
