package com.Tree;

public class TreeNode<T> {
    private T data; //数据域
    private TreeNode<T> lNode;
    private TreeNode<T> rNode;

    TreeNode(T t){
        this.data = t;
    }

    TreeNode(T data, TreeNode<T> lNode, TreeNode<T> rNode){
        this.data = data;
        this.lNode = lNode;
        this.rNode = rNode;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData(){
        return this.data;
    }

    public void setlNode(TreeNode<T> lNode) {
        this.lNode = lNode;
    }

    public TreeNode<T> getlNode(){
        return  this.lNode;
    }

    public void setrNode(TreeNode<T> rNode) {
        this.rNode = rNode;
    }

    public TreeNode<T> getrNode(){
        return rNode;
    }

}
