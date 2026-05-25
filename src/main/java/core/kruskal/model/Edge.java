package core.kruskal.model;

public class Edge implements Comparable<Edge> {

    private final Vertex origin;
    private final Vertex destination;
    private final int weight;

    public Edge(Vertex origin, Vertex destination, int weight) {
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }

    public Vertex getOrigin() {
        return origin;
    }

    public Vertex getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }
    @Override
    public String toString() {
        return "Edge [" + origin.getLabel() + "-" + destination.getLabel() + "] Weight=" + weight;
    }
}
