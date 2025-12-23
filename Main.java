import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(input.readLine());
        StringBuilder output = new StringBuilder();
        Main obj = new Main();
        
        for (int t = 0; t < tc; t++)
        {
            int a = Integer.parseInt(input.readLine());

            output.append(String.valueOf(obj.solve(a))).append("\n");
        }

        System.out.print(output);
    }

    private int solve(int a)
    {
        return a;
    }
}
