import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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

            ArrayList<Integer> ans = obj.solve(n);
            for (int i = 0; i < ans.size(); i++)
                output.append(ans.get(i)).append((i < ans.size() - 1) ? " " : "\n");
        }

        System.out.print(output);
    }

    private ArrayList<Integer> solve(int n) {
        int size = 1 << n;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(size - 1);
        int lower = size / 2, upper = 2;

        for (int k = 1; k <= n; k++)
        {
            for (int el = 0; el < upper; el+=2)
            {
                int num = (lower - 1) + (el << (n - k));
                ans.add(num);
            }
            lower /= 2;
            upper *= 2;
        }

        return ans;
    }
}
