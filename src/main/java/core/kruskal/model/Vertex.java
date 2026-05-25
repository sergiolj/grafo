package core.kruskal.model;

public class Vertex {
    private int degree;
    private final String label;

    public Vertex(String label) throws IllegalArgumentException {
        boolean isRotuloNullOrBlank = label == null || label.isBlank();
        if(isRotuloNullOrBlank){
            throw new IllegalArgumentException("A vertex label can´t be null or blank");
        }
        this.label = label.trim();
    }

    public String getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        return this.label + " - Degree [" + this.degree + "]";
    }

    public int getDegree() {
        return this.degree;
    }
    public void setDegree(int degree) {
        this.degree = degree;
    }
}
