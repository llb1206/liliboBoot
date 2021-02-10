package com.DataStru.gragh;

import java.util.Arrays;

/**
 * ����ķ�㷨��Prim�㷨��ʾ��
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        //����ͼ�ĸ��������ֵ
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //����ͼ�ĸ��������ֵ����ȡͼ��Ӧ�Ķ������
        int vex = data.length;
        //ʹ�ö�ά�����ʾ�ڽӾ���Ĺ�ϵ ��10000:��ʾ�����㲻��ͨ
        int M = 10000;//���þ������ֵ��ʾ��·��ͨ
        int[][] weight = new int[][]{
                {M, 5, 7, M, M, M, 2},
                {5, M, M, 9, M, M, 3},
                {7, M, M, M, 8, M, M},
                {M, 9, M, M, M, 4, M},
                {M, M, 8, M, M, 5, 4},
                {M, M, M, 4, 5, M, 6},
                {2, 3, M, M, 4, 6, M}
        };
        //����Graph����
        Graph graph = new Graph(vex);
        //����MinTree����
        MinTree minTree = new MinTree();
        //����ͼ���ڽӾ���
        minTree.createGraph(graph, vex, data, weight);
        //��ʾͼ���ڽӾ���
        System.out.println("ͼ���ڽӾ���----------------------");
        minTree.showGraph(graph);
        //��������ķ�㷨
        System.out.println("����ķ�㷨==============");
        minTree.prim(graph, 0);
    }
}

class MinTree {
    /**
     * @Description: ����ͼ���ڽӾ���
     * @Param: graph ͼ����
     * verxs ͼ��Ӧ�Ķ������
     * data  ͼ�ĸ��������ֵ
     * weight ͼ���ڽӾ���
     * @Author: xz
     * @Date: 2020/11/13 21:56
     */
    public void createGraph(Graph graph, int verxs, char[] data, int[][] weight) {
        for (int i = 0; i < verxs; i++) {
            graph.data[i] = data[i];
            for (int j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    //��ʾͼ���ڽӾ���
    public void showGraph(Graph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    public void prim(Graph graph, int v) {
        //visited[] ��ǽ��(����)�Ƿ񱻷��ʹ�,visited[] Ĭ��Ԫ�ص�ֵ����0, ��ʾû�з��ʹ�
        int visited[] = new int[graph.verxs];
        //�ѵ�ǰ��������Ϊ�ѷ���
        visited[v] = 1;
        //h1 �� h2 ��¼����������±�
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000; //�� minWeight ��ʼ��һ�������������ڱ��������У��ᱻ�滻
        int sumMinWeight = 0;//���ж�Ӧ�ߵ���СȨֵ���ܺ�
        for (int k = 1; k < graph.verxs; k++) {//��Ϊ�� graph.verxs���㣬����ķ�㷨�������� graph.verxs-1��

            //�����ȷ��ÿһ�����ɵ���ͼ �����ĸ����ľ������
            for (int i = 0; i < graph.verxs; i++) {// i����ʾ�����ʹ��Ľ��
                for (int j = 0; j < graph.verxs; j++) {//j����ʾ��û�з��ʹ��Ľ��
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        //�滻minWeight(Ѱ���Ѿ����ʹ��Ľ���δ���ʹ��Ľ����Ȩֵ��С�ı�)
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //�˳�˫��forѭ������ҵ�һ��������С
            System.out.println("��Ӧ�ı�<" + graph.data[h1] + "," + graph.data[h2] + "> Ȩֵ:" + minWeight);
            sumMinWeight += minWeight;
            //����ǰ��������Ϊ�Ѿ�����
            visited[h2] = 1;
            //minWeight ��������Ϊ���ֵ 10000
            minWeight = 10000;
        }
        System.out.println("���ж�Ӧ�ߵ���СȨֵ���ܺ�=" + sumMinWeight);
    }

}

class Graph {
    int verxs;//ͼ�Ľڵ����
    char[] data;//���ͼ�ڵ������
    int[][] weight; //��űߣ���ʾ�ڽӾ���

    //���캯��
    public Graph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}

