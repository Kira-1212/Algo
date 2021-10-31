package MCM;
public class ScrambledString_Recursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "phqtrnilf";
		String s2 = "lithnqrpf";
		
		boolean result = false;
		if(s1.length() != s2.length())
			result = false;
		else
			result = solve(s1, s2);
		System.out.println("Is Scrambled String: " + result);
		
	}

	private static boolean solve(String s1, String s2) {
		// TODO Auto-generated method stub
		if(s1.compareTo(s2) == 0)
			return true;
		if(s1.length() <=1)
			return false;
		int l = s1.length()-1;
		boolean result = false;
		for(int i =1; i<=l ; i++)
		{
			boolean cond1 = false, cond2 = false;
			if((solve(s1.substring(0, i), s2.substring(l-i, l)) == true)  && (solve(s1.substring(i, l), s2.substring(0, l-i)) == true)) 
				cond1 = true;
			if((solve(s1.substring(0, i), s2.substring(0, i)) == true)  && (solve(s1.substring(l-i, l), s2.substring(l-i, l)) == true)) 
				cond2 = true;
			
			if(cond1 || cond2) {
				result = true;
				break;
			}
		}	
		return result;
	}
	
}
