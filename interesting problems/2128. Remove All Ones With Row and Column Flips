class Solution {
    // 后面的每一行要么与第一行相等，要么互补
    public boolean removeOnes(int[][] grid) {
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if ((grid[i][j] == grid[0][j]) != (grid[i][j - 1] == grid[0][j - 1]))
                    return false;
            }
        }
        return true;
    }
}
