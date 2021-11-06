import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		List<String> outputList = new ArrayList<>();
		String output = "";
		solve(n, n, outputList, output);
		for(String result : outputList)
			System.out.println(result);
	}

	private static void solve(int open, int close, List<String> outputList, String output) {
		// TODO Auto-generated method stub
		if(open == 0 && close == 0) {
			outputList.add(output);
			return;
		}
		if(open !=0) {
			String op1 = output;
			op1+="(";
			solve(open-1, close, outputList, op1);
		}
		if(close>open) {
			String op2 = output;
			op2 += ")";
			solve(open, close-1, outputList, op2);
		}
		return;
	}

}
