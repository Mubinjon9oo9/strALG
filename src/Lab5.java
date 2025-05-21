import java.util.*;

public class Lab5 {
    
    public Lab5(){
        // System.out.println("Task1");
        // List<Integer> L = new ArrayList<>();
        // L.add(1);
        // L.add(2);
        // L.add(-1);
        // L.add(4);
        // L.add(-1);
        // System.out.println(task1(L));
        // System.out.println("--------------------");
        // System.out.println("Task2");
        // // L = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // System.out.println(task2(L));
        // System.out.println("--------------------");
        System.out.println("Task3");
        System.out.println(member("AD75", "(AD75, (3,(),(7H)))"));

    }

    /*
     * 4. Описать процедуру, которая удаляет:
     * д) из списка L первый отрицательный элемент, если такой есть (ТЭ=integer)
     */
    public static List<Integer> task1(List<Integer> L) {
        for (int i = 0; i < L.size(); i++) {
            if (L.get(i) < 0) {
                L.remove(i);
                break;
            }
        }
        return L;
    }

    /*
     * 8. Описать процедуру или функцию, которая:
     * г) переносит в конец непустого списка L его первый элемент;
     */
    public static List<Integer> task2(List<Integer> L) {
        if (!L.isEmpty()) {
            L.add(L.get(0));
            L.remove(L.get(0));
        }
        return L;
    }

    /*
     * 16. Назовем (иерархическим) "списком" заключенную в круглые скобки последовательность элементов, разделенных запятыми; 
     * элементы списка - это атомы или снова списки:
     * <список>::=( )   (<элементы>)
     * <элементы>::=<элемент> <элемент>,<элементы>
     * <элемент>::=<атом> <список>
     * Под "атомом" понимается последовательность, содержащая от 1 до N букв и
     * цифр, где N - заранее известное натуральное число. Пример подобного списка: (AD75,(3,(),(7H))).
     * Предложить и описать представление таких списков и определить следующие рекурсивные функции и процедуры для работы с ними:
     * а) логическую функцию member(A,L), проверяющую, входит ли атом А в список L;
     */
    public static boolean member(String A, String L) {
        Stack<String> stack = new Stack<>();
        L = L.trim(); // Убираем пробелы в начале и конце строки

        // Разбиваем строку на токены, разделяя по запятым и скобкам
        String[] tokens = L.split("(?=[(),])|(?<=[(),])");

        for (String token : tokens) {
            token = token.trim(); // Убираем пробелы вокруг токена

            if (token.equals("(")) {
                // Открывающая скобка: добавляем в стек
                stack.push(token);
            } else if (token.equals(")")) {
                // Закрывающая скобка: убираем элементы из стека до открывающей скобки
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek().equals("(")) {
                    stack.pop(); // Убираем открывающую скобку
                }
            } else if (!token.isEmpty() && !token.equals(",")) {
                // Проверяем, совпадает ли текущий атом с искомым
                if (token.equals(A)) {
                    return true;
                }
            }
        }

        return false; // Если ничего не найдено
    }
}
