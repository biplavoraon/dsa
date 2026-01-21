class Bitwise {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++)
        {
            int curr = -1;
            int target = nums.get(i);
            int lowest = 0;

            for(int b = 0; b < 32; b++)
            {
                int mask = 1 << b;

                if ((target & mask) == 0)
                    break;

                curr = b;
            }

            if (curr == -1)
            {
                ans[i] = -1;
                continue;
            }

            for (int b = 0; b < 32; b++)
            {
                if (curr == b)
                    continue;
                
                int mask = 1 << b;

                lowest += (mask & target);
            }

            ans[i] = lowest;
        }

        return ans;
    }
}
