package com.DataStru.gragh;

import java.util.Arrays;

/**
 * 普里姆算法（Prim算法）示例
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        //定义图的各个顶点的值
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //根据图的各个顶点的值，获取图对应的顶点个数
        int vex = data.length;
        //使用二维数组表示邻接矩阵的关系 ，10000:表示两个点不连通
        int M = 10000;//设置距离最大值表示此路不通
        int[][] weight = new int[][]{
                {M, 5, 7, M, M, M, 2},
                {5, M, M, 9, M, M, 3},
                {7, M, M, M, 8, M, M},
                {M, 9, M, M, M, 4, M},
                {M, M, 8, M, M, 5, 4},
                {M, M, M, 4, 5, M, 6},
                {2, 3, M, M, 4, 6, M}
        };
        //创建Graph对象
        Graph graph = new Graph(vex);
        //创建MinTree对象
        MinTree minTree = new MinTree();
        //创建图的邻接矩阵
        minTree.createGraph(graph, vex, data, weight);
        //显示图的邻接矩阵
        System.out.println("图的邻接矩阵----------------------");
        minTree.showGraph(graph);
        //测试普里姆算法
        System.out.println("普里姆算法==============");
        minTree.prim(graph, 0);
    }
}

class MinTree {
    /**
     * @Description: 创建图的邻接矩阵
     * @Param: graph 图对象
     * verxs 图对应的顶点个数
     * data  图的各个顶点的值
     * weight 图的邻接矩阵
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

    //显示图的邻接矩阵
    public void showGraph(Graph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    public void prim(Graph graph, int v) {
        //visited[] 标记结点(顶点)是否被访问过,visited[] 默认元素的值都是0, 表示没有访问过
        int visited[] = new int[graph.verxs];
        //把当前这个结点标记为已访问
        visited[v] = 1;
        //h1 和 h2 记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000; //将 minWeight 初始成一个大数，后面在遍历过程中，会被替换
        int sumMinWeight = 0;//所有对应边的最小权值的总和
        for (int k = 1; k < graph.verxs; k++) {//因为有 graph.verxs顶点，普利姆算法结束后，有 graph.verxs-1边

            //这个是确定每一次生成的子图 ，和哪个结点的距离最近
            for (int i = 0; i < graph.verxs; i++) {// i结点表示被访问过的结点
                for (int j = 0; j < graph.verxs; j++) {//j结点表示还没有访问过的结点
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        //替换minWeight(寻找已经访问过的结点和未访问过的结点间的权值最小的边)
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //退出双重for循环后就找到一条边是最小
            System.out.println("对应的边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值:" + minWeight);
            sumMinWeight += minWeight;
            //将当前这个结点标记为已经访问
            visited[h2] = 1;
            //minWeight 重新设置为最大值 10000
            minWeight = 10000;
        }
        System.out.println("所有对应边的最小权值的总和=" + sumMinWeight);
    }

}

class Graph {
    int verxs;//图的节点个数
    char[] data;//存放图节点的数据
    int[][] weight; //存放边，表示邻接矩阵

    //构造函数
    public Graph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}

