package core.spanningTree.main;

import core.spanningTree.kruskal.SpanningTreeKruskalAlgorithm;
import core.spanningTree.model.Edge;
import core.spanningTree.model.Graph;
import core.spanningTree.model.Vertex;
import core.spanningTree.util.CreateGraphviz;
import core.spanningTree.util.MatrixConverter;

import java.util.Arrays;
import java.util.List;

public class MainExercise1 {
    public static void main(String[] args) {

        System.out.println("Inicializando o Grafo...");
        Graph graph = new Graph(6);
        
        Vertex A = new Vertex("Aberdeen");
        Vertex E = new Vertex("Edinburgh");
        Vertex F = new Vertex("Fort_William");
        Vertex G = new Vertex("Glasgow");
        Vertex I = new Vertex("Inverness");
        Vertex P = new Vertex("Perth");

        List<Vertex> vertexList = Arrays.asList(A, E, F, G, I, P);

        for (Vertex vertex : vertexList) {
            graph.addVertex(vertex);
        }
        graph.printVertexList();

        Edge AE = new Edge(A,E,120);
        Edge AF = new Edge(A,F,147);
        Edge AG = new Edge(A,G,142);
        Edge AI = new Edge(A,I,104);
        Edge AP = new Edge(A,P,81);
        Edge EF = new Edge(E,F,132);
        Edge EG = new Edge(E,G,42);
        Edge EI = new Edge(E,I,157);
        Edge EP = new Edge(E,P,45);
        Edge FG = new Edge(F,G,102);
        Edge FI = new Edge(F,I,66);
        Edge FP = new Edge(F,P,105);
        Edge GI = new Edge(G,I,168);
        Edge GP = new Edge(G,P,61);
        Edge IP = new Edge(I,P,112);



        List<Edge> edgeList = Arrays.asList(AE, AF, AG, AI, AP, EF, EG, EI, EP, FG, FI, FP, GI, GP, IP);

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
        cvg.createGrafoDotFile("Ex1","Cidades");

        System.out.println("Tipos diferentes de motores de layout do graphviz:");
        System.out.println("dot circo neato twopi\nTipo de uso :~/ circo -Tpdf Ex2_fig2.dot -o Exercicio2_f2.pdf");
    }
}
