package leetcode_easy;

public class Question_812 {

    public double largestTriangleArea(int[][] points) {

        int[] xAxis = new int[points.length];
        int[] yAxis = new int[points.length];

        for (int r = 0; r < points.length; r++) {
            int[] row = points[r];
            xAxis[r] = row[0];
            yAxis[r] = row[1];
        }

        int max_x = 0, min_x = 0;
        int max_y = 0, min_y = 0;

        for (int i = 0; i < points.length; i++) {
            int xvalue = xAxis[i];
            if (max_x < xvalue) {
                max_x = xvalue;
            }
            if (min_x > xvalue) {
                min_x = xvalue;
            }

            int yValue = yAxis[i];
            if (max_y < yValue) {
                max_y = yValue;
            }
            if (min_y > yValue) {
                min_y = yValue;
            }
        }

        int max_x_length = Math.max(Math.abs(max_x), Math.abs(min_x));
        int max_y_length = Math.max(Math.abs(max_y), Math.abs(min_y));

        return (max_x_length * max_y_length / 2.0);
    }

    public void solve() {
        int[][] points = {
                {1,0},
                {0,0},
                {0,1}
        };
        System.out.println(largestTriangleArea(points));

    }
}
