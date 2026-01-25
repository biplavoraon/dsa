import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
	    int tc = Integer.parseInt(br.readLine());
	    Codechef obj = new Codechef();
	    
	    while (tc-- > 0)
	    {
	        int n = Integer.parseInt(br.readLine());
	        int[] arr = new int[n];
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        for (int i = 0; i < n; i++)
	            arr[i] = Integer.parseInt(st.nextToken());
	            
            output.append(obj.solve(n, arr)).append("\n");
	    }
	    
	    System.out.print(output);
	}
}
