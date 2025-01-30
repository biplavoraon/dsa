class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] marked = new int[n];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++)
        {
            if (marked[i] == 0)
            {
                q.add(i);
                marked[i] = 1;

                while (!q.isEmpty())
                {
                    int u = q.poll();

                    for (int v : graph[u])
                    {
                        if (marked[v] == 0)
                        {
                            marked[v] = 3 - marked[u];
                            q.add(v);
                        }
                        else if (marked[u] + marked[v] != 3)
                            return false;
                    }
                }
            }
        }

        return true;
    }
}
