package core.util;

import core.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CreateGraphviz {
    private final Grafo grafo;
    private final List<Vertice> vertices;
    private final int [][] matrizAdjacencia;

    public CreateGraphviz(Grafo grafo){
        this.grafo = grafo;
        this.vertices = grafo.getVertices();
        this.matrizAdjacencia = grafo.getAdjacencias().getMatrizAdjacencias();
    }

    public void createVerticesDotFile(String fileName, String graphName) {
        StringBuilder sb = new StringBuilder();
        sb.append("graph ").append(graphName).append("{\n");
        for (int i = 0; i < vertices.size(); i++) {
            sb.append(grafo.getVerticeRotulo(i)).append(";\n");
        }
        sb.append("}");

        try{
            FileWriter fileWriter = new FileWriter(fileName);

            fileWriter.write(sb.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createGrafoDotFile(String fileName, String graphName) {
        System.out.println("Criando arquivo dot para grafo bidimensional desconsiderando arestas paralelas");
        StringBuilder sb = new StringBuilder();
        sb.append("graph ").append(graphName).append("{\n");

        for(int i = 0; i < vertices.size(); i++) {
            if(i!=0) sb.append("\n");
            if(matrizAdjacencia[i][i] == 1){
                sb.append(vertices.get(i).getRotulo()).append(" -- ");
                sb.append(vertices.get(i).getRotulo()).append(";");
            }
            for (int j=i+1; j < matrizAdjacencia.length; j++) {
                if(matrizAdjacencia[i][j] == 1){
                    sb.append(vertices.get(i)).append(" -- ");
                    sb.append(vertices.get(j).getRotulo()).append(";");
                }
            }
        }
        sb.append("}");
        System.out.println(sb.toString());

        try{
            FileWriter fileWriter = new FileWriter(fileName + ".dot");

            fileWriter.write(sb.toString());
            fileWriter.close();
            System.out.println("Arquivo " + fileName + ".dot criado com sucesso!" );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
