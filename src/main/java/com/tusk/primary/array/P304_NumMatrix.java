package com.tusk.primary.array;

/**
 * @author tusk
 * @desc leetcode-304:二维区域和校验-矩阵不可变
 * 同样是前缀和方法,二维可以认为是多个一维的组合
 * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 * @date 2021/12/7 14:38
 */
public class P304_NumMatrix {
    int[][] preSums;

    public P304_NumMatrix(int[][] matrix) {
        preSums = new int[matrix.length][matrix[0].length + 1];

        for (int i = 0; i < preSums.length; i++) {
            for (int j = 1; j < preSums[i].length; j++) {
                preSums[i][j] = preSums[i][j - 1] + matrix[i][j - 1];
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{3, 0, 1, 4, 2},
                new int[]{5, 6, 3, 2, 1},
                new int[]{1, 2, 0, 1, 5},
                new int[]{4, 1, 0, 1, 7},
                new int[]{1, 0, 3, 0, 5}
        };

        P304_NumMatrix obj = new P304_NumMatrix(matrix);
        System.out.println(obj.sumRegion(2,1,4,3));
        System.out.println(obj.sumRegion(1,1,2,2));
        System.out.println(obj.sumRegion(1,2,2,4));
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            //一维数组的区域和
            int rowSum = preSums[i][col2 + 1] - preSums[i][col1];
            sum += rowSum;
        }

        return sum;
    }
}
