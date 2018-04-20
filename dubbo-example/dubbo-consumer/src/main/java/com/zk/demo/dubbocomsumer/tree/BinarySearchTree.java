package com.zk.demo.dubbocomsumer.tree;

/**
 * 二叉搜索树
 */
public class BinarySearchTree {
    public BinarySearchTree left;
    public BinarySearchTree right;
    private Integer data;

    public BinarySearchTree() {
    }

    public BinarySearchTree(BinarySearchTree left, BinarySearchTree right, Integer data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public BinarySearchTree(Integer data) {
        this(null, null, data);
    }

    /**
     * 插入树
     *
     * @param node  被插入节点
     * @param value 值
     */
    public void addNode(BinarySearchTree node, Integer value) {
        if (node != null) {
            if (node.getData() < value) {
                if (node.right != null) {
                    node.right.addNode(node.getRight(), value);
                } else {
                    node.right = new BinarySearchTree(value);
                }
            } else {
                if (node.left != null) {
                    node.left.addNode(node.getLeft(), value);
                } else {
                    node.left = new BinarySearchTree(value);
                }
            }
        }
    }

    /**
     * 查找节点是否存在
     *
     * @param node  节点
     * @param value 值
     * @return
     */
    public boolean findNode(BinarySearchTree node, Integer value) {
        if (node != null) {
            if (node.getData().equals(value)) {
                return true;
            } else {
                if (value > node.getData() && node.right != null) {
                    return node.right.findNode(node.right, value);
                } else if (node.left != null) {
                    return node.left.findNode(node.left, value);
                }
            }
        }
        return false;
    }

    /**
     * 深度优化搜索
     * 中序
     *
     * @param node 节点
     */
    public void inSearch(BinarySearchTree node) {
        if (node != null) {
            if (node.left != null) {
                node.left.inSearch(node.getLeft());
            }
            System.out.println(node.getData() + "--中序");
            if (node.right != null) {
                node.right.inSearch(node.getRight());
            }
        }
    }

    /**
     * 删除节点
     *
     * @param node   节点
     * @param value  被删除节点的值
     * @param parent 父节点
     */
    public Boolean removeNode(BinarySearchTree node, Integer value, BinarySearchTree parent) {
        if (node != null) {
            if (value < node.getData()) {
                /**当值小于该节点值 去左节点搜索*/
                if (node.left != null) {
                    removeNode(node.left, value, node);
                } else {
                    return false;
                }
            } else if (value > node.getData()) {
                /**当值大于该节点值 去右节点搜索*/
                if (node.right != null) {
                    removeNode(node.right, value, node);
                }
            } else {
                /**值相等时，执行删除逻辑 分三种情况*/
                //1.该节点没有叶子节点
                if (node.left == null && node.right == null && node == parent.left) {
                    parent.left = null;
                    clearNode(node);
                } else if (node.left == null && node.right == null && node == parent.right) {
                    parent.right = null;
                    clearNode(node);
                    //2.该节点有左节点没有右节点
                } else if (node.left != null && node.right == null && node == parent.left) {
                    parent.left = node.left;
                    clearNode(node);
                } else if (node.left != null && node.right == null && node == parent.right) {
                    parent.right = node.left;
                    clearNode(node);
                    //3.该节点有右节点 没有左节点
                } else if (node.right != null && node.left == null && node == parent.left) {
                    parent.left = node.right;
                    clearNode(node);
                } else if (node.right != null && node.left == null && node == parent.right) {
                    parent.right = node.right;
                    clearNode(node);
                } else {
                    //这里还是不慎明白
                    node.data = findMinValue(node.right);
                    removeNode(node.right, node.right.getData(), node);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 清除指定节点
     *
     * @param node
     */
    public void clearNode(BinarySearchTree node) {
        if (node != null) {
            node.left = null;
            node.right = null;
            node.data = null;
        }
    }

    /**
     * 查找最小节点值
     *
     * @param node
     * @return
     */
    public Integer findMinValue(BinarySearchTree node) {
        if (node != null) {
            if (node.left != null) {
                findMinValue(node.left);
            } else {
                return node.getData();
            }
        }
        return null;
    }


    public BinarySearchTree getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTree left) {
        this.left = left;
    }

    public BinarySearchTree getRight() {
        return right;
    }

    public void setRight(BinarySearchTree right) {
        this.right = right;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }
}
