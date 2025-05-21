import java.util.Scanner;

public class Lab3 {
    
    public Lab3() {
        Scanner scanner = new Scanner(System.in);

        // // Task 1
        // System.out.println("=== Task 1 ===");
        // System.out.print("Введите строку с двоеточием: ");
        // String input1 = scanner.nextLine();
        // System.out.println("Результат: " + task1(input1));
        // System.out.println("--------------------");

        // Task 2
        System.out.println("=== Task 2 ===");
        System.out.print("Введите строку для проверки соседствующих букв 'но' или 'он': ");
        String input2 = scanner.nextLine();
        System.out.println("Результат: " + (task2(input2) ? "Да, есть такая пара" : "Нет, такой пары нет"));
        System.out.println("--------------------");

        // Task 3
        System.out.println("=== Task 3 ===");
        System.out.print("Введите строку для удаления лишних пробелов: ");
        String input3 = scanner.nextLine();
        System.out.println("Результат: \"" + task3(input3) + "\"");
        System.out.println("--------------------");

        scanner.close();
    }


    /*
     * 10. Дана строка символов, среди которых есть двоеточие.
     * б) Получить все символы, расположенные после первого двоеточия.
     */
    public static String task1(String str) {
        int index = str.indexOf(':');
        return str.substring(index + 1);
    }


    /*
     * 7. Дана строка символов s1,...,sn . Известно, что символ s1 отличен от
     * восклицательного знака и что среди s2 , s3 ,... есть по крайней мере один восклицательный знак. 
     * Пусть s1,...,sn - символы данной последовательности,
     * предшествующие первому восклицательному знаку ( n заранее неизвестно).
     * г)Выяснить,имеется ли среди s1,...,sn пара соседствующих букв но или он.д
     */
    public static boolean task2(String str1) {
        String str = str1.split("!")[0];
        for (int i = 0; i < str.length() - 1; i++) {
            if ((str.charAt(i) == 'н' && str.charAt(i + 1) == 'о') || (str.charAt(i) == 'о' && str.charAt(i + 1) == 'н')) {
                return true;
            }
        }
        return false;
    }

    /*
     * 18. Дана строка символов s1,...,sn . Известно, что среди данных символов есть
     * хотя бы один, отличный от пробела. Требуется преобразовать последовательность
     * s ,...,s следующим образом. Удалить группы пробелов, которыми начинается и
     * которыми заканчивается последовательность, а также заменить каждую внутреннюю группу пробелов одним пробелом. 
     * Если указанных групп нет в данной последовательности, то оставить последовательность без изменения.
     */

    public static String task3(String str) {
        str=str.strip();
        do{
            str = str.replace("  ", " ");
        }while (str.contains("  "));
        return str;
    }
}
