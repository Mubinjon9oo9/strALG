import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class Lab7 {
    public Lab7(){
        System.out.println("Task1");
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5); 
        System.out.println(same(root));
        System.out.println("--------------------");
        System.out.println("Task2");
        // Пример дерева-формулы: (5 * (3 + 8))
        FormulaNode root1 = new FormulaNode('*');
        root1.left = new FormulaNode('5');
        root1.right = new FormulaNode('+');
        root1.right.left = new FormulaNode('3');
        root1.right.right = new FormulaNode('8');

        System.out.println("Исходное дерево-формула:");
        printTree(root1, 0);

        // Преобразуем дерево
        transformTree(root1);

        System.out.println("\nПреобразованное дерево-формула:");
        printTree(root1, 0);

        System.out.println("--------------------");
        System.out.println("Task3");
        // Создаём пример дерева поиска
        TreeNode root3 = new TreeNode(10);
        root3.left = new TreeNode(5);
        root3.right = new TreeNode(15);
        root3.left.left = new TreeNode(3);
        root3.left.right = new TreeNode(7);
        root3.right.left = new TreeNode(12);
        root3.right.right = new TreeNode(18);

        // Записываем элементы дерева в файл
        String filePath = "output.txt";
        try {
            writeTreeToFile(root3, filePath);
            System.out.println("Элементы дерева записаны в файл: " + filePath);
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    /*
     * 11. Создать и продемонстрировать работу логической функции same(T), 
     * определяющую, есть ли в дереве Т хотя бы два одинаковых элемента.
     */
    static class TreeNode {
        int val;
        TreeNode left, right;
        
        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static boolean same(TreeNode root) {
        HashSet<Integer> set = new HashSet<>();
        return hasDuplicate(root, set);
    }
    
    private static boolean hasDuplicate(TreeNode node, HashSet<Integer> set) {
        if (node == null) {
            return false;
        }
        
        if (set.contains(node.val)) {
            return true;
        }
        
        set.add(node.val);
        
        return hasDuplicate(node.left, set) || hasDuplicate(node.right, set);
    }

    /*
     * 25. Предложить и описать представление в виде двоичного дерева для формул 
     * из упр.12, в которых в качестве терминалов используются 
     * любые неотрицательные целые числа. Пусть в дереве-формуле в качестве терминалов
     * используются не только цифры, но и буквы, играющие роль переменных. 
     * Создать и продемонстрировать работу программы, 
     * которая преобразует дерево-формулу Т, заменяя в нем все поддеревья, соответствующие формулам 
     * ((f1+f2)*f3,(f1-f2)*f3, f1*(f2+f3), f1*(f2-f3)) на поддеревья, 
     * соответствующие формулам ((f1*f3)+(f2*f3), (f1*f3)-(f2*f3), (f1*f2)+(f1*f3), (f1*f2)-(f1*f3)).
     * 
     * упр12: можно представить в виде двоичного дерева ("дерева-формулы") с ТЭД=char согласно следующим правилам: 
     * формула из одного терминала (цифры) представляется деревом из одной вершины с этим терминалом, 
     * а формула вида (f1 s f2) - деревом, в котором корень - это знак s, 
     * а левое и правое поддеревья - это соответствующие представления формул f1 и f2. На рис. 9.2 показано дерево- формула, 
     * соответствующее формуле (5*(3+8)).
     */
    // Преобразование дерева-формулы
    static class FormulaNode {
        char value; // Символ (оператор или терминал)
        FormulaNode left, right;

        FormulaNode(char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    public static void transformTree(FormulaNode node) {
        if (node == null) {
            return;
        }

        // Рекурсивно преобразуем левое и правое поддеревья
        transformTree(node.left);
        transformTree(node.right);

        // Проверяем и преобразуем поддеревья
        if (node.value == '*') {
            if (node.right != null && node.right.value == '+') {
                // Преобразуем f1 * (f2 + f3) -> (f1 * f2) + (f1 * f3)
                FormulaNode f1 = node.left;
                FormulaNode f2 = node.right.left;
                FormulaNode f3 = node.right.right;

                node.value = '+';
                node.left = new FormulaNode('*');
                node.left.left = f1;
                node.left.right = f2;
                node.right = new FormulaNode('*');
                node.right.left = f1;
                node.right.right = f3;
            } else if (node.right != null && node.right.value == '-') {
                // Преобразуем f1 * (f2 - f3) -> (f1 * f2) - (f1 * f3)
                FormulaNode f1 = node.left;
                FormulaNode f2 = node.right.left;
                FormulaNode f3 = node.right.right;

                node.value = '-';
                node.left = new FormulaNode('*');
                node.left.left = f1;
                node.left.right = f2;
                node.right = new FormulaNode('*');
                node.right.left = f1;
                node.right.right = f3;
            } else if (node.left != null && node.left.value == '+') {
                // Преобразуем (f1 + f2) * f3 -> (f1 * f3) + (f2 * f3)
                FormulaNode f1 = node.left.left;
                FormulaNode f2 = node.left.right;
                FormulaNode f3 = node.right;

                node.value = '+';
                node.left = new FormulaNode('*');
                node.left.left = f1;
                node.left.right = f3;
                node.right = new FormulaNode('*');
                node.right.left = f2;
                node.right.right = f3;
            } else if (node.left != null && node.left.value == '-') {
                // Преобразуем (f1 - f2) * f3 -> (f1 * f3) - (f2 * f3)
                FormulaNode f1 = node.left.left;
                FormulaNode f2 = node.left.right;
                FormulaNode f3 = node.right;

                node.value = '-';
                node.left = new FormulaNode('*');
                node.left.left = f1;
                node.left.right = f3;
                node.right = new FormulaNode('*');
                node.right.left = f2;
                node.right.right = f3;
            }
        }
    }

    public static void printTree(FormulaNode node, int level) {
        if (node == null) {
            return;
        }
        printTree(node.right, level + 1);
        System.out.println("  ".repeat(level) + node.value);
        printTree(node.left, level + 1);
    }

    /*29. Тип дерево и тип файл, такие же, как в упр 28. 
    Написать и продемонстрировать программу, которая записывает в файл f 
    элементы дерева поиска Т в порядке их возрастания. 
    
    упр28: Деревом поиска, или таблицей в виде дерева, называется 
    двоичное дерево, в котором слева от любой вершины находятся вершины 
    с элементами, меньшими элемента из этой вершины, 
    а справа - с большими элементами (предполагается, что все элементы 
    дерева попарно различны и что их тип (ТЭД) допускает применение 
    операций сравнения). Пример такого дерева показан на рис. 9.2.
    Описав тип дерево (см. выше) и тип файл:
    type файл=file of ТЭД;
    */ 
     // Метод для записи элементов дерева в файл в порядке возрастания
    public static void writeTreeToFile(TreeNode root, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            inOrderTraversal(root, writer);
        }
    }

    // Обход дерева in-order и запись элементов в файл
    private static void inOrderTraversal(TreeNode node, BufferedWriter writer) throws IOException {
        if (node == null) {
            return;
        }
        // Рекурсивно обходим левое поддерево
        inOrderTraversal(node.left, writer);
        // Записываем значение текущего узла
        writer.write(node.val + "\n");
        // Рекурсивно обходим правое поддерево
        inOrderTraversal(node.right, writer);
    }   
}
