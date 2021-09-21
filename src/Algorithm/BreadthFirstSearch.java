package Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    public static void BFS(Graph graph, Vertex v) {

        if((graph == null) && (v == null)) {
            return;
        } else {
            Queue<Vertex> queue = new LinkedList<Vertex>(); //LinkedList implementeert een Queue
            List<Vertex> list = new ArrayList<Vertex>(); //Deze list wordt gebruikt om de visited nodes te onthouden
            queue.add(v);
            list.add(v);

            while(queue.peek() != null) {
                Vertex temp = queue.remove();
                System.out.print(temp + " ");
                for(Vertex i : graph.getAdjacentVertex(temp)) {
                    if(!list.contains(i)) {
                        list.add(i);
                        queue.add(i);
                    }
                }
            }

        }

    }

}
