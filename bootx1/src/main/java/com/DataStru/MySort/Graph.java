package com.DataStru.MySort;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author 15000
 */
public class Graph {                   //A, B, C,D, E, F
    static int[][] graph = new int[][]{
            {0, 0, 1, 1, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {1, 1, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0}
    };
    static int[] help = new int[graph.length];

    /**
     * һͷ�����ͣ���������һͷ������
     * DFS(������ȱ���)ͬ������������ͼ A->C->B->D->E->F �� 0->2->1->3->4->5
     * i != node ��ʾ�������Լ������Լ������Խ���-������0
     * x:�ڼ��Ŷ���
     */
    public static void Dfs(int nodeNum, int[][] graph) {
        help[nodeNum] = 1;
        System.out.println(nodeNum);
        for (int i = 0; i < graph.length; ++i) {
            if (graph[nodeNum][i] == 1 && help[i] == 0 && i != nodeNum) {
                Dfs(i, graph);
            }
        }
    }

    /**
     * //BFS(������ȱ���)ͬ������������ͼ A->C->D->B->E->F ��0->2->3->1->4->5
     * ����˼·,���ȱ�����һ��Ԫ��,�ٰ����Ԫ������������У��͸����Ĳ�α������
     * ����Ĭ��Ԫ�ر�Ŷ��Ǵ�01234...��ʼ��
     *
     * @param graph
     */
    public static void Bfs(int[][] graph) {
        LinkedList queueK = new LinkedList();
        queueK.offer(0);
        help[0] = 1;
        System.out.println(0);
        while (!queueK.isEmpty()) {
            int n = (int) queueK.poll();
            for (int j = 0; j < graph.length; ++j) {
                if (graph[n][j] == 1 && help[j] == 0) {
                    help[n] = 1;
                    queueK.offer(j);
                    System.out.println(j);
                }
            }
        }
    }

    //������Ȩͼ��·������
    public static void BfsA(int[][] graph) {
        LinkedList queueK = new LinkedList();
        Set num = new HashSet();
        queueK.offer(0);
        help[0] = 1;
        System.out.println(0);
        while (!queueK.isEmpty()) {
            int n = (int) queueK.poll();
            for (int j = 0; j < graph.length; ++j) {
                if (graph[n][j] == 1 && help[j] == 0) {
                    help[n] = 1;
                    num.add(n);
                    queueK.offer(j);
                    System.out.println(j);
                    if (n == 2) break;
                }
            }
            if (n == 2) break;
        }
        System.out.println("·��������" + num);
    }

    public static void main(String[] args) {
        //Dfs(0, graph);
        //Bfs(graph);
        BfsA(graph);
    }
}