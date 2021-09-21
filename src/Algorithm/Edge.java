package Algorithm;

public class Edge {
    private String id;
    private double weight;
    private Vertex startVertex;
    private Vertex endVertex;

    public Edge(String id, double weight, Vertex startVertex, Vertex targetVertex) {
        this.id = id;
        this.weight = weight;
        this.startVertex = startVertex;
        this.endVertex = targetVertex;
    }
    public Edge() {

    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) { this.weight = weight; }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex getEndVertex() {
        return endVertex;
    }

    public void setEndVertex(Vertex endVertex) {
        this.endVertex = endVertex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }

    @Override
    public boolean equals(Object obj) {
        boolean flag = false;
        if((obj == null) || (obj.getClass() != this.getClass())) {
            return flag;
        } else {
            Edge e = (Edge) obj;
            if((e.startVertex.equals(this.startVertex)) && (e.endVertex.equals(this.endVertex))) {
                flag = true;
            }
        }

        return flag;

    }

    @Override
    public int hashCode() {
        int hash = 3;
        final int prime = 23;
        hash = hash * prime + this.startVertex.hashCode() + this.endVertex.hashCode();
        return hash;
    }

    @Override
    public String toString() {
        return startVertex + " -> " + endVertex;
    }

}
