package com.zk.demo.dubbocomsumer.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 简单二叉树
 */
public class BinaryTree {
    /**
     * 左节点
     */
    public BinaryTree left;

    /**
     * 右节点
     */
    public BinaryTree right;

    /**
     * 当前节点内容
     */
    private String data;

    public BinaryTree() {
    }

    public BinaryTree(BinaryTree left, BinaryTree right, String data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public BinaryTree(String data) {
        this(null, null, data);
    }


    /**
     * 插入左节点
     *
     * @param node  被插入节点
     * @param value 值
     */
    public static void addLeftNode(BinaryTree node, String value) {
        if (node == null) {
            return;
        }
        if (node.left == null) {
            node.setLeft(new BinaryTree(value));
        } else {
            BinaryTree newNode = new BinaryTree(value);
            newNode.setLeft(node.getLeft());
            node.setLeft(newNode);
        }
    }

    /**
     * 插入右节点
     *
     * @param node  被插入节点
     * @param value 值
     */
    public static void addRightNode(BinaryTree node, String value) {
        if (node == null) {
            return;
        }
        if (node.right == null) {
            node.right = new BinaryTree(value);
        } else {
            BinaryTree newNode = new BinaryTree(value);
            newNode.right = node.right;
            node.right = newNode;
        }
    }

    /**
     * 深度优先搜素
     * 先序遍历
     *
     * @param node
     */
    public static void preSearch(BinaryTree node) {
        if (node != null) {
            System.out.println(node.getData() + "--前序遍历");
            if (node.getLeft() != null) {
                preSearch(node.getLeft());
            }
            if (node.getRight() != null) {
                preSearch(node.getRight());
            }
        }
    }

    /**
     * 深度优先搜素
     * 中序遍历
     *
     * @param node
     */
    public static void inSearch(BinaryTree node) {
        if (node != null) {
            if (node.getLeft() != null) {
                BinaryTree.inSearch(node.getLeft());
            }

            System.out.println(node.getData() + "--中序遍历");

            if (node.getRight() != null) {
                BinaryTree.inSearch(node.getRight());
            }
        }
    }

    /**
     * 深度优先搜素
     * 后序遍历
     *
     * @param node
     */
    public static void postSearch(BinaryTree node) {
        if (node != null) {
            if (node.getLeft() != null) {
                BinaryTree.postSearch(node.getLeft());
            }

            if (node.getRight() != null) {
                BinaryTree.postSearch(node.getRight());
            }

            System.out.println(node.getData() + "--后序遍历");
        }
    }

    /**
     * 广度优先搜索
     *
     * @param node
     */
    public static void bfsSearch(BinaryTree node) {
        if (node != null) {
            /**先进先出*/
            Queue<BinaryTree> queue = new ArrayDeque<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                BinaryTree currentNode = queue.poll();
                System.out.println(currentNode.getData() + "--广度优先搜索");

                if (currentNode.getLeft() != null) {
                    queue.add(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    queue.add(currentNode.getRight());
                }
            }
        }
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }
}
