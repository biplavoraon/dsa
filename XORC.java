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
          long c = Integer.parseInt(br.readLine());
          long a = c, b = c<<30;
        
          output.append(a).append(" ").append(b).append("\n");
      }


      System.out.print(output);
  }
}
