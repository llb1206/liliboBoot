package com.DataStru.gragh;

import java.util.LinkedList;

/**
 * 图的深度优先搜索 与广度优先搜索
 *
 * @author 15000
 */
public class GraphBfsDfs {
    static int[][] graph = new int[][]{
            {0, 0, 1, 1, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {1, 1, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0}};
    static int[] help = new int[graph.length];

    /**
     * dfs
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
     * Bfs
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

    public static void main(String[] args) {
        //Dfs(0, graph);
        //Bfs(graph);
    }
}