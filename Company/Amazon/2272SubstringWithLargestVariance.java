class Solution {
    public int largestVariance(String s) {
        Set<Character> hs = new HashSet<>();
        for (int i = 0; i < s.length(); i++) hs.add(s.charAt(i));
        if (hs.size() == 1) return 0;
        boolean[] maxAlpha = new boolean[26];
        boolean[] minAlpha = new boolean[26];
        Iterator it = hs.iterator();
        while (it.hasNext()) {
            char c = (char)it.next();
            int n = c - 'a';
            maxAlpha[n] = true;
            minAlpha[n] = true;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i != j && maxAlpha[i] == true && minAlpha[j] == true) {
                    int[] cur = new int[s.length()];
                    for (int k = 0; k < s.length(); k++) {
                        if (s.charAt(k) == (char)('a' + i)) cur[k] = 1;
                        else if (s.charAt(k) == (char)('a' + j)) cur[k] = -1;
                    }
                    res = Math.max(res, countMax(cur));
                }
            }
        }
        return res;
    }
    
    private int countMax(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur = Math.max(cur + nums[i], nums[i]);
            dp[i] = cur;
        }
        cur = 0;
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            cur = Math.max(cur + nums[i], nums[i]);
            if (nums[i] == -1) {
                res = Math.max(res, cur + dp[i] - nums[i]);
            }
        }
        return res;
    }
}
