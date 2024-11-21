public class BST {
    private int size;
    private TreeNode root;
    public BST() {
        size = 0;
        root = null;
    }

    public <E> void add(E value) {
        TreeNode newNode = new TreeNode((Comparable) value, null, null);
        TreeNode currNode = root;

        if (size == 0) {
            root = newNode;
            size++;
        }

        while(!(newNode.getLeftChild() == null) && !(newNode.getRightChild() == null)) {
            if(newNode.getValue().compareTo(currNode.getValue()) <= 0) {
                currNode = currNode.getLeftChild();
                //move currNode to the left of the key
            }
            else if (newNode.getValue().compareTo(currNode.getValue()) > 0) {
                //move currNode to the right of the key
                currNode = currNode.getRightChild();
            }
        }

        if (newNode.getValue().compareTo(currNode.getValue()) <= 0) {
            currNode.setLeftChild(newNode);
            size++;
        }
        else if (newNode.getValue().compareTo(currNode.getValue()) > 0) {
            currNode.setRightChild(newNode);
            size++;
        }

            //add a node to the tree

    }

    public <E> boolean contains(E value) {
        return true;
    }

    public int countNodes() {
        return size;
    }

    public int countLeafNodes() {



        //returns the number of leaf nodes in tree
        return 0;

    }

    public int getHeight() {
        //returns the longest path from the root to a leaf node
        return 0;
    }

    public String printInorder() {
        //
        return helperIn(root);



    }
    public String helperIn(TreeNode currNode) {

        //iterate through the left subtree
        //then go up and over the right
        //then count the root
        //then do the right subtree






    }

    public void printPreorder() {
        //
    }

    public void printPostorder() {

    }

    public <E> E delete(E value) {
        return null;
    }







//        void add(E value)
//        boolean contains(E value)
//        int countNodes() //returns the number of nodes in the tree
//        int countLeafNodes() //returns the number of leaf nodes in tree
//        int getHeight() //returns the longest path from the root to a leaf node
//        void printInorder()
//        void printPreorder()
//        void printPostorder()
//        E delete(E value) //returns the deleted node

}
