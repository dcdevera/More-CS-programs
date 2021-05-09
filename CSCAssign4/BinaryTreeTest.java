
/**
 * Write a description of class BinaryTreeTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;
public class BinaryTreeTest
{
    public static void main(String[] args)
    {
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(0);
        bt.root.left = new Node(1);
        bt.root.right = new Node(2);
        bt.root.left.left = new Node(3);
        bt.root.right.right = new Node(4);
        bt.root.left.right = new Node(5);
        bt.root.right.left = new Node(6);
        
        System.out.println("Left Subtree");
        System.out.println(bt.getLeftSubtree());
        System.out.println("Right Subtree");
        System.out.println(bt.getRightSubtree());
        System.out.println("Get root");
        System.out.println(bt.getData());
        System.out.println("Check for Leaf node");
        System.out.println(bt.isLeaf());
        System.out.println("Print representation of Binary Tree");
        System.out.println(bt.toString());
        
        
        System.out.println("Preorder");
        bt.preOrderTraverse(bt.root);
        System.out.println("");
        System.out.println("Inorder");
        bt.inOrderTraverse(bt.root);
        System.out.println("");
        System.out.println("Postorder");
        bt.postOrderTraverse(bt.root);
        
    }
    
}
