import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();
        Main obj = new Main();

        for (int t = 0; t < tc; t++)
        {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            output.append(obj.solve(arr)).append("\n");
        }

        System.out.print(output);
    }

    private int solve(int[] arr) {
        Arrays.sort(arr);
        int low = arr[0] + 1, high = arr[1] - 1, ans = arr[0];

        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            if (arr[1] - mid >= arr[0])
            {
                ans = Math.max(ans, mid);
                low = mid + 1;
            }
            else
                high = mid - 1;
        }

        return ans;
    }

}
