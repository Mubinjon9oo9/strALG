import java.util.Random;
import java.util.Scanner;

public class Lab2 {

    public Lab2() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // // Task 1
        // System.out.println("=== Task 1 ===");
        // System.out.print("Введите размер квадратной матрицы (n): ");
        // int n = scanner.nextInt();
        // double[][] matrix = new double[n][n];
        // System.out.println("Сгенерированная матрица:");
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         matrix[i][j] = random.nextDouble() * 100; // Генерация случайных чисел от 0 до 100
        //         System.out.printf("%.2f ", matrix[i][j]);
        //     }
        //     System.out.println();
        // }
        // double[] diagonal = task1(n, matrix);
        // System.out.println("Главная диагональ:");
        // for (double d : diagonal) {
        //     System.out.printf("%.2f ", d);
        // }
        // System.out.println("\n====================");

        // Task 2
        System.out.println("=== Task 2 ===");
        System.out.print("Введите длину последовательности (n + 5): ");
        int sequenceLength = scanner.nextInt();
        double[][] matrix = new double[sequenceLength][sequenceLength];
        System.out.println("Сгенерированная матрица:");
        for (int i = 0; i < sequenceLength; i++) {
            for (int j = 0; j < sequenceLength; j++) {
                matrix[i][j] = random.nextDouble() * 100;
                matrix[0][0] =100;// Генерация случайных чисел от 0 до 100
                System.out.printf("%.2f ", matrix[i][j]);
            }
            System.out.println();
        }
        double[] sequence = new double[sequenceLength];
        System.out.println("Сгенерированная последовательность:");
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = random.nextDouble() * 100; // Генерация случайных чисел от 0 до 100
            System.out.printf("%.2f ", sequence[i]);
        }
        System.out.println();
        sequence = task2(sequenceLength, matrix, sequence);
        System.out.println("Изменённая последовательность:");
        for (double d : sequence) {
            System.out.printf("%.2f ", d);
        }
        System.out.println("\n====================");

        // Task 3
        System.out.println("=== Task 3 ===");
        System.out.print("Введите количество строк матрицы: ");
        int rows = scanner.nextInt();
        System.out.print("Введите количество столбцов матрицы: ");
        int cols = scanner.nextInt();
        int[][] matrix2 = new int[rows][cols];
        System.out.println("Сгенерированная матрица:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix2[i][j] = random.nextInt(2); // Генерация случайных чисел 0 или 1
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }
        int[][] result = task3(rows, cols, matrix2);
        System.out.println("Результирующая матрица:");
        for (int[] row : result) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println("====================");

        scanner.close();
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
        double max = 0;
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < n; i++) {
            for (int j=0;j<n;j++){
                if (matrix[i][j]>max){
                    maxRow=i;
                    maxCol=j;
                    max = matrix[i][j];
                }
            }
        }
        
        if (maxRow == maxCol) {

            for (int i = 0; i < sequence.length; i++) {
                sequence[i] = Math.round(sequence[i]) * 10;
            }
        } else {
            for (int i = 0; i < sequence.length; i++) {
                sequence[i] = Math.round(sequence[i]) * 0.5;
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
