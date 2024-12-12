public class Main {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.add(5);
        tree.add(9);
        tree.add(1);
        tree.add(7);
        tree.add(11);
        tree.add(0);
        tree.contains(0);
        System.out.println(tree.getHeight());
        tree.printInorder();
        System.out.println(" ");
        tree.printPreorder();
        System.out.println(" ");
        tree.printPostorder();
    }
}