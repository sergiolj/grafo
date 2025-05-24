package aplicacao;

import core.Grafo;
import core.Vertice;
import core.util.CreateGraphviz;

public class MainPortugues {

        public static void main(String[] args) {

            Grafo grafo = new Grafo();

            grafo.adicionarVertice("RJ");
            grafo.adicionarVertice("SP");
            grafo.adicionarVertice("BH");
            grafo.adicionarVertice("PT");
            grafo.adicionarVertice("OS");
            grafo.adicionarVertice("SV");
            grafo.adicionarVertice("CR");
            grafo.adicionarVertice("PA");

            System.out.println("O grafo G possui os seguintes vértices:");
            System.out.println();

            for(Vertice vertice : grafo.getVertices()) {
                System.out.println("- Vértice " + vertice.getRotulo());
            }
            CreateGraphviz gviz = new CreateGraphviz(grafo);
            gviz.createVerticesDotFile("grafo.dot", "GrafoTest");
            gviz.createGrafoDotFile("grafo.dot", "grafoTest");

        }
    }
