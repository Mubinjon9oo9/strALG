public class Lab3 {
    
    public Lab3(){
        System.out.println("Task 1:");
        System.out.println(task1("Список покупок: молоко, хлеб, масло"));
        System.out.println("--------------------");
        System.out.println("Task 2:");
        System.out.println(task2("Все решено! Едем дальше"));
        System.out.println("--------------------");
        System.out.println("Task 3:");
        System.out.println(task3("   Привет, как дела?   "));
        

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
     * г)Выяснить,имеется ли среди s1,...,sn пара соседствующих букв но или он.
     */
    public static boolean task2(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if ((str.charAt(i) == 'n' || str.charAt(i) == 'o') && (str.charAt(i + 1) == 'n' || str.charAt(i + 1) == 'o')) {
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
        int start = 0;
        int end = str.length() - 1;
        while (start < str.length() && str.charAt(start) == ' ') {
            start++;
        }
        while (end >= 0 && str.charAt(end) == ' ') {
            end--;
        }
        StringBuilder result = new StringBuilder();
        boolean isSpace = false;
        for (int i = start; i <= end; i++) {
            if (str.charAt(i) == ' ') {
                if (!isSpace) {
                    result.append(' ');
                    isSpace = true;
                }
            } else {
                result.append(str.charAt(i));
                isSpace = false;
            }
        }
        return result.toString();
    }
}
