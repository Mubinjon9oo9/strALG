import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab6 {
    public Lab6(){
        System.out.println("Task1");
        // task1();
        // System.out.println("--------------------");
        // System.out.println("Task2");
        // // task2();
        System.out.println("--------------------");
        System.out.println("Task3");
        System.out.println(task3("(a+b)+c"));
        System.out.println(task3("(()))"));
        System.out.println("--------------------");
        System.out.println("Task4");
        task4();
        System.out.println("--------------------");
        System.out.println("Task5");
        task5();
        // System.out.println("--------------------");
        // System.out.println("TaskQueueShift");
        // taskQueueShift();
        // System.out.println("--------------------");
        // System.out.println("TaskStackIndex");
        // taskStackIndex();
        // System.out.println("--------------------");
    }
    
    /*
     * 1. Для работы с очередью, т.е. последовательностью элементов, в которую элементы всегда добавляются в конец, 
     * а удаляются из начала ("первым пришел - первым ушел"), нужны обычно следующие операции:
     * ОЧИСТОЧ(Q) - создать пустую очередь Q (очистить очередь);
     * ПУСТОЧ(Q) - проверить, является ли очередь Q пустой;
     * ПЕЧОЧ(Q) – распечатать содержимое очереди;
     * ВОЧЕРЕДЬ(Q,x) - добавить в конец очереди Q элемент x;
     * ИЗОЧЕРЕДЬ(Q,x) - удалить из очереди Q первый элемент, присвоив его параметру x.
     * Требуется для каждого из указанных ниже представлений очереди описать
     * соответствующий тип ОЧЕРЕДЬ, считая, что все элементы очереди имеют некоторый тип ТЭО, 
     * и реализовать в виде процедур или функций перечисленные операции над очередью 
     * ( если операция по тем или иным причинам не может быть выполнена, следует передать управление некоторой процедуре ОШИБКА(k), 
     * считая ее уже описанной, где k - номер ошибки: 1 - переполнение очереди, 2 - исчерпание очереди).
     * Представление очереди (n – целая константа >1):
     * а) для каждой очереди отводится свой массив из N компонентов типа ТЭО, 
     * в котором элементы очереди занимают группу соседних компонент, индексы первой и последней из которых запоминаются; 
     * при этом, когда очередь достигает правого края массива, все ее элементы сдвигаются к левому краю;
     */
    public static class QueueA {
        int[] array;
        int first;
        int last;
        int size;
        final int N;

        public QueueA(int N) {
            this.N = N;
            array = new int[N];
            first = 0;
            last = 0;
            size = 0;
        }

        public void clear() {
            first = 0;
            last = 0;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void print() {
            if (isEmpty()) {
                System.out.println("Очередь пуста");
                return;
            }
            int i = first;
            while (i != last) {
                System.out.print(array[i] + " ");
                i = (i + 1) % N;
            }
            System.out.println();
        }

        public void enqueue(int x) {
            if (size == N) {
                error(1);
            }
            array[last] = x;
            last = (last + 1) % N;
            size++;
        }

        public void dequeue() {
            if (isEmpty()) {
                error(2);
            }
            first = (first + 1) % N;
            size--;
        }

        private void error(int k) {
            System.out.println("Ошибка " + k);
            System.exit(0);
        }
    }

    /*
     * 2. Для работы со стеком, т.е. последовательностью элементов, в которой элементы всегда добавляются в конец 
     * и удаляются из конца ("последним пришел - первым ушел"), нужны обычно следующие операции:
     * ОЧИСТЕК(S) - создать пустой стек S (очистить стек);
     * ПЕЧСТЕК(S) – распечатать содержимое стека;
     * ПУСТЕК(S) - проверить, является ли стек S пустым;
     * ВСТЕК(S,X) - добавить в конец стека S элемент X;
     * ИЗСТЕК(S,X) - удалить из очереди S последний элемент, присвоив его параметру X.
     * Требуется для каждого из указанных ниже представлений стека описать
     * соответствующий тип СТЕК, считая, что все элементы стека имеют некоторый тип ТЭC, 
     * и реализовать в виде процедур или функций перечисленные операции над
     * стеком (если операция по тем или иным причинам невыполнима, следует передать управление некоторой процедуре ОШИБКА(k), 
     * считая ее уже описанной, где k - номер ошибки: 1 -переполнение стека, 2 -исчерпание стека).
     * Представление стека (n -целая константа>1):
     * а) для каждого стека отводится свой массив из n компонентов типа ТЭC, 
     * в начале которого располагаются элементы стека, при этом запоминается индекс компоненты массива, 
     * занятой последним элементом стека;
     */
    public static class StackA {
        int[] array;
        int top;
        final int N;

        public StackA(int N) {
            this.N = N;
            array = new int[N];
            top = -1;
        }

        public void clear() {
            top = -1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public void print() {
            if (isEmpty()) {
                System.out.println("Стек пуст");
                return;
            }
            for (int i = 0; i <= top; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }

        public void push(int x) {
            if (top == N - 1) {
                error(1);
            }
            array[++top] = x;
        }

        public void pop() {
            if (isEmpty()) {
                error(2);
            }
            top--;
        }

        private void error(int k) {
            System.out.println("Ошибка " + k);
            System.exit(0);
        }
    }

    /*
     * 7. Используя стек (предварительно выбрав и описав его тип и создав все нужные для решения функции и 
     * процедуры для работы с этим стеком (ПУСТЕК(S), ПЕЧСТЕК(S), ОЧИСТЕК(S), ВСТЕК(S,x) и ИЗТЕК(S,x) (задача 2))), 
     * решить следующую задачу.
     * Проверить, является ли содержимое текстового файла t правильной записью формулы следующего вида:
     * <формула>::= <терм> | <терм>+<формула> | <терм>-<формула>
     * <терм>::= <имя> | <(<формула>) | [<формула>] | {<формула>}
     * <имя::= x | y | z
     */
    public static boolean task3(String t) {
        StackA stack = new StackA(t.length());
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char open = (char) stack.array[stack.top];
                if ((c == ')' && open != '(') || (c == ']' && open != '[') || (c == '}' && open != '{')) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }


    /*
     * 22. Сформировать файл из натуральных чисел и с помощью очереди за один просмотр файла 
     * напечатать элементы файла в следующем порядке: сначала все однозначные числа, затем все двузначные. 
     * Первая группа чисел выводится в исходном порядке, вторая - в обратном порядке. 
     * Например: 2, 15, 7, 24, 37, 8   2, 7, 8, 37, 24, 15.
     */
    public static void task4() {
        QueueA queueSingleDigit = new QueueA(100); // Очередь для однозначных чисел
        QueueA queueDoubleDigit = new QueueA(100); // Очередь для двузначных чисел

        try (Scanner scanner = new Scanner(new File("/Users/mubinjon9009/Downloads/Projects/structALG/strALG/src/input.txt"))) {
            while (scanner.hasNextInt()) {
                int x = scanner.nextInt();
                if (x < 10) {
                    queueSingleDigit.enqueue(x); // Однозначные числа
                } else if (x < 100) {
                    queueDoubleDigit.enqueue(x); // Двузначные числа
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // Сортируем однозначные числа в порядке возрастания
        int[] singleDigitArray = new int[queueSingleDigit.size];
        for (int i = 0; i < singleDigitArray.length; i++) {
            singleDigitArray[i] = queueSingleDigit.array[queueSingleDigit.first];
            queueSingleDigit.dequeue();
        }
        Arrays.sort(singleDigitArray);

        // Сортируем двузначные числа в порядке убывания
        int[] doubleDigitArray = new int[queueDoubleDigit.size];
        for (int i = 0; i < doubleDigitArray.length; i++) {
            doubleDigitArray[i] = queueDoubleDigit.array[queueDoubleDigit.first];
            queueDoubleDigit.dequeue();
        }
        Arrays.sort(doubleDigitArray);
        for (int i = 0; i < doubleDigitArray.length / 2; i++) {
            int temp = doubleDigitArray[i];
            doubleDigitArray[i] = doubleDigitArray[doubleDigitArray.length - 1 - i];
            doubleDigitArray[doubleDigitArray.length - 1 - i] = temp;
        }

        // Выводим результат
        System.out.println("Однозначные числа (по возрастанию):");
        for (int num : singleDigitArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Двузначные числа (по убыванию):");
        for (int num : doubleDigitArray) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /*
     * 31. Используя очередь или стек (предварительно описав его тип и операции над ним (упр.1 или упр.2)), 
     * описать процедуру или функцию, которая печатает все элементы дерева Т по уровням 
     * ( сначала - из корня дерева, затем (слева направо) - из вершин, дочерних по отношению к корню, 
     * затем (также слева направо) - из вершин, дочерних по отношению к этим вершинам, и т.д.) (ТЭД=integer). 
     * Продемонстрировать работу программы.
     */
    public static void task5() {

        // Создаём пример дерева
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(8);
        root.right.right = new Node(7);

        // // Если дерево пустое
        // if (root == null) {
        //     System.out.println("Дерево пустое.");
        //     return;
        // }

        // Очередь для обхода дерева
        QueueB<Node> queue = new QueueB<>(100); // Очередь с размером 100
        queue.enqueue(root);

        // Обход дерева по уровням
        while (!queue.isEmpty()) {
            Node current = queue.dequeue(); // Извлекаем текущий узел
            System.out.print(current.value + " "); // Печатаем значение узла

            // Добавляем дочерние узлы в очередь
            if (current.left != null) {
                queue.enqueue(current.left);
            }
            if (current.right != null) {
                queue.enqueue(current.right);
            }
        }
        System.out.println();
    }

    public static void task1() {
        Scanner scanner = new Scanner(System.in);
        Map<String, QueueA> queues = new HashMap<>();
        Map<String, StackA> stacks = new HashMap<>();

        System.out.println("Добро пожаловать в интерактивный режим!");
        System.out.println("Доступные команды:");
        System.out.println("ОЧИСТОЧ <имя> - очистить очередь");
        System.out.println("ПУСТОЧ <имя> - проверить, является ли очередь пустой");
        System.out.println("ПЕЧОЧ <имя> - распечатать содержимое очереди");
        System.out.println("ВОЧЕРЕДЬ <имя> <число> - добавить элемент в очередь");
        System.out.println("ИЗОЧЕРЕДЬ <имя> - удалить первый элемент из очереди");
        System.out.println("ОЧИСТЕК <имя> - очистить стек");
        System.out.println("ПУСТЕК <имя> - проверить, является ли стек пустым");
        System.out.println("ПЕЧСТЕК <имя> - распечатать содержимое стека");
        System.out.println("ВСТЕК <имя> <число> - добавить элемент в стек");
        System.out.println("ИЗСТЕК <имя> - удалить последний элемент из стека");
        System.out.println("EXIT - выйти из программы");

        while (true) {
            System.out.print("Введите команду: ");
            String[] input = scanner.nextLine().trim().split("\\s+");
            String command = input[0].toUpperCase();

            if (command.equals("ОЧИСТОЧ")) {
                String name = input[1];
                queues.putIfAbsent(name, new QueueA(10));
                queues.get(name).clear();
                System.out.println("Очередь " + name + " очищена.");
            } else if (command.equals("ПУСТОЧ")) {
                String name = input[1];
                queues.putIfAbsent(name, new QueueA(10));
                System.out.println(queues.get(name).isEmpty() ? "Очередь " + name + " пуста." : "Очередь " + name + " не пуста.");
            } else if (command.equals("ПЕЧОЧ")) {
                String name = input[1];
                queues.putIfAbsent(name, new QueueA(10));
                queues.get(name).print();
            } else if (command.equals("ВОЧЕРЕДЬ")) {
                String name = input[1];
                int value = Integer.parseInt(input[2]);
                queues.putIfAbsent(name, new QueueA(10));
                queues.get(name).enqueue(value);
                System.out.println("Элемент " + value + " добавлен в очередь " + name + ".");
            } else if (command.equals("ИЗОЧЕРЕДЬ")) {
                String name = input[1];
                queues.putIfAbsent(name, new QueueA(10));
                try {
                    queues.get(name).dequeue();
                    System.out.println("Первый элемент удалён из очереди " + name + ".");
                } catch (Exception e) {
                    System.out.println("Ошибка: очередь " + name + " пуста.");
                }
            } else if (command.equals("ОЧИСТЕК")) {
                String name = input[1];
                stacks.putIfAbsent(name, new StackA(10));
                stacks.get(name).clear();
                System.out.println("Стек " + name + " очищен.");
            } else if (command.equals("ПУСТЕК")) {
                String name = input[1];
                stacks.putIfAbsent(name, new StackA(10));
                System.out.println(stacks.get(name).isEmpty() ? "Стек " + name + " пуст." : "Стек " + name + " не пуст.");
            } else if (command.equals("ПЕЧСТЕК")) {
                String name = input[1];
                stacks.putIfAbsent(name, new StackA(10));
                stacks.get(name).print();
            } else if (command.equals("ВСТЕК")) {
                String name = input[1];
                int value = Integer.parseInt(input[2]);
                stacks.putIfAbsent(name, new StackA(10));
                stacks.get(name).push(value);
                System.out.println("Элемент " + value + " добавлен в стек " + name + ".");
            } else if (command.equals("ИЗСТЕК")) {
                String name = input[1];
                stacks.putIfAbsent(name, new StackA(10));
                try {
                    stacks.get(name).pop();
                    System.out.println("Последний элемент удалён из стека " + name + ".");
                } catch (Exception e) {
                    System.out.println("Ошибка: стек " + name + " пуст.");
                }
            } else if (command.equals("EXIT")) {
                System.out.println("Выход из программы.");
                break;
            } else {
                System.out.println("Неизвестная команда. Попробуйте снова.");
            }
        }

        scanner.close();
    }

    // public static void taskQueueShift() {
    //     System.out.println("=== Задача с очередью: сдвиг элементов к левому краю ===");
    //     QueueA queue = new QueueA(5); // Очередь с размером 5
    //     // Добавляем элементы в очередь
    //     queue.enqueue(10);
    //     queue.enqueue(20);
    //     queue.enqueue(30);
    //     queue.enqueue(40);
    //     queue.enqueue(50);
    //     queue.print();
    //     System.out.println("Очередь до сдвига:");
    //     queue.isEmpty();
    //     queue.print();
    //     queue.print();
    //     // Удаляем несколько элементов
    //     queue.dequeue();
    //     queue.dequeue();

    //     System.out.println("Очередь после удаления двух элементов:");
    //     queue.print();

    //     // Сдвигаем элементы к левому краю
    //     shiftQueueToLeft(queue);

    //     System.out.println("Очередь после сдвига к левому краю:");
    //     queue.print();
    // }

    // // Метод для сдвига элементов очереди к левому краю
    // private static void shiftQueueToLeft(QueueA queue) {
    //     int[] newArray = new int[queue.N];
    //     int index = 0;

    //     while (!queue.isEmpty()) {
    //         newArray[index++] = queue.array[queue.first];
    //         queue.dequeue();
    //     }

    //     queue.array = newArray;
    //     queue.first = 0;
    //     queue.last = index;
    //     queue.size = index;
    // }

    // public static void taskStackIndex() {
    //     System.out.println("=== Задача со стеком: индекс последнего элемента ===");
    //     StackA stack = new StackA(5); // Стек с размером 5

    //     // Добавляем элементы в стек
    //     stack.push(5);
    //     stack.push(10);
    //     stack.push(15);

    //     System.out.println("Стек после добавления элементов:");
    //     stack.print();

    //     // Выводим индекс последнего элемента
    //     System.out.println("Индекс последнего элемента: " + stack.top);

    //     // Удаляем элемент из стека
    //     stack.pop();

    //     System.out.println("Стек после удаления элемента:");
    //     stack.print();

    //     // Выводим обновлённый индекс последнего элемента
    //     System.out.println("Индекс последнего элемента: " + stack.top);
    // }
    public static class Node {
        int value;
        Node left;
        Node right;
    
        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    public static class QueueB<T> {
        T[] array;
        int first;
        int last;
        int size;
        final int N;
    
        @SuppressWarnings("unchecked")
        public QueueB(int N) {
            this.N = N;
            array = (T[]) new Object[N];
            first = 0;
            last = 0;
            size = 0;
        }
    
        public void clear() {
            first = 0;
            last = 0;
            size = 0;
        }
    
        public boolean isEmpty() {
            return size == 0;
        }
    
        public void print() {
            if (isEmpty()) {
                System.out.println("Очередь пуста");
                return;
            }
            int i = first;
            while (i != last) {
                System.out.print(array[i] + " ");
                i = (i + 1) % N;
            }
            System.out.println();
        }
    
        public void enqueue(T x) {
            if (size == N) {
                error(1);
            }
            array[last] = x;
            last = (last + 1) % N;
            size++;
        }
    
        public T dequeue() {
            if (isEmpty()) {
                error(2);
            }
            T x = array[first];
            first = (first + 1) % N;
            size--;
            return x;
        }
    
        private void error(int k) {
            System.out.println("Ошибка " + k);
            System.exit(0);
        }
    }
}
