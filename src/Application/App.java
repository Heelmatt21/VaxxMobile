package Application;

import Algorithm.Dijkstra;
import Algorithm.Edge;
import Algorithm.Graph;
import Algorithm.Vertex;

import java.util.List;

import static Algorithm.BreadthFirstSearch.BFS;
import static Algorithm.DepthFirstSearch.DFS;
import static Algorithm.DepthFirstSearch.recursiveDFS;

public class App {
    private boolean isDirected;


    public static void main(String[] args) {
        Graph graph = new Graph(true);

        //vertices
        Vertex vertexA = new Vertex("A", "BOG");
        graph.addVertex(vertexA);
        Vertex vertexB = new Vertex("B", "RGD Meerzorg");
        graph.addVertex(vertexB);
        Vertex vertexC = new Vertex("C", "RGD Limesgracht");
        graph.addVertex(vertexC);
        Vertex vertexD = new Vertex("D", "RGD Lelydorp");
        graph.addVertex(vertexD);
        Vertex vertexE = new Vertex("E", "RGD Latour");
        graph.addVertex(vertexE);
        //Vertex vertexF = new Vertex("F", "RGD Zanderij");
        //graph.addVertex(vertexF);


        //weight
        vertexA.addNeighbour(new Edge("A", 11, vertexA, vertexB));
        vertexA.addNeighbour(new Edge("A", 2, vertexA, vertexC));
        vertexB.addNeighbour(new Edge("B", 21, vertexB, vertexD));
        vertexB.addNeighbour(new Edge("B", 10, vertexB, vertexE));
        vertexC.addNeighbour(new Edge("C", 5, vertexC, vertexE));
        //vertexD.addNeighbour(new Edge("D", 30, vertexD, vertexF));
        vertexE.addNeighbour(new Edge("E", 12, vertexE, vertexD));

        //directed graphs
        graph.addEdge(vertexA, vertexB, graph.isDirected);
        graph.addEdge(vertexA, vertexC, graph.isDirected);
        graph.addEdge(vertexB, vertexD, graph.isDirected);
        graph.addEdge(vertexB, vertexE, graph.isDirected);
        graph.addEdge(vertexC, vertexE, graph.isDirected);
        //graph.addEdge(vertexD, vertexF, graph.isDirected);
        graph.addEdge(vertexE, vertexD, graph.isDirected);

        //directed graph of niet
        graph.printGraph();
        System.out.println("\n");
        System.out.println("Check als vertexes aan elkaar verbonden zijn: ");
        if (graph.isConnected(vertexA, vertexB))
            System.out.println(vertexA + " en " + vertexB + " zijn verbonden!");
        else
            System.out.println(vertexA + " en " + vertexB + " zijn niet verbonden!");

        if (graph.isConnected(vertexA, vertexE))
            System.out.println(vertexA + " en " + vertexE + " zijn verbonden!");
        else
            System.out.println(vertexA + " en " +  vertexE + " zijn niet verbonden!");

        //Roept getAdjacentVertex() op voor naaste locaties
        List<Vertex> temp = graph.getAdjacentVertex(new Vertex("A", "BOG"));
        System.out.println("\n");
        System.out.println("Naaste locaties van " + vertexA + " zijn: ");
        for (Vertex ver : temp) {
            System.out.println(ver);
        }


        //Dijkstra kortste weg
        Dijkstra Path = new Dijkstra();
        Path.computePaths(vertexA);


        System.out.println("Dijkstra");
        System.out.println("Minimale Afstanden: ");

        System.out.println("van " + vertexA + " naar " + vertexB + ":" + vertexB.getWeight());
        System.out.println("van " + vertexA + " naar " + vertexC + ":" + vertexC.getWeight());
        System.out.println("van " + vertexA + " naar " + vertexD + ":" + vertexD.getWeight());
        System.out.println("van " + vertexA + " naar " + vertexE + ":" + vertexE.getWeight());
        //System.out.println("van " + vertexA + " naar " + vertexF + ":" + vertexF.getWeight());

        System.out.println("\n");
        System.out.println("Korste route:");//kortste route
        //System.out.println("Langste route");//langste route

        System.out.println("van " + vertexA + " naar " + vertexB + ":" + Path.getPathTo(vertexB));
        System.out.println("van " + vertexA + " naar " + vertexC + ":" + Path.getPathTo(vertexC));
        System.out.println("van " + vertexA + " naar " + vertexD + ":" + Path.getPathTo(vertexD));
        System.out.println("van " + vertexA + " naar " + vertexE + ":" + Path.getPathTo(vertexE));
        //System.out.println("van " + vertexA + " naar " + vertexF + ":" + Path.getPathTo(vertexF));

        //DFS
        System.out.println("");
        System.out.println("Output of Depth First Search: ");
        DFS(graph, new Vertex("A", "BOG"));

        System.out.println("\n");
        DFS(graph, new Vertex("B", "RGD Meerzorg"));

        //BFS
        System.out.println("\n");
        System.out.println("Output of Breadth First Search: ");
        BFS(graph, new Vertex("A", "BOG"));

        System.out.println("\n");
        BFS(graph, new Vertex("B", "RGD Meerzorg"));

        System.out.println("\n");

    }

}
