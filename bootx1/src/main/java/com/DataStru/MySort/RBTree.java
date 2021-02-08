package com.DataStru.MySort;

public class RBTree<T extends Comparable<T>> {

    private RBTNode<T> mRoot;    // �����

    private static final boolean RED = false;
    private static final boolean BLACK = true;

    public static class RBTNode<T extends Comparable<T>> {
        boolean color;        // ��ɫ
        T key;                // �ؼ���(��ֵ)
        RBTNode<T> left;    // ����
        RBTNode<T> right;    // �Һ���
        RBTNode<T> parent;    // �����

        public RBTNode() {
        }

        public RBTNode(T key, boolean color, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right) {
            this.key = key;
            this.color = color;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

    }

    public RBTNode<T> getmRoot() {
        return mRoot;
    }

    public void setmRoot(RBTNode<T> mRoot) {
        this.mRoot = mRoot;
    }

    public static boolean isRED() {
        return RED;
    }

    public static boolean isBLACK() {
        return BLACK;
    }

    /*
     * �Ժ�����Ľڵ�(x)��������ת
     *
     * ����ʾ��ͼ(�Խڵ�x��������)��
     *      px                              px
     *     /                               /
     *    x                               y
     *   /  \      --(����)-.           / \                #
     *  lx   y                          x  ry
     *     /   \                       /  \
     *    ly   ry                     lx  ly
     *
     *
     */
    private void leftRotate(RBTNode<T> x) {
        // ����x���Һ���Ϊy
        RBTNode<T> y = x.right;

        // �� ��y�����ӡ� ��Ϊ ��x���Һ��ӡ���
        // ���y�����ӷǿգ��� ��x�� ��Ϊ ��y�����ӵĸ��ס�
        x.right = y.left;
        if (y.left != null)
            y.left.parent = x;

        // �� ��x�ĸ��ס� ��Ϊ ��y�ĸ��ס�
        y.parent = x.parent;

        if (x.parent == null) {
            this.mRoot = y;            // ��� ��x�ĸ��ס� �ǿսڵ㣬��y��Ϊ���ڵ�
        } else {
            if (x.parent.left == x) {
                x.parent.left = y;    // ��� x�������ڵ�����ӣ���y��Ϊ��x�ĸ��ڵ�����ӡ�
            } else {
                x.parent.right = y;    // ��� x�������ڵ�����ӣ���y��Ϊ��x�ĸ��ڵ�����ӡ�
            }
        }

        // �� ��x�� ��Ϊ ��y�����ӡ�
        y.left = x;
        // �� ��x�ĸ��ڵ㡱 ��Ϊ ��y��
        x.parent = y;
    }

    public static void main(String[] args) {
        RBTNode b = new RBTNode();

    }
}