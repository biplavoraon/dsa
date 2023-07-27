public int maxIncreasingGroups(List<Integer> usageLimits) {
        int n = usageLimits.size();
        Collections.sort(usageLimits);
        int l = 0, r = n, max = 0;

        while (l <= r)
        {
            int mid = l + (r - l) / 2;
            if (isPossible(mid, n, usageLimits))
            {
                max = mid;
                l = mid + 1;
            }
            else
                r = mid - 1;
        }

        return max;
    }

    private boolean isPossible(int target, int n, List<Integer> usageLimits) {
        int req = 0;
        for (int i = n - 1; i >= 0; i--)
        {
            if (target > 0)
                req += target--;
            req -= Math.min(req, usageLimits.get(i));
        }
        return req == 0;
    }
