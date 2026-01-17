class XOR {
    long MOD = 1_000_000_007;

    public int alternatingXOR(int[] nums, long target1, long target2) {
        HashMap<Long, Long> map1 = new HashMap<>();
        HashMap<Long, Long> map2 = new HashMap<>();
        map1.put(0L, 1L);
        int n = nums.length;
        long ans = 0;

        for (int i = 0; i < n - 1; i++)
        {
            HashMap<Long, Long> temp1 = new HashMap<>();
            HashMap<Long, Long> temp2 = new HashMap<>();

            if (map1.containsKey(target1 ^ nums[i]))
                temp2.put(0L, map1.get(target1 ^ nums[i]));
            
            if (map2.containsKey(target2 ^ nums[i]))
                temp1.put(0L, map2.get(target2 ^ nums[i]));
            
            for (long prefix : map1.keySet())
            {
                long curr = prefix ^ nums[i];
                temp1.put(curr, (temp1.getOrDefault(curr, 0L) + map1.get(prefix)) % MOD);
            }

            for (long prefix : map2.keySet())
            {
                long curr = prefix ^ nums[i];
                temp2.put(curr, (temp2.getOrDefault(curr, 0L) + map2.get(prefix)) % MOD);
            }

            map1 = new HashMap<>(temp1);
            map2 = new HashMap<>(temp2);
        }

        if (map1.containsKey(target1 ^ nums[n - 1]))
            ans += map1.get(target1 ^ nums[n - 1]);
        if (map2.containsKey(target2 ^ nums[n - 1]))
            ans += map2.get(target2 ^ nums[n - 1]);

        ans %= MOD;
        return (int) ans;
    }
}
