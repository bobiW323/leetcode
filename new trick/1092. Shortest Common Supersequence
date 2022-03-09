class Solution {
    private String findLCS(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        String[][] dp = new String[len1 + 1][len2 + 1];
        
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) dp[i][j] = "";
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + str1.charAt(i - 1);
                else dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
            }
        }
        return dp[len1][len2];
    }
    
    
    public String shortestCommonSupersequence(String str1, String str2) {
        String ans = "";
        String lcs = findLCS(str1, str2);
        int p1 = 0, p2 = 0;
        for (int i = 0; i < lcs.length(); i++) {
            char c = lcs.charAt(i);
            while (str1.charAt(p1) != c) {
                ans += str1.charAt(p1++);
            }
            while (str2.charAt(p2) != c) {
                ans += str2.charAt(p2++);
            }
            ans += c;
            ++p1;
            ++p2;
        }
        ans += str1.substring(p1);
        ans += str2.substring(p2);
        return ans;
 
    }
}
