import java.util.*;

public class Print_UniqueSubsets {
	public static Set<String> set = new HashSet<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aac";
		//System.out.println(s.substring(1));
		String op ="";
		op += ' ';
		solve(s, op);
		
		List<String> sortedList = new ArrayList<String>(set);
		Collections.sort(sortedList);
		System.out.println(sortedList);
	}
	
	private static void solve(String s, String op) {
		// TODO Auto-generated method stub
		if(s.length()==0) {
			set.add(op);
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
