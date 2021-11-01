
public class KthGrammar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =2, k=2;
		
		System.out.println("Kth symbol in the grammar: " + (solve(n,k) ? 1: 0));
		
	}

	private static boolean solve(int n, int k) {
		// TODO Auto-generated method stub
		if(n==1 && k ==1)
			return false;
		int mid = (int)(Math.pow(2,n-1))/2;
		
		if(k<=mid)
			return solve(n-1,k);
		else
			return !solve(n-1,k-mid);
	}

}
