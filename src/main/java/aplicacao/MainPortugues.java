package aplicacao;

import core.Grafo;
import core.Vertice;
import core.util.CreateGraphviz;

public class MainPortugues {

        public static void main(String[] args) throws Exception {

            Grafo grafo = new Grafo();

            grafo.adicionarVertice("A1");
            grafo.adicionarVertice("B1");
            grafo.adicionarVertice("C1");
            grafo.adicionarVertice("D1");

            grafo.conectarVertices("A1","B1");
            grafo.conectarVertices("A1","B1");

            grafo.conectarVertices("B1","C1");
            grafo.conectarVertices("A1","D1");

            grafo.conectarVertices("C1","C1");
            grafo.conectarVertices("A1","A1");

            System.out.println("O grafo G possui os seguintes vértices:");
            System.out.println();

            System.out.println(grafo.getVertices());
            System.out.println(grafo.getVerticeRotulo(0));
            System.out.println(grafo.getAdjacencias(grafo.getVerticeRotulo(0)));

            CreateGraphviz gviz = new CreateGraphviz(grafo);

            gviz.createGrafoDotFile("grafo", "Grafo");
            gviz.createVerticesDotFile("vertices", "Vertices");

        }
    }
