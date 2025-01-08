class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < words.length; i++)
        {
            int[] lps = computeLPS(words[i]);

            for (int j = 0; j < words.length; j++)
            {
                if (i == j) continue;

                if (isSubstring(words[i], words[j], lps))
                {
                    ans.add(words[i]);
                    break;
                }
            }
        }

        return ans;
    }

    private boolean isSubstring(String pattern, String text, int[] lps)
    {
        int pi = 0, ti = 0;

        while (ti < text.length() && pi < pattern.length())
        {
            if (text.charAt(ti) == pattern.charAt(pi))
            {
                ti++;
                pi++;
            }
            else if (pi > 0)
                pi = lps[pi - 1];
            else
                ti++;
        }

        return pi == pattern.length();
    }

    private int[] computeLPS(String pattern)
    {
        int n = pattern.length(), j = 0, i = 1;
        int[] lps = new int[n];
        
        while (i < n)
        {
            if (pattern.charAt(i) == pattern.charAt(j))
            {
                j++;
                lps[i] = j;
                i++;
            }
            else if (j > 0)
                j = lps[j - 1];
            else
                i++;
        }

        return lps;
    }
}
