import java.util.Scanner;

public class Solution {
    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] answer = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                // iterate over the block centered at (i, j)
                for (int r = Math.max(0, i - k); r <= Math.min(m - 1, i + k); r++) {
                    for (int c = Math.max(0, j - k); c <= Math.min(n - 1, j + k); c++) {
                        sum += mat[r][c];
                    }
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        int[][] result = matrixBlockSum(mat, k);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j]);
                if (j < n - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}