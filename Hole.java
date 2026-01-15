class Hole {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int ansh = 2, ansv = 2, curr = 2;

        for (int i = 1; i < hBars.length; i++)
        {
            if (hBars[i] - hBars[i - 1] == 1)
                curr++;
            else
                curr = 2;
            
            ansh = Math.max(ansh, curr);
        }

        curr = 2;
        for (int i = 1; i < vBars.length; i++)
        {
            if (vBars[i] - vBars[i - 1] == 1)
                curr++;
            else
                curr = 2;

            ansv = Math.max(ansv, curr);
        }
        
        return Math.min(ansh, ansv) * Math.min(ansh, ansv);
    }
}
