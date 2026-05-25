package core.kruskal;

import core.kruskal.model.Edge;
import core.kruskal.model.Graph;
import core.kruskal.model.Vertex;

import java.util.Arrays;
import java.util.List;

public class MainExercise3 {
    public static void main(String[] args) {

        System.out.println("Inicializando o Grafo...");
        Graph graph = new Graph(10);
        
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



        List<Vertex> vertexList = Arrays.asList(A,B,C,D,E,F,G,H,I,J);

        for (Vertex vertex : vertexList) {
            graph.addVertex(vertex);
        }

        graph.printVertexList();

        Edge AB = new Edge(A,B,15);
        Edge AC = new Edge(A,C,10);
        Edge AD = new Edge(A,D,19);
        Edge BD = new Edge(B,D,7);
        Edge BE = new Edge(B,E,17);
        Edge CD = new Edge(C,D,16);
        Edge CF = new Edge(C,F,14);
        Edge DE = new Edge(D,E,12);
        Edge DF = new Edge(D,F,6);
        Edge DG = new Edge(D,G,3);
        Edge EG = new Edge(E,G,20);
        Edge EH = new Edge(E,H,13);
        Edge FG = new Edge(F,G,9);
        Edge FI = new Edge(F,I,5);
        Edge GH = new Edge(G,H,4);
        Edge GI = new Edge(G,I,1);
        Edge GJ = new Edge(G,J,11);
        Edge HJ = new Edge(H,J,2);
        Edge IJ = new Edge(I,J,18);

        List<Edge> edgeList = Arrays.asList(AB,AC,AD,BD,BE,CD,CF,DE,DF,DG,EG,EH,FG,FI,GH,GI,GJ,HJ,IJ);

        for (Edge edge : edgeList) {
            graph.addEdge(edge);
        }

        graph.printEdgeList();

        graph.printVertexList();

        graph.printAdjacencyMatrix();

        Kruskal.UnionFind.execute(graph);
    }
}
