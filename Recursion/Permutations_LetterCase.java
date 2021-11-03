
public class Permutations_LetterCase {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a1b2c";
		//System.out.println(s.substring(1));
		
		String op ="";
		
		solve(s,op);
		
		
	}
	
	private static void solve(String s, String op) {
		// TODO Auto-generated method stub	
		if(s.length()==0) {
			System.out.println(op);
			return;
		}
		if(Character.isDigit(s.charAt(0))) {
			String op1 = op;
			op1 += s.charAt(0);
			s = s.substring(1);
			solve(s, op1);
		}
		else {
			String op1 = op;
			String op2 = op;
			
			
			op1 += Character.toUpperCase(s.charAt(0));
			op2 += s.charAt(0);
			s = s.substring(1);
			solve(s, op1);
			solve(s, op2);
		}
		return;
	}
}
