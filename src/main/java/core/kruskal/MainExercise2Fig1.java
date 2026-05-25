package core.kruskal;

import core.kruskal.model.Edge;
import core.kruskal.model.Graph;
import core.kruskal.model.Vertex;

import java.util.Arrays;
import java.util.List;

public class MainExercise2Fig1 {
    public static void main(String[] args) {

        System.out.println("Inicializando o Grafo...");
        Graph graph = new Graph(8);
        
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");
        Vertex G = new Vertex("G");
        Vertex H = new Vertex("H");


        List<Vertex> vertexList = Arrays.asList(A,B,C,D,E,F,G,H);

        for (Vertex vertex : vertexList) {
            graph.addVertex(vertex);
        }

        graph.printVertexList();

        Edge AB = new Edge(A,B,2);
        Edge AC = new Edge(A,C,3);
        Edge BD = new Edge(B,D,2);
        Edge CD = new Edge(C,D,1);

        Edge DE = new Edge(D,E,2);
        Edge DF = new Edge(D,F,4);
        Edge EF = new Edge(E,F,1);
        Edge EG = new Edge(E,G,2);
        Edge FG = new Edge(F,G,2);
        Edge FH = new Edge(F,H,1);
        Edge GH = new Edge(G,H,3);

        List<Edge> edgeList = Arrays.asList(AB, AC, BD, CD, DE, DF, EF, EG, FH, FG, GH);

        for (Edge edge : edgeList) {
            graph.addEdge(edge);
        }

        graph.printEdgeList();

        graph.printVertexList();

        graph.printAdjacencyMatrix();

        Kruskal.UnionFind.execute(graph);
    }
}
