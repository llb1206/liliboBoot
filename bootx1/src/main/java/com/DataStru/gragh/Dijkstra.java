package com.DataStru.gragh;

public class Dijkstra {
    /**
     * 迪杰斯特拉算法
     *
     * @param weight
     * @param start
     * @return
     */
    private static int[] dijkstra(int[][] weight, int start) {
        int n = weight.length;//确定有几个顶点
        int[] shortPath = new int[n];//记录从start到每个顶点的最短路径
        String[] path = new String[n];//记录从start到每个顶点最短路径经过的点
        int[] visited = new int[n];//记录每个点是否已获得最短路径
        for (int i = 0; i < n; i++) {
            path[i] = start + "--->" + i;
        }
        shortPath[start] = 0;
        visited[start] = 1;
        for (int count = 1; count < n; count++) {
            int k = -1;//找出最短路径的点
            int dmin = Integer.MAX_VALUE;//记录最短路径
            for (int i = 0; i < n; i++) {
                if (visited[i] != 1 && weight[start][i] < dmin) {
                    k = i;
                    dmin = weight[start][i];
                }
            }
            System.out.println("k=" + k);
            shortPath[k] = dmin;
            visited[k] = 1;
            for (int i = 0; i < n; i++) {
                if (visited[i] != 1 && weight[start][k] + weight[k][i] < weight[start][i]) {
                    path[i] = path[k] + "--->" + i;
                    weight[start][i] = weight[start][k] + weight[k][i];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(start + "到" + i + "的最短路径为：" + path[i]);
        }
        return shortPath;
    }

    //初始化
//stark--->k
//stark--->k--->i的距离  < stark--->i的距离
//重复23步骤
    static int M = 10000;//设置距离最大值表示此路不通

    public static void main(String[] args) {
        int[][] weight = {
                {0, 34, 43, 58, M, 76, 243},
                {342, 0, M, 54, M, 32, 4},
                {2, 4, 0, M, 67, 8, 32},
                {6, 98, 34, 0, M, 5, 55},
                {34, 45, 66, 77, 0, 423, M},
                {2, 4, 340, M, 67, 0, 32},
                {34, 45, 66, 77, 566, M, 0}
        };
        int start = 0;
        int[] shortPath = dijkstra(weight, start);

        for (int i = 0; i < shortPath.length; i++) {
            System.out.println(start + "到" + i + "的最短距离为：" + shortPath[i]);
        }
    }
}