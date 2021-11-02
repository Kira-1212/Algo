
public class Print_Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		String op ="";
		op += ' ';
		//System.out.println(s.substring(1));
		solve(s, op);
	}

	private static void solve(String s, String op) {
		// TODO Auto-generated method stub
		if(s.length()==0) {
			System.out.println(op);
			return;
		}
		String op1 = op;
		String op2 = op;
		
		op1 += s.charAt(0);
		s = s.substring(1);
		solve(s,op1);
		solve(s, op2);
		return;
	}

}
