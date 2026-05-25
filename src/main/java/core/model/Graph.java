package core.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private final Edge [][] adjacencyMatrix;
    private final Map<Vertex, Integer> vertexIndex;
    private int currentSize;

    public Graph(int maxSize) {
        this.adjacencyMatrix = new Edge[maxSize][maxSize];
        this.vertexIndex = new HashMap<>();
        this.currentSize = 0;
        System.out.println("Matriz com " + adjacencyMatrix.length + " posições criada com sucesso!\n" );
    }

    public void addVertex(Vertex v) {
        if(currentSize < adjacencyMatrix.length) {
            if(!vertexIndex.containsKey(v)) {
                vertexIndex.put(v, currentSize);
                currentSize++;
            }else{
                System.out.println("Vértice já existente na estrutura do grafo.");
            }
        }else{
            System.out.println("Todos os vértices já foram adicionados.");
        }
    }

    public void addEdge(Edge edge) {
            Vertex vertexOrigin = edge.getOrigin();
            Vertex vertexDestination = edge.getDestination();

            Integer line = vertexIndex.get(vertexOrigin);
            Integer column = vertexIndex.get(vertexDestination);

            if(line != null && column != null) {
                adjacencyMatrix[line][column] = edge;
                adjacencyMatrix[column][line] = edge;
                vertexOrigin.setDegree(vertexOrigin.getDegree() + 1);
                vertexDestination.setDegree(vertexDestination.getDegree() + 1);
            }else{
                throw new IllegalArgumentException(
                        "Todos os vértices devem adicionados ao grafo antes da inserção das arestas.");
            }
    }

    /**
     * Imprime no console a matriz de adjacências ponderada em formato de tabela.
     * O printf foi usado para definir a largura das colunas e possui a seguinte sintaxe %d para inteiros e %s para
     * Strings sendo %[tamanho][tipo]. Sem sinal alinha à direita e com sinal negativo alinha à esquerda.
     *
     */
    public void printAdjacencyMatrix() {
        System.out.println("\nMatriz de Adjacências ponderada:");
        for(int line = 0; line < currentSize; line++) {
            for(int column = 0; column < currentSize; column++) {
                if(adjacencyMatrix[line][column] != null) {
                    System.out.printf("%-15d", adjacencyMatrix[line][column].getWeight());
                }else {
                    System.out.printf("%-15s", "-");
                }
            }
            System.out.println();
        }
    }

    public void printVertexList(){
        System.out.println("\nListagem de vértices com seus graus.");
        for(Vertex v : vertexIndex.keySet()) {
            System.out.println("[" + v.getLabel() + "] Degree=" + v.getDegree());
        }
    }

    public void printEdgeList(){
        System.out.println("\nListagem de Arestas e seus pesos em um grafo não direcionado.");
        List<Edge> edges = getAllEdges();
        for(Edge edge : edges) {
            System.out.println("[" + edge.getOrigin().getLabel() + "-" +edge.getDestination().getLabel() + "] Weight=" + edge.getWeight());
        }
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public Integer getVertexId(Vertex v) {
        return vertexIndex.get(v);
    }

    public List<Edge> getAllEdges() {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < currentSize; i++) {
            for (int j = i + 1; j < currentSize; j++) { // j = i + 1 evita a diagonal e o triângulo inferior
                if (adjacencyMatrix[i][j] != null) {
                    edges.add(adjacencyMatrix[i][j]);
                }
            }
        }
        return edges;
    }

}

//    public List<Vertice> getVertices() {
//        return this.vertices;
//    }
//
//    public Vertice getVertice(String rotulo) {
//        this.existeVerticeOrThrow(rotulo);
//        int indice = this.labelIndex.get(rotulo);
//        return this.vertices.get(indice);
//    }
//
//    public String getVerticeRotulo(int indice) {
//        return this.vertices.get(indice).getRotulo();
//    }
//
//    public void conectarVertices(String rotuloVerticeInicial, String rotuloVerticeFinal) throws Exception{
//        if(!this.existeVertice(rotuloVerticeInicial) || !this.existeVertice(rotuloVerticeFinal)) {
//            throw new Exception("Para adicionar uma aresta ambos os vértices"
//                    + "devem existir.");
//        }
//        criarMatrizAdjacencia();
//        int indiceVerticeFinal = this.labelIndex.get(rotuloVerticeInicial);
//        int indiceVerticeInicial = this.labelIndex.get(rotuloVerticeFinal);
//        this.matrizAdjacencia.adicionarAresta(indiceVerticeInicial,
//                indiceVerticeFinal);
//    }
//
//    public List<Vertice> getAdjacencias(String vertice) {
//        this.existeVerticeOrThrow(vertice);
//        int indiceVertice = this.labelIndex.get(vertice);
//        return this.matrizAdjacencia.getAdjacencias(indiceVertice);
//    }
//
//    private boolean existeVerticeOrThrow(String vertice) {
//        if(!existeVertice(vertice)) {
//            throw new IllegalArgumentException("O vértice não existe.");
//        }
//        return true;
//    }
//
//    private boolean existeVertice(String rotuloVertice) {
//        int indice = this.labelIndex.get(rotuloVertice);
//        return this.vertices.get(indice) != null ? true : false;
//    }
//
//    private void criarMatrizAdjacencia() {
//        if(this.matrizAdjacencia == null){
//        this.matrizAdjacencia = new MatrizAdjacencia(new ArrayList<Vertice>(this.vertices));
//    }
//    }
//
//    public MatrizAdjacencia getAdjacencias() {
//        return this.matrizAdjacencia;
//    }
