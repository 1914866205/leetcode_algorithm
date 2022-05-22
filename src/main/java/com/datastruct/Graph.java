package com.datastruct;

import sun.security.provider.certpath.Vertex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Graph
 * @Descriotion https://blog.csdn.net/qq_42977003/article/details/122028535
 * @Author nitaotao
 * @Date 2022/5/21 12:51
 * @Version 1.0
 **/
public class Graph<T> {
    //顶点的数量
    private int vCount;
    //边的数量
    private int edgeCount;

    //存储顶点的集合，以下标代替顶点
    private ArrayList<T> vertex;
    //使用二维数组表示邻接矩阵
    private int[][] matrix;
    //辅助数组，用来标记顶点是否被遍历，下标代表顶点
    boolean[] mark;

    //初始化图，n是顶点的数量
    Graph(int n) {
        //顶点集合的大小是顶点的个数
        vertex = new ArrayList<>(n);
        //顶点的个数是二维数组的长度
        matrix = new int[n][n];
        //顶点数量、边数量初始化为0
        vCount = 0;
        edgeCount = 0;
        //默认值为false
        mark = new boolean[n];
    }

    //插入结点
    public void addVertex(T t) {
        vertex.add(t);
        vCount++;
    }

    /**
     * 添加边
     *
     * @param v1     边起点
     * @param v2     边终点
     * @param weight 权重
     */
    public void addEdge(int v1, int v2, int weight) {
        matrix[v1][v2] = weight;
        matrix[v2][v1] = weight;
        edgeCount++;
    }

    public int getvCount() {
        return vCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    //显示临街矩阵表示的图
    public void print() {
        for (int[] o : matrix) {
            for (int i : o) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    //得到第一个邻接结点的下标
    public int getFirst(int v) {
        for (int i = 0; i < vertex.size(); i++) {
            if (matrix[v][i] == 1) {
                return i;
            }
        }
        return -1;
    }
    //根据前一个邻接结点的下标获取下一个邻接结点
    public int getNext(int v1,int v2) {
        for (int i = v2 + 1; i < vertex.size(); i++) {
            //换行了
            if (matrix[v1][i] == 1) {
                return i;
            }
        }
        return -1;
    }


    public void dfs(){
        //遍历所有结点，进行dfs回溯
        for (int i = 0; i < getvCount(); i++) {
            //判断顶点是否被搜索过
            if (!mark[i]) {
                //如果没有被搜索过，则开始搜索
                dfs2(i);
            }
        }
        //复原标记辅助数组的状态
        Arrays.fill(mark, false);
    }
    public void dfs2(int v) {
        mark[v] = true;
        System.out.print(vertex.get(v) + "——>");
        for (int i = 0; i < vertex.size(); i++) {
            if (matrix[v][i] == 1 && !mark[i]) {
                dfs(i);
            }
        }
    }

    public void dfs(int v) {
        System.out.print(vertex.get(v) + "——>");
        //将vertex标记为依据搜索
        mark[v] = true;
        int w = getFirst(v);
        while (w!= -1) {
            if (!mark[w]) {
                dfs(w);
            }
            w = getNext(v, w);
            //相通的顶点+1
        }
    }




    //广度优先遍历
    public void bfs(){
        for (int i = 0; i < vertex.size(); i++) {
            if(!mark[i]){
                bfs(i);
            }
        }

        Arrays.fill(mark, false);
    }

    public void bfs(int v) {
        Queue queue = new LinkedList();
        int next;
        mark[v] = true;
        queue.add(v);
        while (!queue.isEmpty()) {
            next = (int) queue.remove();
            System.out.print(vertex.get(next) + "——>");
            int vex = getFirst(next);
            while (vex != -1) {
                if (mark[vex] == false) {
                    queue.add(vex);
                    mark[vex] = true;
                }
                vex = getNext(next, vex);
            }
        }
    }
}
