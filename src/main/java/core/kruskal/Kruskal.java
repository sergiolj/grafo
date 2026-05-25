package core.kruskal;

import core.kruskal.model.Graph;
import core.kruskal.model.Edge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * O algoritmo de Kruskal usa uma estrutura de grafo para definir a partir dela a Árvore Geradora Mínima.
 * Essa classe deve receber um grafo conectado, não direcional e ponderado e a partir dele criar um arquivo txt com a
 * árvore resultante.
 */
public class Kruskal {
    private static List<Edge> spanningTree;

    public static class UnionFind{
        int [] father;

        public UnionFind(int n){
            father = new int[n];
            for(int i = 0; i < n; i++){
                father[i] = i;
            }
        }

        public int find(int i){
            if(father[i] == i) return i;
            return father[i] = find(father[i]);
        }

        public void union(int i, int j){
            father[find(i)] = father[j];
        }

        public static void execute(Graph graph){
            List<Edge> edges = graph.getAllEdges();
            edges.sort(Comparator.comparing(Edge::getWeight));
            int numVertices = graph.getCurrentSize();
            UnionFind unionFind = new UnionFind(numVertices);

            spanningTree = new ArrayList<>();
            int totalCost = 0;

            System.out.println("\n--- Iniciando Kruskal ---");

            // 3. Itera sobre as arestas ordenadas
            for (Edge edge : edges) {
                // Traduz o Objeto Vértice para o Número do índice dele usando o seu Map
                int rootOrigin = unionFind.find(graph.getVertexId(edge.getOrigin()));
                int rootDest = unionFind.find(graph.getVertexId(edge.getDestination()));

                // Se as raízes são diferentes, não forma ciclo!
                if (rootOrigin != rootDest) {
                    unionFind.union(rootOrigin, rootDest); // Conecta na estrutura
                    spanningTree.add(edge);        // Guarda a aresta na resposta
                    totalCost += edge.getWeight(); // Soma o custo final

                    System.out.println("Adicionada: [" + edge.getOrigin().getLabel() + " - " + edge.getDestination().getLabel() + "] Peso: " + edge.getWeight());

                    // Critério de parada: Árvore completa (n - 1)
                    if (spanningTree.size() == numVertices - 1) {
                        break;
                    }
                }
            }
            System.out.println("Custo Total Mínimo da AGM: " + totalCost);
        }
    }

    public Kruskal(){}

    public List<Edge> getSpanningTree() {
        return spanningTree;
    }
}
