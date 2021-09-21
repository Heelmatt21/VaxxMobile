package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{
    private String id;
    private String name;
    private List<Edge> adjacenciesList;
    private boolean visited;
    private Vertex predecessor;
    private double weight = Double.MAX_VALUE;//kortste route
    //private double weight = Double.MIN_VALUE;//langste route


    public Vertex(String id,String name) {
        this.id = id;
        this.name = name;
        this.adjacenciesList = new ArrayList<>();
    }

    public void addNeighbour(Edge edge) {
        this.adjacenciesList.add(edge);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getAdjacenciesList() {
        return adjacenciesList;
    }

    public void setAdjacenciesList(List<Edge> adjacenciesList) {
        this.adjacenciesList = adjacenciesList;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }



    @Override
    public int hashCode() {
        int hashValue = 3;
        final int primeFactor = 23;
        hashValue = hashValue * primeFactor + this.id.hashCode() + this.name.hashCode();
        return hashValue;
    }

    @Override
    public boolean equals(Object obj) {
        boolean flag = false;
        if((obj == null) || (obj.getClass() != this.getClass())) {
            return flag;
        } else {
            Vertex v = (Vertex) obj;
            if((v.getId() == this.getId()) && (v.getName() == this.getName())) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public String toString() { return name; }
    @Override
    public int compareTo(Vertex otherVertex) {
        return Double.compare(this.weight, otherVertex.getWeight());
    }


}