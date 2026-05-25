package core.spanningTree.main;

import core.spanningTree.kruskal.SpanningTreeKruskalAlgorithm;
import core.spanningTree.model.Edge;
import core.spanningTree.model.Graph;
import core.spanningTree.model.Vertex;
import core.spanningTree.util.CreateGraphviz;
import core.spanningTree.util.MatrixConverter;

import java.util.Arrays;
import java.util.List;

public class MainExercise2Fig2 {
    public static void main(String[] args) {

        System.out.println("Inicializando o Grafo...");
        Graph graph = new Graph(12);
        
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");
        Vertex G = new Vertex("G");
        Vertex H = new Vertex("H");
        Vertex I = new Vertex("I");
        Vertex J = new Vertex("J");
        Vertex K = new Vertex("K");
        Vertex L = new Vertex("L");


        List<Vertex> vertexList = Arrays.asList(A,B,C,D,E,F,G,H,I,J,K,L);

        for (Vertex vertex : vertexList) {
            graph.addVertex(vertex);
        }

        graph.printVertexList();

        Edge AB = new Edge(A,B,16);
        Edge AJ = new Edge(A,J,12);
        Edge AC = new Edge(A,C,10);
        Edge CB = new Edge(C,B,7);
        Edge BD = new Edge(B,D,13);
        Edge BE = new Edge(B,E,2);
        Edge EF = new Edge(E,F,9);
        Edge CE = new Edge(C,E,1);
        Edge CG = new Edge(C,G,21);
        Edge DG = new Edge(D,G,15);
        Edge EK = new Edge(E,K,4);
        Edge FG = new Edge(F,G,3);
        Edge FH = new Edge(F,H,20);
        Edge FK = new Edge(F,K,8);
        Edge GH = new Edge(G,H,18);
        Edge GI = new Edge(G,I,17);
        Edge HJ = new Edge(H,J,19);
        Edge IJ = new Edge(I,J,5);
        Edge IK = new Edge(I,K,6);
        Edge IL = new Edge(I,L,14);
        Edge KL = new Edge(K,L,11);


        List<Edge> edgeList = Arrays.asList(AB,AC,AJ,CB,BD,BE,EF,CE,CG,DG,EK,FG,GH,FH,FK,GI,HJ,IJ,IK,IL,KL);

        for (Edge edge : edgeList) {
            graph.addEdge(edge);
        }

        graph.printEdgeList();

        graph.printVertexList();

        graph.printAdjacencyMatrix();

        SpanningTreeKruskalAlgorithm.UnionFind.execute(graph);

        int [][] adjacencySimple = MatrixConverter.convertWeightedToSimple(graph);
        MatrixConverter.printMatrix(adjacencySimple);

        CreateGraphviz cvg = new CreateGraphviz(graph);
        cvg.createGrafoDotFile("Ex2_fig2","Ex2_Figura2");
    }
}
