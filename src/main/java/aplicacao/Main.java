package aplicacao;

import core.Graph;
import core.Vertex;

public class Main {
    public static void main(String[] args) {

        Graph grafo = new Graph();

        grafo.addVertex("RJ");
        grafo.addVertex("SP");
        grafo.addVertex("BH");
        grafo.addVertex("PT");
        grafo.addVertex("OS");
        grafo.addVertex("SV");
        grafo.addVertex("CR");
        grafo.addVertex("PA");

        System.out.println("O grafo G possui os seguintes vértices:");
        System.out.println();
        for(Vertex vertice : grafo.getVertexes()) {
            System.out.println("- Vértice " + vertice.getLabel());
            int [][] matriz = new int[5][5];
            matriz[0][0] = 1;
            matriz[1][1] = 1;
            matriz[2][2] = 1;
            matriz[3][3] = 1;
            matriz[4][4] = 1;

        }
    }
}