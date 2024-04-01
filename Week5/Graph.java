package Week5;

import java.util.*;

public class Graph<E> {

    static class Vertex<E> {
        E data;
        public Vertex(E data) {
            this.data = data;
        }
    }

    List<Vertex<E>> vertexs = new ArrayList<>();
    HashMap<Vertex<E>, LinkedList<Vertex<E>>> edges = new HashMap<>();
    

    public void addEdge(Vertex<E> from, Vertex<E> to) {
        if (!vertexs.contains(from)) {
            return;
        }
        if (edges.containsKey(from)) {
            LinkedList<Vertex<E>> edgeList = edges.get(from);
            edgeList.add(to);
            edges.put(from, edgeList); 
            return;
        } else {
            LinkedList<Vertex<E>> edgeList = new LinkedList<>();
            edgeList.add(to);
            edges.put(from, edgeList);
        }
    }

    public void addVertex(Vertex<E> vertex) {
        vertexs.add(vertex);
    }

    public void printGraph() {
        System.out.println("Graph");
        for (Vertex<E> vertex : vertexs) {
            if (edges.containsKey(vertex)) {
                for (Vertex<E> edge : edges.get(vertex)) {
                    System.out.println(vertex.data + " -> " + edge.data);
                }
            }
        }
    }

    private void BFSSearch() {
        Queue<Vertex<E>> queue = new LinkedList<>();
        List<Integer> visited = new ArrayList<>();
        queue.add(vertexs.get(0));
        while (!queue.isEmpty()) {
            Vertex<E> first = queue.poll();
            if (visited.contains(first.data)) {
                continue;
            }
            visited.add((Integer) first.data);
            System.out.println(first.data);
            LinkedList<Vertex<E>> listEdges = edges.get(first);
            if (listEdges == null) {
                continue;
            }
            listEdges.forEach(e -> {
                if (!visited.contains(e.data)) {
                    queue.add(e);
                }
            });
        }
    }

    public void BFS() {
        
    }





    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
        // creates 5 vertexes
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<Integer>(3);
        Vertex<Integer> v4 = new Vertex<Integer>(4);
        Vertex<Integer> v5 = new Vertex<Integer>(5);
        Vertex<Integer> v6 = new Vertex<Integer>(6);
        Vertex<Integer> v7 = new Vertex<Integer>(7);
        // add vertexes
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        graph.addVertex(v6);
        graph.addVertex(v7);

        // add edges
        graph.addEdge(v1, v2);
        graph.addEdge(v1, v3);
        graph.addEdge(v2, v4);
        graph.addEdge(v3, v5);
        graph.addEdge(v4, v5);
        graph.addEdge(v2, v1);
        graph.addEdge(v4, v6);
        graph.addEdge(v6, v7);
        graph.printGraph();
        System.out.println();
        graph.BFSSearch();


    }






    
}
