package core;

public class Vertice {
    private int grau;
    private final String rotulo;

    public Vertice(String rotulo) {
        this.rotulo = rotulo;
    }

    public String getRotulo() {
        return this.rotulo;
    }

    void addGrau(){
        grau++;
    }

    public int getGrau() {
        return grau;
    }

    @Override
    public String toString() {
        return this.rotulo;
    }
}

