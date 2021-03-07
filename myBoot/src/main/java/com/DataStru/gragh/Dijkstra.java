package com.DataStru.gragh;

/**
 * ���·��֮�Ͻ�˹����
 */
public class Dijkstra {

    private static int[] dijkstra(int[][] weight, int start) {
        int n = weight.length;//ȷ���м�������
        int[] shortPath = new int[n];//��¼��start��ÿ����������·��
        String[] path = new String[n];//��¼��start��ÿ���������·�������ĵ�
        int[] visited = new int[n];//��¼ÿ�����Ƿ��ѻ�����·��
        for (int i = 0; i < n; i++) {
            path[i] = start + "--->" + i;
        }
        shortPath[start] = 0;
        visited[start] = 1;
        for (int count = 1; count < n; count++) {
            int k = -1;//�ҳ����·���ĵ�
            int dmin = Integer.MAX_VALUE;//��¼���·��
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
            System.out.println(start + "��" + i + "�����·��Ϊ��" + path[i]);
        }
        return shortPath;
    }

    /**
     * ��ʼ��
     * stark--->k
     * stark--->k--->i�ľ���  < stark--->i�ľ���
     * �ظ�23����
     */

    static int M = 10000;//���þ������ֵ��ʾ��·��ͨ

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
            System.out.println(start + "��" + i + "����̾���Ϊ��" + shortPath[i]);
        }
    }
}