public class Main {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.add(3);
        tree.add(4);
        tree.add(1);
        tree.add(14);
        tree.add(12);
        System.out.println(tree.getHeight());

        tree.printInorder();
        System.out.println(" ");
        tree.printPreorder();
        System.out.println(" ");
        tree.printPostorder();
        System.out.println(" ");
        System.out.print(tree.countNodes());
        System.out.print(tree.countLeafNodes());






    }
}