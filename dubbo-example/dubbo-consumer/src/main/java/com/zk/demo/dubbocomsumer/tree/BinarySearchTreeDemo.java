package com.zk.demo.dubbocomsumer.tree;

public class BinarySearchTreeDemo {
    public static void main(String[] args) {
        BinarySearchTree rootNode = createTree();
//        Boolean bol = rootNode.findNode(rootNode, 10);
//        System.out.println(bol ? "yes" : "no");
        rootNode.removeNode(rootNode, 76, null);
        rootNode.inSearch(rootNode);

    }

    public static BinarySearchTree createTree() {
        BinarySearchTree rootNode = new BinarySearchTree(50);
        rootNode.addNode(rootNode, 21);
        rootNode.addNode(rootNode, 76);
        rootNode.addNode(rootNode, 4);
        rootNode.addNode(rootNode, 32);
        rootNode.addNode(rootNode, 64);
        rootNode.addNode(rootNode, 100);
        rootNode.addNode(rootNode, 52);
        return rootNode;
    }
}
