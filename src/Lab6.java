
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab6 {
    public Lab6(){
        System.out.println("Task1");
        // task1();
        System.out.println("--------------------");
        System.out.println("Task2");
        // task2();
        System.out.println("--------------------");
        System.out.println("Task3");
        System.out.println(task3("((()))"));
        System.out.println(task3("(()))"));
        System.out.println("--------------------");
        System.out.println("Task4");
        task4();
        System.out.println("--------------------");
        System.out.println("Task5");
        task5();
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
        QueueA queue = new QueueA(100);
        QueueA queue1 = new QueueA(100);
        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            while (scanner.hasNextInt()) {
                int x = scanner.nextInt();
                if (x < 10) {
                    queue.enqueue(x);
                }
                else{
                    queue1.enqueue(x);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.array[queue.first] + " ");
            queue.dequeue();
        }
        System.out.println();
        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            while (scanner.hasNextInt()) {
                int x = scanner.nextInt();
                if (x >= 10) {
                    queue.enqueue(x);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.array[queue.first] + " ");
            queue.dequeue();
        }
    }

    /*
     * 31. Используя очередь или стек (предварительно описав его тип и операции над ним (упр.1 или упр.2)), 
     * описать процедуру или функцию, которая печатает все элементы дерева Т по уровням 
     * ( сначала - из корня дерева, затем (слева направо) - из вершин, дочерних по отношению к корню, 
     * затем (также слева направо) - из вершин, дочерних по отношению к этим вершинам, и т.д.) (ТЭД=integer). 
     * Продемонстрировать работу программы.
     */
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    public static void task5() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        QueueA queue = new QueueA(100);
        queue.enqueue(root.value);
        while (!queue.isEmpty()) {
            int x = queue.array[queue.first];
            queue.dequeue();
            System.out.print(x + " ");
            if (root.left != null) {
                queue.enqueue(root.left.value);
            }
            if (root.right != null) {
                queue.enqueue(root.right.value);
            }
        }
    }
}
