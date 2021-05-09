/**
 * Write a description of class BinaryTree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;
public class BinaryTree<E> implements Serializable
{
    public Node<E> root;
    
    public BinaryTree()
    {
        root = null;
    }
    
    public BinaryTree(Node<E> root)
    {
        this.root = root;
    }
    
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree)
    {
        root = new Node<E>(data);
        if(leftTree != null)
        {
            root.left = leftTree.root;
        }
        else
        {
            root.left = null;
        }
        if(rightTree != null)
        {
            root.right = rightTree.root;
        }
        else
        {
            root.right = null;
        }
    }
    
    public BinaryTree<E> getLeftSubtree()
    {
        if(root != null && root.left != null)
        {
            return new BinaryTree<E>(root.left);
        }
        else
        {
            return null;
        }
    }
    
    public BinaryTree<E> getRightSubtree()
    {
        if(root != null && root.left != null)
        {
            return new BinaryTree<E>(root.right);
        }
        else
        {
            return null;
        }
    }
    
    public E getData()
    {
        return root.data;
    }
    
    public boolean isLeaf()
    {
        return (root.left == null && root.right == null);
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        toString(root, 1, sb);
        return sb.toString();
    }
    
    public void toString(Node<E> node, int depth, StringBuilder sb)
    {
        for(int i = 1;i < depth;i++)
        {
            sb.append("   ");
        }
        if(node == null)
        {
            sb.append("null\n");
        }
        else
        {
            sb.append(node.toString());
            sb.append("\n");
            toString(node.left, depth + 1, sb);
            toString(node.right, depth + 1, sb);
        }
    }
   
    public static BinaryTree<String> readBinaryTree(Scanner scan)
    {
        String data = scan.next();
        if(data.equals("null"))
        {
            return null;
        }
        else
        {
            BinaryTree<String> leftTree = readBinaryTree(scan);
            BinaryTree<String> rightTree = readBinaryTree(scan);
            return new BinaryTree<String>(data,leftTree,rightTree);
        }
    }
    
    public void preOrderTraverse(Node<E> node)
    {
        if(node == null)
        {
            return;
        }
        System.out.printf("%s ", node.data);
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }
    
    public void postOrderTraverse(Node<E> node)
    {
        if(node == null)
        {
            return;
        }
        postOrderTraverse(node.right);
        postOrderTraverse(node.left);
        System.out.printf("%s ",node.data);
    }
    
    public void inOrderTraverse(Node<E> node)
    {
        if(node == null)
        {
            return;
        }
        inOrderTraverse(node.left);
        System.out.printf("%s ",node.data);
        inOrderTraverse(node.right);
    }
}
