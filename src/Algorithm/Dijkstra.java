package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    public void computePaths(Vertex startVertex) {

        startVertex.setWeight(0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(startVertex);
        startVertex.setVisited(true);

        while (!priorityQueue.isEmpty()) {
            Vertex actualVertex = priorityQueue.poll();

            for (Edge edge : actualVertex.getAdjacenciesList()) {

                Vertex v = edge.getEndVertex();
                if (!v.isVisited()) {
                    double newWeight = actualVertex.getWeight() + edge.getWeight();

                    if (newWeight < v.getWeight()) //Kortste route
                    //if(newWeight > v.getWeight() ) //langste route
                    {
                        priorityQueue.remove(v);
                        v.setWeight(newWeight);
                        v.setPredecessor(actualVertex);
                        priorityQueue.add(v);

                    }
                }
            }
            actualVertex.setVisited(true);
        }
    }

    public List<Vertex> getPathTo(Vertex endVertex) {
        List<Vertex> path = new ArrayList<>();

        for (Vertex vertex = endVertex; vertex != null; vertex = vertex.getPredecessor()) {
            path.add(vertex);
        }

        Collections.reverse(path);
        return path;
    }
}
