
public class MCM_Recursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {40, 20, 30, 10, 30};
		
		System.out.println("Minimum Cost of Multiplication: " + solve(arr, 1, arr.length-1));
	}

	private static int solve(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		
		if(i>=j)
			return 0;
		
		int min = Integer.MAX_VALUE;
		for(int k = i; k<= j-1 ; k++) {
			int temp = solve(arr, i, k) + solve(arr, k+1, j) + (arr[i-1] * arr[k] * arr[j]);
			min = Math.min(min, temp);
		}
		
		return min;
	}

}
