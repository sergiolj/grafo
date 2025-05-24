package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph implements GraphInterface{
    private List<Vertex> vertexes = new ArrayList<>();
    private final int maximumSize;
    private int actualNumberOfVertexes = 0;
    private boolean isMaximumSizeDefined;
    private Map<String, Integer> labesAndIndexes = new HashMap<>();

    public Graph() {
        this.maximumSize = 10;
    }

    public Graph(int maximumSize) {
        if (maximumSize <= 0) {
            throw new IllegalArgumentException("The maximum number of vertices must be greater than 0");
        }
        this.maximumSize = maximumSize;
        this.isMaximumSizeDefined = true;
    }

    @Override
    public void addVertex(String label) throws IllegalArgumentException {
        if(actualNumberOfVertexes <= maximumSize - 1) {
            Vertex newVertex = new Vertex(label);
            this.vertexes.add(newVertex);
            this.labesAndIndexes.put(newVertex.getLabel(), actualNumberOfVertexes);
            actualNumberOfVertexes++;
        }else{
            throw new IllegalArgumentException("The maximum number of vertices " + maximumSize + " has been exceeded.");
        }
    }

    public List<Vertex> getVertexes() {
        return this.vertexes;
    }

    @Override
    public String toString() {
        if(vertexes.isEmpty()){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i=0; i<vertexes.size()-1; i++) {
            sb.append(vertexes.get(i)).append(", ");
        }
        sb.append(vertexes.getLast()).append("]");
        return sb.toString();
    }
}
