import com.sun.source.tree.Tree;

/**
 * Create a class BST that instantiates the size, root of the tree, and the output for pre, post, and inorder
 */

public class BST {
    private int size;
    private TreeNode root;
    private String output;
    public BST() {
        size = 0;
        root = null;
        String output = "";
    }

    /**
     * Add a node to the tree
     * @param value takes in the value of the node
     * @param <E> the type
     * If the size of the tree is 0, then it sets the newNode to the root and makes the size 1 bigger
     *
     */

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
    }

    /**
     * Checks to see if a value is in the tree
     * CompareTo method compares the values of two objects and returns either a 1 (currentNode > value), 0 (currNode == value), or false
     * While the left and right children are not null, and if the value of the currNode > value, continue to traverse the left subtree
     * If currNode == 0, return true
     * Does the same on the right subtree
     * Else, returns false
     * If the balance facto
     */

    public <E> boolean contains(E value) {
        TreeNode currNode = root;

        while(!(currNode.getLeftChild() == null) && !(currNode.getRightChild() == null)) {
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

    /**
     * Counts the number of nodes in the tree
     * If currNode == null, that means no nodes, so return 0
     * Otherwise, recursively return the nodes in the left and right subtrees + 1 to account for the currNode
     * * @return the number of nodes in the tree
     */

    public int countNodes() {
        return helperCountNodes(root);
    }
    public int helperCountNodes(TreeNode currNode) {
        if (currNode == null) {
            return 0;
        } else {
            return 1 + helperCountNodes(currNode.getLeftChild()) + helperCountNodes(currNode.getRightChild());
        }
    }

    /**
     * Count the number of leaf nodes in the tree (nodes with no children)
     * If the currNode == null, return 0 (emty tree)
     * If the left and right children are null, add one
     * Else, continue to call the left and right subtrees
     */

    public int countLeafNodes() {
        return helperCountLeafNodes(root);
    }
    public int helperCountLeafNodes(TreeNode currNode) {
        if (currNode == null) {
            return 0;
        } if (currNode.getLeftChild() == null && currNode.getRightChild() == null) {
            return 1;
        }
        else {
            return helperCountLeafNodes(currNode.getLeftChild()) + helperCountLeafNodes(currNode.getRightChild());
        }
    }


    /**
     * Get the height of the tree
     * If the left and right children are not null, return the max of the two numbers + 1
     * If the right is not null, keep going through the right subtree and add 1
     * Do the same for the left
     * Else, return just 1
     */

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

    /**
     * Print the order of values from left - root - right
     * Checks to see if the tree is empty
     * Recursively goes through the left subtree, prints the root, then recursively goes through the right subtree
     * places all the values of currNode into the output
     */
    public void printInorder() {
        helperIn(root);
    }
    public String helperIn(TreeNode currNode) {
        //left - root - right
        if (currNode == null) {
            return null;
        }
        helperIn(currNode.getLeftChild());
        System.out.print(currNode.getValue());
        helperIn(currNode.getRightChild());
        return output += currNode.getValue();
    }

    /**
     * Print the order of values from root - left - right
     * Same process as above, printing the root then recursively calling the left and right subtrees
     */
    public void printPreorder() {
        helperPre(root);
    }
    public String helperPre(TreeNode currNode) {
        //root - left - right
        if (currNode == null) {
            return null;
        } else {
            System.out.print(currNode.getValue());
            helperPre(currNode.getLeftChild());
            helperPre(currNode.getRightChild());
        }
        return output += currNode.getValue();
    }


    /**
     * Print the order of values from the left - right - root
     * Same process as above, recursively call the left and right subtrees then print the root
     */
    public void printPostorder() {
        helperPost(root);
    }
    public String helperPost(TreeNode currNode) {
        //left - right - root
        if (currNode == null) {
            return null;
        } else {
            helperPost(currNode.getLeftChild());
            helperPost(currNode.getRightChild());
            System.out.print(currNode.getValue());
        }
        return output += currNode.getValue();
    }

    //Delete a leaf node
    //Delete a node with a single child
    //Delete a node with both children


//    public <E> void delete(E value) {
//        if (root == null) {
//            return root;
//        }
//
//
//
//    }





    }
