import java.util.*;

import static java.lang.System.out;

public class SubsetSum {
    public int perfectSum(int arr[],int n, int sum)
    {
        // Your code goes here
        int[][] dp = new int[n + 1][sum + 1];
        int mod = (int) (1e9 + 7);
        int countZero = 0;

        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= n; i++)
        {
            for (int j = 0; j <= sum; j++)
            {
                if (arr[i - 1] <= j)
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - arr[i - 1]]) % mod;
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SubsetSum obj = new SubsetSum();

        //Input variables
        int n = sc.nextInt();
        int[] a = new int[n];
        int x = sc.nextInt();
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        //Output
        out.println(obj.perfectSum(a, n, x));
        sc.close();
    }
}

