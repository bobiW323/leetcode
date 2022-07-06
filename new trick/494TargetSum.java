//using dp to get number of subsets which sums to a certain value
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum < target || (sum + target) % 2 == 1) return 0;
        int sub = (sum + target) / 2;
         // edge cases
        Arrays.sort(nums);
        if (nums[0] > sub && sub != 0) return 0;
        int[][] dp = new int[nums.length + 1][sub + 1];
        dp[0][0] = 1;
        for (int i = 1; i < dp[0].length; i++) dp[0][i] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (nums[i - 1] > j) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[nums.length][sub];
    }
    
    
}
