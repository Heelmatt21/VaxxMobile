package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
    public static void DFS(Graph graph, Vertex v) {

        if((graph != null) && (v != null)) {
            Stack<Vertex> stack = new Stack<Vertex>();
            List<Vertex> list = new ArrayList<Vertex>();
            stack.push(v);
            list.add(v);
            while(!stack.empty()) {
                Vertex temp = stack.pop();
                System.out.print(temp + " "); //Print de root
                for(Vertex i : graph.getAdjacentVertex(temp)) {
                    if(!list.contains(i)) {
                        list.add(i);
                        stack.push(i);
                    }
                }
            }

        }

    }

    public static void recursiveDFS(Graph graph, Vertex v) {

        if((graph != null) && (v != null)) {
            List<Vertex> list = new ArrayList<Vertex>();
            dfsUtil(graph, list, v);
        }

    }
    private static void dfsUtil(Graph graph, List<Vertex> list, Vertex ver) {
        list.add(ver);
        System.out.print(ver + " ");
        for (Vertex i : graph.getAdjacentVertex(ver)) {
            if (!list.contains(i)) {
                list.add(i);
                dfsUtil(graph, list, i);
            }
        }
    }
}
