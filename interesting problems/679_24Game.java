class Solution {
    public boolean judgePoint24(int[] cards) {
        double[] a = new double[]{cards[0], cards[1], cards[2], cards[3]};
        return helper(a);
    }
    
    private boolean helper(double[] a) {
        if (a.length == 1) return Math.abs(a[0] - 24) < 0.0001;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                double[] b = new double[a.length - 1];
                for (int k = 0, index = 0; k < a.length; k++) {
                    if (k != i && k != j) b[index++] = a[k];
                }
                
                for (double d : compute(a[i], a[j])) {
                    b[b.length - 1] = d;
                    if (helper(b)) return true;
                }
            }
        }
        return false;
    }
    
    private double[] compute(double x, double y) {
        return new double[]{x + y, x - y, y - x, x * y, x / y, y / x};
    }
}
