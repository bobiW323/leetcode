// gradient descent
class Solution {
    public double getMinDistSum(int[][] positions) {
        int n = positions.length;
        if (n == 1) return 0;
        int sumX = 0, sumY = 0;
        double iniX = 0, iniY = 0;
        for (int i = 0; i < positions.length; i++) {
            sumX += positions[i][0];
            sumY += positions[i][1];
        }
        iniX = (double)sumX / n;
        iniY = (double)sumY / n;
        double currDis = dis(iniX, iniY, positions);
        double step = 1;
        while (step > 0.0000001) {
            boolean flag = true;
            double[][] dirs = {{0, step}, {step, 0}, {0, -step}, {-step, 0}};
            for(double[] dir : dirs) {
                double tx = iniX + dir[0];
                double ty = iniY + dir[1];
                double tmp = dis(tx, ty, positions);
                if (tmp < currDis) {
                    currDis = tmp;
                    iniX = tx;
                    iniY = ty;
                    flag = false;
                } 
            }
            if (flag) step /= 10;
        }
        return currDis;
    }
    private double dis(double x, double y, int[][] positions) {
        double ans = 0;
        for (int i = 0; i < positions.length; i++) {
            ans += Math.sqrt((x - positions[i][0]) * (x - positions[i][0]) + (y - positions[i][1]) * (y - positions[i][1]));
        }
        return ans;
    }
}
