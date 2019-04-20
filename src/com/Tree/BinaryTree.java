package com.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的链式存储结构
 * @param <T>
 */
public class BinaryTree<T> {
    private TreeNode<T> root; //定义根节点
    private List<TreeNode> nodes = null; //二叉树节点的链式结构

    public BinaryTree(){

    }

    public BinaryTree(TreeNode<T> root){
        this.root = root;
    }

    //把一个数组转换为一颗完全二叉树
    public TreeNode<T> buildTree(T[] array){
        nodes = new LinkedList<>();
        //将数组中的元素依次转换为TreeNode节点，存放于链表中
        for (int i = 0; i < array.length; i++){
            nodes.add(new TreeNode(array[i]));
        }
        //对前（arraylength/2 - 1）个父节点，按照父节点与孩子节点的数字关系建立完全二叉树
        //对完全二叉树，按从上到下，从左到右的顺序依次编号0.1.2.3....n，则i》0 的节点，其左孩子为（2*i+1）右孩子为（2*i+2）
        for (int j = 0; j < (array.length/2 - 1); j++){
            //左海子
            nodes.get(j).setlNode(nodes.get(2*j+1));
            //右孩子
            nodes.get(j).setrNode(nodes.get(2*j+2));
        }
        //z最后一个父节点，可能没有右孩子，所以单独处理
        int index = array.length/2 - 1;
        //左孩子
        nodes.get(index).setrNode(nodes.get(2*index+1));
        //右孩子：如果数组长度为奇数才有右孩子
        if (array.length % 2 == 1){
            nodes.get(index).setrNode(nodes.get(2*index+2));
        }
        root = nodes.get(0);
        return root;
    }

    //得到树的高度
    public int height(TreeNode<T> node){
        if (node == null){
            return 0;
        }else {
            int i = height(node.getlNode());
            int j = height(node.getrNode());
            return (i < j)?(j + 1):(i + 1);
        }
    }

    //得到节点
    public int size(TreeNode<T> node){
        if (node == null){
            return 0;
        }else {
            return 1 + size(node.getlNode()) + size(node.getrNode());
        }
    }

    //递归实现先序遍历(先根后左再右)
    public void preOrder(TreeNode<T> node){
        if (node == null){
            return ;
        }else {
            System.out.print(node.getData() + " ");
            preOrder(node.getlNode());
            preOrder(node.getrNode());
        }
    }
    //非递归实现先序遍历
    public void prOder(TreeNode<T> node){
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> treeNode = node; //treeTree作为遍历指针
        while (treeNode != null || !stack.empty()){ //当treeNode非空或栈非空时循环
            if (treeNode != null){
            stack.push(treeNode); //根指针进栈
            System.out.print(stack.peek().getData() + " ");//访问根节点
            treeNode = treeNode.getlNode();//先往左走
        }else {  //往右子树走
                treeNode = stack.pop();
                treeNode = treeNode.getrNode();
            }
        }
    }

    //递归实现中序遍历(先访问左子树，在访问根节点，最后访问右子树
    public void midOrder(TreeNode<T> node){
        if (node != null){
            midOrder(node.getlNode());
            System.out.print(node.getData() + " ");
            midOrder(node.getrNode());
        }
    }

    //非递归实现中序遍历
    public void miOrder(TreeNode<T> node){
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> treeNode = node;
        while (treeNode != null || !stack.empty()){
            if (treeNode != null){
                stack.push(treeNode);
                treeNode = treeNode.getlNode();
            }else {
                treeNode = stack.pop();//根指针退栈，访问根节点
                System.out.print(treeNode.getData() + " ");
                treeNode = treeNode.getrNode();
            }
        }
    }

    //递归实现后序遍历(先左子树后右子树最后根节点
    public void postOrder(TreeNode<T> node){
        if (node != null){
            postOrder(node.getlNode());
            postOrder(node.getrNode());
            System.out.print(node.getData() + " ");
        }
    }

    //非递归实现后序遍历
    public void pstOrder(TreeNode<T> node){
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> treeNode = node; //treeNode作为遍历指针
        TreeNode<T> tmp = null; //表示最近一次访问的节点
        while (treeNode != null || !stack.empty()){
            while (treeNode != null){ //左走
                stack.push(treeNode);
                treeNode = treeNode.getlNode();
            }
            treeNode = stack.peek();
            if (treeNode.getrNode() == null || treeNode.getrNode() == tmp){ //右子树为空或者右子树已被访问，该节点出栈
                treeNode = stack.pop();
                System.out.print(treeNode.getData() + " ");
                tmp = treeNode; //将该节点赋值给最近一个访问节点
                treeNode = null; //此处很重要，将刚出栈的节点设置为空，对应while循环的条件之一，否则陷入死循环
            }else {
                treeNode = treeNode.getrNode();//遍历右子树
            }
        }
    }

    //层次遍历
    public void levelOrder(TreeNode<T> node){
        Queue<TreeNode<T>> nodes = new LinkedList<>();
        TreeNode<T> node1 = null;
        nodes.add(node); //将根节点入队
        while (!nodes.isEmpty()){ //对内不空循环
            node1 = nodes.peek();
            System.out.print(node1.getData() + " ");
            nodes.poll(); //对头元素出队
            if (node1.getlNode() != null){ //左子树不空，则左子树入队
                nodes.add(node1.getlNode());
            }
            if (node1.getrNode() != null){ //右子树不为空，则右子树入队
                nodes.add(node1.getrNode());
            }
        }
    }

    public static void main(String[] args){
        //将一个数组转换为一颗完全二叉树
        Object[] array = {1,2,3,4,5,6,7,8};
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.buildTree(array);
        System.out.println("树的高度");
        System.out.println(bt.height(root));
        System.out.println("节点个数");
        System.out.println(bt.size(root));
        System.out.println("\n"+"先序遍历: ");
        bt.preOrder(root);
        System.out.println("\n"+"非递归先序遍历：");
        bt.prOder(root);
        System.out.println();
        System.out.println("\n"+"中序遍历: ");
        bt.midOrder(root);
        System.out.println("\n"+"非递归中序遍历：");
        bt.miOrder(root);
        System.out.println();
        System.out.println("\n"+"后序遍历: ");
        bt.postOrder(root); System.out.println("\n"+"非递归后序遍历：");
        bt.pstOrder(root);
        System.out.println();

        System.out.println("\n"+"层次遍历：");
        bt.levelOrder(root);

        //手工构建一颗二叉树
        TreeNode nodeA = new TreeNode("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");
        TreeNode nodeD = new TreeNode("D");
        TreeNode nodeE = new TreeNode("E");
        TreeNode nodeF = new TreeNode("F");
        TreeNode nodeG = new TreeNode("G");
        TreeNode nodeH = new TreeNode("H");
        TreeNode nodeI = new TreeNode("I");
        nodeA.setlNode(nodeB);
        nodeA.setrNode(nodeD);
        nodeB.setrNode(nodeC);
        nodeD.setlNode(nodeE);
        nodeD.setrNode(nodeF);
        nodeF.setlNode(nodeG);
        nodeF.setrNode(nodeI);
        nodeG.setrNode(nodeH);


        System.out.println("\n\n"+"*****************");
        System.out.print("树的高度：");
        System.out.println(bt.height(nodeA));
        System.out.print("节点的个数：");
        System.out.println(bt.size(nodeA));
        System.out.println("先序遍历：");
        bt.preOrder(nodeA);
        System.out.println();

        System.out.println("中序遍历：");
        bt.midOrder(nodeA);
        System.out.println();

        System.out.println("后序遍历：");
        bt.postOrder(nodeA);
        System.out.println();

        System.out.println("层次遍历：");
        bt.levelOrder(nodeA);
    }
}



