// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int[] p = { 60, 100, 120 };
        int[] w = { 10, 20, 30 };
        int W = 50;
        int m = p.length;
        int n = w.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++)
            dp[i][0] = 0;
        for (int i = 0; i < n + 1; i++)
            dp[0][i] = 0;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (j < w[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                    System.out.println(dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], p[i - 1] + dp[i - 1][j - w[i - 1]]);
                    System.out.println(dp[i][j]);
                }
            }
        }

        System.out.println(dp[m][n]);
    }
}