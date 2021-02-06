import java.util.*;

public class ChainMatrix{
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(5,10,3,12,5,50,6));
        System.out.println(chainMatrix(input)); 
    }

    public static int chainMatrix(List<Integer> input) {
        int n = input.size() - 1;

        int[][] dp = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            dp[i][i] = 0;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n-l+1; i++) {
                int j = i + l - 1;
                int min = Integer.MAX_VALUE;
                System.out.print(" i " + i + " j " + j );
                for (int k = i; k < j; k++){
                    int tmp = dp[i][k] + dp[k+1][j] + input.get(i-1) * input.get(k) * input.get(j);
                    min = Math.min(min, tmp);
                    System.out.print(" k " + k + " tmp " + tmp);
                }
                dp[i][j] = min;

                System.out.println( " min " + min);
            }
        }

        return dp[1][n];
    }
}