Youtube: https://youtu.be/h3k-xR9qHRs

class Solution {
    public int minimumBoxes(int n) {
        int cur = 0, ans1 = 0, ans2 = 0;
        // build the pyramid
        while (cur + (ans1 + 1) * (ans1 + 2) / 2 <= n) {
            cur += (ans1 + 1) * (ans1 + 2) / 2;
            ans1 ++;
        }
        // add boxes other than the pyramid
        while (cur < n) {
            ans2 ++;
            cur += ans2;
        }
        return ans1 * (ans1 + 1) / 2 + ans2;
    }
}
