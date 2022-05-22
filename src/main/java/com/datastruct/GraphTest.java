package com.datastruct;

/**
 * @ClassName GraphTest
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/5/21 13:24
 * @Version 1.0
 **/
public class GraphTest {
    public static void main(String[] args) {
        //存放顶点的数组
        String vertex[] = {"A","B","C","D","E","F","G"};

        //将数组的长度传入无向图对象
        Graph<String> graph = new Graph<>(vertex.length);

        //将顶点添加到图的顶点集合中
        for (String s : vertex) {
            graph.addVertex(s);
        }

        //添加边
        graph.addEdge(0,1,1);
        graph.addEdge(0,2,1);
        graph.addEdge(0,5,1);
        graph.addEdge(1,2,1);
        graph.addEdge(1,3,1);
        graph.addEdge(1,4,1);
        graph.addEdge(5,6,1);


        System.out.println("----------测试无向图中顶点的数量:-----------------");
        System.out.println(graph.getvCount());

        System.out.println("----------测试无向图中边的数量:-----------------");
        System.out.println(graph.getEdgeCount());

        System.out.println("----------邻接矩阵表示无向图测试:-----------------");
        graph.print();

        System.out.println("----------测试深度优先遍历:----------------------");
        graph.dfs();

        System.out.println();
        System.out.println("----------广度遍历优先测试:--------------------------");
        graph.bfs();
    }
}
