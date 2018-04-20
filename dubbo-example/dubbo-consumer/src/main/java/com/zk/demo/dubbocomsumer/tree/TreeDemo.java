package com.zk.demo.dubbocomsumer.tree;

/**
 * 测试类
 */
public class TreeDemo {
    public static void main(String[] args) {
//        BinaryTree rootNode = new BinaryTree("根节点");
//        System.out.println("node data :" + rootNode.getData());
//        System.out.println("node left data : " + (rootNode.left != null ? rootNode.left.getData() : "null"));
//        System.out.println("node right data : " + (rootNode.right != null ? rootNode.right.getData() : "null"));
        BinaryTree a = createSimpleTree();
        BinaryTree.preSearch(a);
        BinaryTree.inSearch(a);
        BinaryTree.postSearch(a);
        System.out.println("---------node-节点遍历结束--------");
        BinaryTree.bfsSearch(a);

    }

    static BinaryTree createSimpleTree() {
        BinaryTree a = new BinaryTree("a");
        BinaryTree.addLeftNode(a, "b");
        BinaryTree.addRightNode(a, "c");

        BinaryTree b = a.getLeft();
        BinaryTree.addRightNode(b, "d");

        BinaryTree c = a.getRight();
        BinaryTree.addLeftNode(c, "e");
        BinaryTree.addRightNode(c, "f");

        BinaryTree d = b.getRight();
        BinaryTree e = c.getLeft();
        BinaryTree f = c.getRight();

        System.out.println("【node_a data】:" + a.getData());
        System.out.println("【node_b data】:" + b.getData());
        System.out.println("【node_c data】:" + c.getData());
        System.out.println("【node_d data】:" + d.getData());
        System.out.println("【node_e data】:" + e.getData());
        System.out.println("【node_f data】:" + f.getData());
        return a;
    }
}
