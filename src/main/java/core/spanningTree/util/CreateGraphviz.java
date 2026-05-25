package core.spanningTree.util;

import core.spanningTree.model.Graph;
import core.spanningTree.model.Vertex;
import core.util.MatrixConverter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CreateGraphviz {
    private final List<Vertex> vertexList;
    private final int [][] adjacencyMatrix;

    public CreateGraphviz(Graph graph){
        this.vertexList = graph.getVertexList();
        this.adjacencyMatrix = MatrixConverter.convertWeightedToSimple(graph);
    }

    public void createVerticesDotFile(String fileName, String graphName) {
        StringBuilder sb = new StringBuilder();
        sb.append("graph ").append(graphName).append("{\n");
            for(Vertex vertex : vertexList){
                sb.append(vertex.getLabel()).append(";\n");
        }
        sb.append("}");
        String data = sb.toString();
        System.out.println(data);
        saveFile(fileName,graphName,data);
    }

    public void createGrafoDotFile(String fileName, String graphName) {
        System.out.println("Criando arquivo dot para grafo bidimensional desconsiderando arestas paralelas");
        StringBuilder sb = new StringBuilder();
        sb.append("graph ").append(graphName).append("{\n");

        for(int i = 0; i < vertexList.size(); i++) {
            if(i!=0) sb.append("\n");
            if(adjacencyMatrix[i][i] == 1){
                sb.append(vertexList.get(i).getLabel()).append(" -- ");
                sb.append(vertexList.get(i).getLabel()).append(";");
            }
            for (int j = i+1; j < vertexList.size(); j++) {
                if(adjacencyMatrix[i][j] == 1){
                    sb.append(vertexList.get(i).getLabel()).append(" -- ");
                    sb.append(vertexList.get(j).getLabel()).append(";");
                }
            }
        }
        sb.append("}");

        String data = sb.toString();
        System.out.println(data);
        saveFile(fileName,graphName,data);
    }

    private void saveFile(String fileName, String graphName, String data) {
        try{
            FileWriter fileWriter = new FileWriter(fileName + ".dot");

            fileWriter.write(data);
            fileWriter.close();
            System.out.println("Arquivo " + fileName + ".dot criado com sucesso!" );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
