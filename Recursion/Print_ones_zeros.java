import java.util.ArrayList;
import java.util.List;

public class Print_ones_zeros {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		List<String> outputList = new ArrayList<String>();
		solve(n, 0, 0, "", outputList);
		for(String res : outputList)
			System.out.println(res);
	}

	private static void solve(int n, int ones, int zeros, String output, List<String> outputList) {
		// TODO Auto-generated method stub
		if(n==0) {
			outputList.add(output);
			return;
		}
		String op = output;
		op += "1";
		solve(n-1, ones+1, zeros, op, outputList);
		
		if(ones>zeros) {
			op = output;
			op += "0";
			solve(n-1, ones, zeros+1, op, outputList);
		}
		return;
	}

}
