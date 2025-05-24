package core.util;

import core.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CreateGraphviz {
    private final Grafo grafo;
    private final List<Vertice> vertexes;
    private final MatrizAdjacencia matrizAdjacencia;

    public CreateGraphviz(Grafo grafo){
        this.grafo = grafo;
        this.vertexes = grafo.getVertices();
        this.matrizAdjacencia = grafo.getAdjacencias();
    }

    public void createVerticesDotFile(String fileName, String graphName) {
        StringBuilder sb = new StringBuilder();
        sb.append("graph ").append(graphName).append("{\n");
        for (Vertice vertex : vertexes) {
            sb.append(vertex.getRotulo()).append(";\n");
        }
        sb.append("}");
        System.out.println(sb.toString());
    }

    public void createGrafoDotFile(String fileName, String graphName) {
        try {
            StringBuilder sb = new StringBuilder();
        sb.append("graph ").append(graphName).append("{\n");
        for (int i = 0; i < vertexes.size(); i++) {
            List<Vertice> adjVerticeN= matrizAdjacencia.getAdjacencias(i);
            for(Vertice adjVertice: adjVerticeN){
                sb.append(adjVertice.getRotulo()).append(" -- ");
            }
            sb.append(";\n");
        }
        sb.append("}");
            System.out.println(sb.toString());

            File file = new File(fileName);
            System.out.println(file.getAbsoluteFile());
            FileWriter fileWriter = new FileWriter(file);

            fileWriter.write(sb.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
