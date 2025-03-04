
public class Lab1 {
    public Lab1(){
        System.out.println("Task 1:");
        System.out.println(task1(5, 2.0, 1.0, 10.0, 20.0, 1.5));
        System.out.println("--------------------");
        System.out.println("Task 2:");
        int [] arr = {3, 8, 5, 1, 7};
        System.out.println(task2(5, arr));
        System.out.println("--------------------");
        System.out.println("Task 3:");
        int[] sequence2 = {2, 3, 4, 7, 8}; // Последний нечетный — 7 (позиция 4)
        System.out.println(task3(sequence2));
    }
    
    
    
    /*     
    *16. Пусть x0 = a; xk = q*x(k-1)+b, (k= 1,2,...). Даны: неотрицательное
    *целое n, действительные a, b, c, d, q ( c<d )  . Принадлежит ли xn интервалу  (c, d)?
    */ 
    public static boolean task1(int n, double a, double b, double c, double d, double q) {
        double x = a;
        for (int i = 0; i < n; i++) {
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

