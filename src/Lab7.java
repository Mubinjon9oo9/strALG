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

    }

    /*
     * 11. Создать и продемонстрировать работу логической функции same(T), 
     * определяющую, есть ли в дереве Т хотя бы два одинаковых элемента.
     */
    class TreeNode {
        int val;
        TreeNode left, right;
        
        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
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
    
}
