package core.util;

import core.spanningTree.model.Edge;
import core.spanningTree.model.Graph;

public class MatrixConverter {

    public static int [][] convertWeightedToSimple(Graph graph) {
        int size = graph.getCurrentSize();
        Edge [][] edge = graph.getAdjacencyMatrix();
        int [][] adjacencyMatrix = new int[size][size];
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    if(edge[i][j] == null) {
                        adjacencyMatrix[i][j] = 0;
                    }else{
                        if(edge[i][j].getWeight()!=0){
                            adjacencyMatrix[i][j] = 1;
                        }else{
                            adjacencyMatrix[i][j] = 0;
                        }
                    }
                }
            }
        return adjacencyMatrix;
    }

    public static void printMatrix(int[][] matrix){
        System.out.println("\nMatrix de Adjacências de grafo simples não direcionado.");
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                    System.out.printf("%-2d",matrix[i][j]);
            }
            System.out.println();
        }
    }
}
