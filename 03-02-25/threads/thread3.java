package threads;

public class thread3 {
	public static void main(String[] args) throws InterruptedException {
        int[][] matrixA = {
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        };
        
        int[][] matrixB = {
            {9, 3, 7},
            {8, 5, 4},
            {7, 2, 6}
        };

        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;

        if (colsA != rowsB) {
            System.out.println("Matrix multiplication is not possible: incompatible dimensions.");
            return;
        }

        int[][] result = new int[rowsA][colsB];

        
        Thread[] threads = new Thread[rowsA];
        for (int i = 0; i < rowsA; i++) {
            threads[i] = new Thread(new MatrixMultiplication(matrixA, matrixB, result, i));
            threads[i].start();
        }

        
        for (Thread thread : threads) {
            thread.join();
        }

        
        System.out.println("Resultant Matrix:");
        for (int[] row : result) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}

class MatrixMultiplication implements Runnable {
    private int[][] matrixA;
    private int[][] matrixB;
    private int[][] result;
    private int row;

    public MatrixMultiplication(int[][] matrixA, int[][] matrixB, int[][] result, int row) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.result = result;
        this.row = row;
    }

    @Override
    public void run() {
        int colsB = matrixB[0].length;
        for (int j = 0; j < colsB; j++) {
            result[row][j] = 0;
            for (int k = 0; k < matrixA[0].length; k++) {
                result[row][j] += matrixA[row][k] * matrixB[k][j];
            }
        }
    }

}
