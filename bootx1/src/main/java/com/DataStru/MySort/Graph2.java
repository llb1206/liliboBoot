package com.DataStru.MySort;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author 15000
 */
public class Graph2 {
    static int[][] graph = new int[][]{
            {0, 0, 1, 1, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {1, 1, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0}};
    static int[] help = new int[graph.length];

    /**
     * �����������dfs
     *
     * @param num
     * @param graph
     */
    private static void Dfs(int num, int[][] graph) {
        help[num] = 1;
        System.out.println(num);
        for (int i = 0; i < graph.length; i++) {
            if (graph[num][i] == 1 && help[i] == 0) {
                Dfs(i, graph);
            }
        }
    }

    /**
     * �����������Bfs
     *
     * @param graph
     */
    private static void Bfs(int[][] graph) {
        LinkedList queue = new LinkedList();
        queue.offer(0);
        help[0] = 1;
        System.out.println(0);
        while (!queue.isEmpty()) {
            int num = (int) queue.poll();
            for (int i = 0; i < graph.length; i++) {
                if (graph[num][i] == 1 && help[i] == 0) {
                    System.out.println(i);
                    queue.offer(i);
                    help[i] = 1;
                }
            }
        }
    }

    /**
     * ���������������·��������ֻ������Ȩͼ�ұ�������Ȩͼ��ֻ���ھ������濴���Բ���̫��Ū�ģ��м���������
     *
     * @param graph
     */
    private static void BfsLenGth(int[][] graph) {
        LinkedList queue = new LinkedList();
        Set set = new HashSet();//��¼����
        queue.offer(0);
        help[0] = 1;
        System.out.println(0);
        while (!queue.isEmpty()) {
            int num = (int) queue.poll();
            for (int i = 0; i < graph.length; i++) {
                if (graph[num][i] == 1 && help[i] == 0) {
                    set.add(num);
                    System.out.println(i);
                    help[i] = 1;
                    queue.offer(i);
                    if (num == 3) break;
                }
            }
            if (num == 3) break;
        }
        System.out.println("��" + set.size() + "��");
    }

    public static void main(String[] args) {
        //Dfs(0, graph);
        //Bfs(graph);
        BfsLenGth(graph);
    }
}