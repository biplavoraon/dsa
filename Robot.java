import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Robot
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();
        Main obj = new Main();

        while (tc-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] robots = new int[n];
            int[] spikes = new int[m];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++)
                robots[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++)
                spikes[i] = Integer.parseInt(st.nextToken());

            String s = br.readLine();

            output.append(obj.solve(n, m, k, robots, spikes, s)).append("\n");
        }

        System.out.print(output);
    }

    private String solve(int n, int m, int k, int[] robots, int[] spikes, String s) {
        HashMap<Integer, Integer> firstTime = new HashMap<>();
        HashMap<Integer, Integer> deathTimes = new HashMap<>();
        TreeSet<Integer> ts = new TreeSet<>();

        for (int spike : spikes)
            ts.add(spike);

        int pos = 0, deaths = 0;
        for (int i = 0; i < k; i++)
        {
            char ch = s.charAt(i);

            if (ch == 'L')
                pos--;
            else
                pos++;

            if (!firstTime.containsKey(pos))
                firstTime.put(pos, i);
        }

        for (int robot : robots)
        {
            if (ts.contains(robot))
            {
                deaths++;
                continue;
            }

            int deathTime = Integer.MAX_VALUE;
            if (ts.lower(robot) != null)
                deathTime = Math.min(deathTime, firstTime.getOrDefault(ts.lower(robot) - robot, deathTime));
            if (ts.higher(robot) != null)
                deathTime = Math.min(deathTime, firstTime.getOrDefault(ts.higher(robot) - robot, deathTime));

            deathTimes.put(deathTime, deathTimes.getOrDefault(deathTime, 0) + 1);
        }

        pos = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++)
        {
            char ch = s.charAt(i);

            if (ch == 'L')
                pos--;
            else
                pos++;

            if (deathTimes.containsKey(i))
                deaths += deathTimes.get(i);

            sb.append(n - deaths).append(" ");
        }

        return String.valueOf(sb);
    }

}
