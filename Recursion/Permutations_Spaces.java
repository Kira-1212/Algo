import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations_Spaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		//System.out.println(s.substring(1));
		
		String op ="";
		op += s.charAt(0);
		solve(s.substring(1),op);
		
		
	}
	
	private static void solve(String s, String op) {
		// TODO Auto-generated method stub
		if(s.length()==0) {
			System.out.println(op);
			return;
		}
		String op1 = op;
		String op2 = op;
		
		op1 += ' ';
		op1 += s.charAt(0);
		op2 += s.charAt(0);
		s = s.substring(1);
		solve(s, op1);
		solve(s, op2);
		return;
	}
}
