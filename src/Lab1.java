import java.util.Scanner;

public class Lab1 {
    public Lab1() {
        Scanner scanner = new Scanner(System.in);

        // Task 1
        System.out.println("Task 1:");
        System.out.print("Введите n, a, b, c, d, q (через пробел): ");
        int n = scanner.nextInt();
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double d = scanner.nextDouble();
        double q = scanner.nextDouble();
        System.out.println("Результат Task 1: " + task1(n, a, b, c, d, q));
        System.out.println("--------------------");

        // Task 2
        System.out.println("Task 2:");
        System.out.print("Введите a: ");
        int a2 = scanner.nextInt();
        System.out.print("Введите длину массива: ");
        int len = scanner.nextInt();
        int[] arr = new int[len];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Результат Task 2: " + task2(a2, arr));
        System.out.println("--------------------");

        // Task 3
        System.out.println("Task 3:");
        System.out.print("Введите длину массива: ");
        int len3 = scanner.nextInt();
        int[] sequence2 = new int[len3];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < len3; i++) {
            sequence2[i] = scanner.nextInt();
        }
        System.out.println("Результат Task 3: " + task3(sequence2));

        scanner.close();
    }
    
    /*     
    *16. Пусть x0 = a; xk = q*x(k-1)+b, (k= 1,2,...). Даны: неотрицательное
    *целое n, дей3твительные a, b, c, d, q ( c<d )  . Принадлежит ли xn интервалу  (c, d)?
    */ 
    public static boolean task1(int n, double a, double b, double c, double d, double q) {
        double x = a;
        for (double i = 0; i < n; i++) {
            x = q * x + b;
        }
        return c < x && x < d;
    }

    /*
     * 23. Даны целые числа а, n, x1 , ..., xn (n>0). Определить, каким по счету идет
    в последовательности x1, ..., xn член, равный а. Если такого члена нет, то ответом должно быть число 0.
     */

     public static int task2(int a, int[] sequence) {
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == a) {
                return i + 1; 
            }
        }
        return 0;
    }

    /*
     * 56. Даны натуральное число n, целые числа a1 , ..., an .
     * в) Найти номер последнего нечетного члена последовательности a1 , ..., an ; 
     * если нечетных членов нет, то ответом должно быть число n+1.
     */
    public static int task3(int[] sequence) {
        int lastIndex = -1;
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] % 2 != 0) {
                lastIndex = i + 1;
            }
        }
        return (lastIndex == -1) ? sequence.length + 1 : lastIndex;
    }
}

