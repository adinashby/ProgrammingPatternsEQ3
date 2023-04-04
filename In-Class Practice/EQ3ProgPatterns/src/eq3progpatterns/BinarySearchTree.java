/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eq3progpatterns;

/**
 *
 * @author adinashby
 */
public class BinarySearchTree {

    /*
	 * Class containing left and right child of current node and key value
     */
    class Node {

        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    BinarySearchTree(int value) {
        root = new Node(value);
    }

    // This method mainly calls insertRec()
    void insert(int key) {
        root = insertRec(root, key);
    }

    /*
	 * A recursive function to insert a new key in BST
     */
    Node insertRec(Node root, int key) {

        /*
		 * If the tree is empty, return a new node
         */
        if (root == null) {
            root = new Node(key);

            return root;
        } /* Otherwise, recur down the tree */ else if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder() {
        inorderRec(root);
    }

    // A utility function to
    // do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    void preorder() {
        preorderRec(root);
    }

    // A utility function to
    // do inorder traversal of BST
    void preorderRec(Node root) {
        if (root != null) {
            System.out.println(root.key);
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    void postorder() {
        postorderRec(root);
    }

    // A utility function to
    // do inorder traversal of BST
    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.println(root.key);
        }
    }

    // Driver Code
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /*
		 * Let us create following BST 50 / \ 30 70 / \ / \ 20 40 60 80
         */
        tree.insert(99);
        tree.insert(80);
        tree.insert(70);
        tree.insert(85);
        tree.insert(82);
        tree.insert(87);
        tree.insert(110);
        tree.insert(105);
        tree.insert(130);

        // print inorder traversal of the BST
        tree.inorder();
        
        System.out.println("");
        
        tree.preorder();
        
        System.out.println("");
        
        tree.postorder();
    }
}
