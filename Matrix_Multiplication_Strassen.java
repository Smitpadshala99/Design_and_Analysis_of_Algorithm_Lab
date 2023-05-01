import java.util.Random;
import java.util.Scanner;

public class Matrix_Multiplication_Strassen {
    
    // Generate a random matrix with elements between 0 and 10
    public static int[][] generateRandomMatrix(int n) {
        int[][] matrix = new int[n][n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rand.nextInt(11);
            }
        }

        return matrix;
    }

    // Print out a matrix
    public static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Multiply two matrices using Strassen's algorithm
    public static int[][] strassenMultiply(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];

        // Base case
        if (n == 1) {
            c[0][0] = a[0][0] * b[0][0];
        } else {
            // Split matrices into submatrices
            int[][] a11 = new int[n/2][n/2];
            int[][] a12 = new int[n/2][n/2];
            int[][] a21 = new int[n/2][n/2];
            int[][] a22 = new int[n/2][n/2];

            int[][] b11 = new int[n/2][n/2];
            int[][] b12 = new int[n/2][n/2];
            int[][] b21 = new int[n/2][n/2];
            int[][] b22 = new int[n/2][n/2];

            splitMatrix(a, a11, a12, a21, a22);
            splitMatrix(b, b11, b12, b21, b22);

            // Recursive step
            int[][] p1 = strassenMultiply(add(a11, a22), add(b11, b22));
            int[][] p2 = strassenMultiply(add(a21, a22), b11);
            int[][] p3 = strassenMultiply(a11, subtract(b12, b22));
            int[][] p4 = strassenMultiply(a22, subtract(b21, b11));
            int[][] p5 = strassenMultiply(add(a11, a12), b22);
            int[][] p6 = strassenMultiply(subtract(a21, a11), add(b11, b12));
            int[][] p7 = strassenMultiply(subtract(a12, a22), add(b21, b22));

            // Compute submatrices of the resulting matrix
            int[][] c11 = subtract(add(add(p1, p4), p7), p5);
            int[][] c12 = add(p3, p5);
            int[][] c21 = add(p2, p4);
            int[][] c22 = subtract(add(add(p1, p3), p6), p2);

            // Combine the submatrices into the result matrix
            c = new int[n][n];
            joinMatrices(c, c11, c12, c21, c22);
        }

        return c;
    }

    public static void splitMatrix(int[][] P, int[][] P11, int[][] P12, int[][] P21, int[][] P22) {
        int n = P.length;
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n/2; j++) {
                P11[i][j] = P[i][j];
                P12[i][j] = P[i][j + n/2];
                P21[i][j] = P[i + n/2][j];
                P22[i][j] = P[i + n/2][j + n/2];
            }
        }
    }

    public static void joinMatrices(int[][] P, int[][] P11, int[][] P12, int[][] P21, int[][] P22) {
        int n = P.length;
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n/2; j++) {
                P[i][j] = P11[i][j];
                P[i][j + n/2] = P12[i][j];
                P[i + n/2][j] = P21[i][j];
                P[i + n/2][j + n/2] = P22[i][j];
            }
        }
    }


    // Add two matrices
    public static int[][] add(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }

    // Subtract two matrices
    public static int[][] subtract(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = a[i][j] - b[i][j];
            }
        }
        return c;
    }


    public static void main(String[] args) {
        // User input for the size of the matrix
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size of matrix (must be power of 2): ");
        int n = input.nextInt();

        // Check if matrix size is a power of 2
        if ((n & (n - 1)) != 0) {
            System.out.println("Error: matrix size must be a power of 2.");
            return;
        }

        // Randomly generate matrices with elements between 0 and 10
        int[][] a = generateRandomMatrix(n);
        int[][] b = generateRandomMatrix(n);

        // Print out the matrices before multiplication
        System.out.println("Matrix A:");
        printMatrix(a);
        System.out.println("Matrix B:");
        printMatrix(b);

        // Multiply matrices using Strassen's algorithm and time it
        long startTime = System.nanoTime();
        int[][] c = strassenMultiply(a, b);
        long endTime = System.nanoTime();

        // Print out the resulting matrix and the time taken
        System.out.println("Resulting Matrix:");
        printMatrix(c);
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");
    }

}


