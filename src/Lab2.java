
public class Lab2 {

    public Lab2() {
        System.out.println("Task 1:");
        double[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        double[] diagonal = task1(3, matrix);
        for (double d : diagonal) {
            System.out.println(d);
        }
        System.out.println("--------------------");
        System.out.println("Task 2:");
        double[] sequence = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        sequence= task2(3, matrix, sequence);
        for (double d : sequence) {
            System.out.println(d);
        }
        System.out.println("--------------------");
        System.out.println("Task 3:");
        int[][] matrix2 = {
            {0, 1, 0},
            {1, 0, 1},
            {0, 1, 0}
        };
        int[][] result = task3(3, 3, matrix2);
        for (int[] row : result) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        

    }
    /*
     * 14. Даны натуральное число n, действительная матрица  aij (i, j = 1,...,n) . Получить
     * последовательность элементов главной диагонали a11, a22, ... , ann.
     */
    
    public static double[] task1(int n, double[][] matrix) {
        double[] diagonal = new double[n];
        for (int i = 0; i < n; i++) {
            diagonal[i] = matrix[i][i];
        }
        return diagonal;
    }


    /*
     * 21. Даны натуральное число и квадратная матрица порядка n, действительные a1, ... , an+5 . 
     * Элементы последовательности домножить на 10, 
     * если наибольший элемент матрицы (в предположении, что такой элемент единственный) находятся на главной диагонали, 
     * и на 0.5 в противном случае.
     */

    public static double [] task2(int n, double[][] matrix, double[] sequence) {
        double max = matrix[0][0];
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[i][i] > max) {
                max = matrix[i][i];
                maxRow = i;
                maxCol = i;
            }
        }
        if (maxRow == maxCol) {
            for (int i = 0; i < sequence.length; i++) {
                sequence[i] *= 10;
            }
        } else {
            for (int i = 0; i < sequence.length; i++) {
                sequence[i] *= 0.5;
            }
        }
        return sequence;
    }


    /*
     * 45. Будем называть соседями элемента с индексами i, j некоторой матрицы
     * такие элементы этой матрицы, соответствующие индексы которых отличаются от i и j не более, чем на единицу. 
     * Для данной целочисленной матрицы aij i=1,...,n; j=1,...,m
     * найти матрицу из нулей и единиц bij i=1,...,n;j=1,...,m , элемент которой bij равен единице, когда:
     * все соседи aij и само aij равны нулю;
     */
    
    public static int[][] task3(int n, int m, int[][] matrix) {
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean isZero = true;
                if (matrix[i][j] == 0) {
                    if (i > 0 && matrix[i - 1][j] != 0) {
                        isZero = false;
                    }
                    if (i < n - 1 && matrix[i + 1][j] != 0) {
                        isZero = false;
                    }
                    if (j > 0 && matrix[i][j - 1] != 0) {
                        isZero = false;
                    }
                    if (j < m - 1 && matrix[i][j + 1] != 0) {
                        isZero = false;
                    }
                } else {
                    isZero = false;
                }
                result[i][j] = isZero ? 1 : 0;
            }
        }
        return result;
    }
    

}
