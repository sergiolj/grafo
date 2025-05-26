package aplicacao;

import core.Grafo;
import core.Vertice;
import core.util.CreateGraphviz;

import java.util.List;

public class MainTest {
    public static void main(String[] args) throws Exception {
        Grafo grafo = new Grafo();
        grafo.adicionarVertice("A1");
        grafo.adicionarVertice("A2");
        grafo.adicionarVertice("A3");
        grafo.adicionarVertice("B1");
        grafo.adicionarVertice("B2");
        grafo.adicionarVertice("B3");
        grafo.adicionarVertice("C1");
        grafo.adicionarVertice("C2");
        grafo.adicionarVertice("C3");

        grafo.conectarVertices("A1","A2");
        grafo.conectarVertices("A1","A3");
        grafo.conectarVertices("A1","B1");
        grafo.conectarVertices("A1","C1");
        grafo.conectarVertices("A1","B2");
        grafo.conectarVertices("A1","C3");

        grafo.conectarVertices("A2","A3");
        grafo.conectarVertices("A2","B2");
        grafo.conectarVertices("A2","C2");

        grafo.conectarVertices("A3","B3");
        grafo.conectarVertices("A3","C3");
        grafo.conectarVertices("A3","B2");
        grafo.conectarVertices("A3","C1");

        grafo.conectarVertices("B1","B2");
        grafo.conectarVertices("B1","B3");
        grafo.conectarVertices("B1","C1");

        grafo.conectarVertices("B2","B3");
        grafo.conectarVertices("B2","C2");
        grafo.conectarVertices("B2","C3");
        grafo.conectarVertices("B2","C1");

        grafo.conectarVertices("B3","C3");

        grafo.conectarVertices("C1","C2");
        grafo.conectarVertices("C1","C3");

        grafo.conectarVertices("C2","C3");

        System.out.println("Grau do vértice A: " +
                grafo.getVertice("A1").getGrau());
        System.out.println("Grau do vértice D: " +
                grafo.getVertice("B1").getGrau());
        System.out.println("Grau do vértice C: " +
                grafo.getVertice("C1").getGrau());
        System.out.println();
        System.out.print("O vértice A possui as seguintes adjacências: ");
        List<Vertice> adjacentes = grafo.getAdjacencias("A1");
        for(Vertice vertice : adjacentes) {
            System.out.print(vertice.getRotulo() + " ");
        }
        System.out.println();
        System.out.print("O vértice C possui as seguintes adjacências: ");
        adjacentes = grafo.getAdjacencias("C1");
        for(Vertice vertice : adjacentes) {
            System.out.print(vertice.getRotulo() + " ");
        }

        CreateGraphviz cviz = new CreateGraphviz(grafo);
        cviz.createGrafoDotFile("arquivo.dot", "grafoTest");
        cviz.createVerticesDotFile("vertices.dot", "grafoVertice");
    }
}
