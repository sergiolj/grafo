package core.spanningTree.prim;

import core.spanningTree.model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class SpanningTreePrimAlgorithm {

        /**
         * O Prim precisa de um ponto de partida. Você passa o grafo e a cidade de origem.
         */
        public static List<Edge> execute(Graph originalGraph, Vertex startVertex) {
            List<Edge> spanningTree = new ArrayList<>();
            Set<Vertex> visited = new HashSet<>();
            PriorityQueue<Edge> frontier = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));

            int totalCost = 0;

            System.out.println("\n--- Iniciando Prim a partir de: " + startVertex.getLabel() + " ---");

            visited.add(startVertex);
            frontier.addAll(originalGraph.getAllEdgesFrom(startVertex));

            while (!frontier.isEmpty() && visited.size() < originalGraph.getCurrentSize()) {
                Edge cheapestEdge = frontier.poll();

                Vertex newVertex = null;
                if (!visited.contains(cheapestEdge.getOrigin())) {
                    newVertex = cheapestEdge.getOrigin();
                } else if (!visited.contains(cheapestEdge.getDestination())) {
                    newVertex = cheapestEdge.getDestination();
                }

                if (newVertex != null) {
                    visited.add(newVertex);
                    spanningTree.add(cheapestEdge);
                    totalCost += cheapestEdge.getWeight();

                    System.out.println("Expandindo para: [" + cheapestEdge.getOrigin().getLabel() +
                            " - " + cheapestEdge.getDestination().getLabel() +
                            "] Peso: " + cheapestEdge.getWeight());

                    for (Edge edge : originalGraph.getAllEdgesFrom(newVertex)) {
                        if (!visited.contains(edge.getOrigin()) || !visited.contains(edge.getDestination())) {
                            frontier.add(edge);
                        }
                    }
                }
            }

            System.out.println("Custo Total Mínimo da AGM (Prim): " + totalCost);
            return spanningTree;
        }

        /**
         * NOVO MÉTODO: Retorna a Árvore Geradora Mínima em formato de objeto Graph.
         * Reutiliza a lógica do execute() para evitar duplicação de código.
         */
        public static Graph executeAsGraph(Graph originalGraph, Vertex startVertex) {
            // 1. Roda a lógica matemática já pronta para obter a lista de arestas
            List<Edge> mstEdges = execute(originalGraph, startVertex);

            // 2. Cria a nova estrutura de dados
            Graph mstGraph = new Graph(originalGraph.getCurrentSize());

            // 3. Popula o novo grafo com os vértices
            for (Vertex v : originalGraph.getVertexList()) {
                mstGraph.addVertex(v);
            }

            // 4. Popula a matriz de adjacências apenas com as estradas vencedoras
            for (Edge edge : mstEdges) {
                mstGraph.addEdge(edge);
            }

            return mstGraph;
        }
    }
