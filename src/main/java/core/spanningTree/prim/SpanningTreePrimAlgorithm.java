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
        public static List<Edge> execute(Graph graph, Vertex startVertex) {
            List<Edge> spanningTree = new ArrayList<>();

            // Mantém o registro das cidades que já fazem parte do nosso "território"
            Set<Vertex> visited = new HashSet<>();

            // A Fila de Prioridade que sempre deixará a aresta mais barata no topo
            PriorityQueue<Edge> frontier = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));

            int totalCost = 0;

            System.out.println("\n--- Iniciando Prim a partir de: " + startVertex.getLabel() + " ---");

            // 1. Pousamos no vértice inicial
            visited.add(startVertex);

            // Colocamos todas as arestas que saem dele na nossa fronteira
            frontier.addAll(graph.getAllEdgesFrom(startVertex));

            // 2. Expandir a fronteira até dominarmos todas as cidades
            while (!frontier.isEmpty() && visited.size() < graph.getCurrentSize()) {

                // Pega a aresta mais barata disponível na fronteira inteira
                Edge cheapestEdge = frontier.poll();

                // Como a aresta liga A a B, precisamos descobrir qual das duas pontas é a cidade "nova"
                Vertex newVertex = null;
                if (!visited.contains(cheapestEdge.getOrigin())) {
                    newVertex = cheapestEdge.getOrigin();
                } else if (!visited.contains(cheapestEdge.getDestination())) {
                    newVertex = cheapestEdge.getDestination();
                }

                // Se a aresta nos levou a uma cidade que ainda não tínhamos visitado...
                if (newVertex != null) {
                    // Dominamos a cidade!
                    visited.add(newVertex);
                    spanningTree.add(cheapestEdge);
                    totalCost += cheapestEdge.getWeight();

                    System.out.println("Expandindo para: [" + cheapestEdge.getOrigin().getLabel() + " - " + cheapestEdge.getDestination().getLabel() + "] Peso: " + cheapestEdge.getWeight());

                    // Adicionamos as estradas da cidade nova ao nosso radar de fronteira
                    for (Edge edge : graph.getAllEdgesFrom(newVertex)) {
                        // Só adicionamos as estradas que levam a lugares desconhecidos
                        if (!visited.contains(edge.getOrigin()) || !visited.contains(edge.getDestination())) {
                            frontier.add(edge);
                        }
                    }
                }
                // Se as duas pontas da aresta já estavam em 'visited', o ciclo foi evitado automaticamente!
            }

            System.out.println("Custo Total Mínimo da AGM (Prim): " + totalCost);
            return spanningTree;
        }
}
