import com.sun.source.tree.Tree;

public class BST {
    private int size;
    private TreeNode root;
    private String output;
    public BST() {
        size = 0;
        root = null;
        String output = "";
    }

    public <E> void add(E value) {
        TreeNode newNode = new TreeNode((Comparable) value, null, null);
        TreeNode currNode = root;
        if (size == 0) {
            root = newNode;
            currNode = root;
            size++;
            return;
        }

        while(!(currNode.getLeftChild() == null) && !(currNode.getRightChild() == null)) {
            if(newNode.getValue().compareTo(currNode.getValue()) <= 0) {
                currNode = currNode.getLeftChild();
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
        TreeNode currNode = root;

        while(!(currNode.getLeftChild() ==null) && !(currNode.getRightChild() == null)) {
            if(currNode.getValue().compareTo(value) == 1) {
                currNode = currNode.getLeftChild();
                if (currNode.getValue().compareTo(value) == 0) {
                    return true;
                }
            }
            else if (currNode.getValue().compareTo(value) < 1) {
                currNode = currNode.getRightChild();
                if (currNode.getValue().compareTo(value) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public int countNodes(TreeNode currNode) {
        return 0;


    }

    public int countLeafNodes(TreeNode currNode) {
        //if left and right vhild are null then count up
        currNode = root;

        if (currNode.getLeftChild() == null && currNode.getRightChild() == null) {
            return 1;
        }

        //if just left
        //if just right




    }

    public int getHeight() {
        return helperHeight(root) - 1;
        //returns the longest path from the root to a leaf node


    }
    public int helperHeight(TreeNode currNode) {

        if (currNode.getLeftChild() != null && currNode.getRightChild() != null) {
            return Math.max(helperHeight(currNode.getLeftChild()), helperHeight(currNode.getRightChild()) + 1);
        } else if (currNode.getRightChild() != null) {
            return 1 + helperHeight(currNode.getRightChild());
        } else if (currNode.getLeftChild() != null) {
            return 1 + helperHeight(currNode.getLeftChild());
        } else {
            return 1;
        }
    }

    public void printInorder() {
        helperIn(root);

    }
    public String helperIn(TreeNode currNode) {
        if (currNode == null) {
            return null;
        }
        helperIn(currNode.getLeftChild());
        System.out.print(currNode.getValue() + " ");
        helperIn(currNode.getRightChild());
        return output += currNode.getValue();
    }





    public void printPreorder() {
        //
    }

    public void printPostorder() {

    }

    public <E> E delete(E value) {
        return null;
        //if deleting a tree node,

//
//        if (root == null) {
//            return root;
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
