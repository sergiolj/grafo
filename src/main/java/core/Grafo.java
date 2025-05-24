package core;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Grafo {
    private List<Vertice> vertices = new ArrayList<>();
    private final int tamanhoMaximo;
    private int atualNumeroVertices = 0;
    private boolean numeroMaximoFoiDefinido;
    private Map<String, Integer> rotulosEmIndices = new HashMap<>();
    private MatrizAdjacencia matrizAdjacencia;

    public Grafo() {
        this.tamanhoMaximo = 10; // Corrigido
    }

    public Grafo(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
        this.numeroMaximoFoiDefinido = true;
    }

    public void adicionarVertice(String rotulo) {
        Vertice novoVertice = new Vertice(rotulo);
        this.vertices.add(novoVertice);
        this.rotulosEmIndices.put(novoVertice.getRotulo(), atualNumeroVertices);
        this.atualNumeroVertices++;
    }

    public List<Vertice> getVertices() {
        return this.vertices;
    }

    public Vertice getVertice(String rotulo) {
        this.existeVerticeOrThrow(rotulo);
        int indice = this.rotulosEmIndices.get(rotulo);
        return this.vertices.get(indice);
    }
    
    public void conectarVertices(String rotuloVerticeInicial, String rotuloVerticeFinal) throws Exception{
        if(!this.existeVertice(rotuloVerticeInicial) || !this.existeVertice(rotuloVerticeFinal)) {
            throw new Exception("Para adicionar uma aresta ambos os vértices"
                    + "devem existir.");
        }
        criarMatrizAdjacencia();
        int indiceVerticeFinal = this.rotulosEmIndices.get(rotuloVerticeInicial);
        int indiceVerticeInicial = this.rotulosEmIndices.get(rotuloVerticeFinal);
        this.matrizAdjacencia.adicionarAresta(indiceVerticeInicial,
                indiceVerticeFinal);
    }
    
    public List<Vertice> getAdjacencias(String vertice) {
        this.existeVerticeOrThrow(vertice);
        int indiceVertice = this.rotulosEmIndices.get(vertice);
        return this.matrizAdjacencia.getAdjacencias(indiceVertice);
    }
    
    private boolean existeVerticeOrThrow(String vertice) {
        if(!existeVertice(vertice)) {
            throw new IllegalArgumentException("O vértice não existe.");
        }
        return true;
    }
    
    private boolean existeVertice(String rotuloVertice) {
        int indice = this.rotulosEmIndices.get(rotuloVertice);
        return this.vertices.get(indice) != null ? true : false;
    }
    
    private void criarMatrizAdjacencia() {
        if(this.matrizAdjacencia == null){
        this.matrizAdjacencia = new MatrizAdjacencia(new ArrayList<Vertice>(this.vertices));
    }
    }

    public MatrizAdjacencia getAdjacencias() {
        return this.matrizAdjacencia;
    }

}
