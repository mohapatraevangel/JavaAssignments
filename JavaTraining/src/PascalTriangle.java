package Day1;

public class PascalTriangle {
        public static void main(String[] args) {
            int rows = 8;
            int[][] triangle = new int[rows][];

            for (int i = 0; i < rows; i++) {
                triangle[i] = new int[i + 1];

                for (int j = 0; j <= i; j++) {
                    triangle[i][j] = j + 1;
                }
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print(triangle[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
