package GraphSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class BFSDFS {

    private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();
    private ArrayList<Integer> vlist = new ArrayList<>();

    public static void main(String args[]) {
        int[] vertices = {2, 7, 8, 10, 9};
        BFSDFS graph = new BFSDFS();

        graph.addEdge(2, 7);
        graph.addEdge(10, 9);
        graph.addEdge(7, 8);
        graph.addEdge(2, 8);
        graph.addEdge(2, 9);
        graph.addEdge(10, 7);


        System.out.println(graph.hasPathBFS(2, 10));


    }

    private Node getNode(int id) {
        return this.nodeLookup.get(id);
    }

    private void addEdge(int source, int dest) {

        Node n1, n2;
        if (!this.nodeLookup.containsKey(source)) {
            this.nodeLookup.put(source, new Node(source));
            n1 = this.nodeLookup.get(source);
        } else {
            n1 = this.nodeLookup.get(source);
        }

        if (!this.nodeLookup.containsKey(dest)) {
            this.nodeLookup.put(dest, new Node(dest));
            n2 = this.nodeLookup.get(dest);
        } else {
            n2 = this.nodeLookup.get(dest);
        }

        n1.adjacent.add(n2);
        n2.adjacent.add(n1);

    }


    public boolean hasPathDFS(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        HashSet<Integer> visited = new HashSet<Integer>();
        return hasPathDFS(s, d, visited);
    }

    public boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited) {
        if (visited.contains(source.id)) {
            return false;
        }

        visited.add(source.id);

        if (source == destination) {
            return true;
        }

        for (Node child : source.adjacent) {
            if (hasPathDFS(child, destination, visited)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPathBFS(int source, int dest) {
        if (this.nodeLookup.containsKey(source) && this.nodeLookup.containsKey(dest))
            return hasPathBFS(this.nodeLookup.get(source), this.nodeLookup.get(dest));
        return false;
    }

    public boolean hasPathBFS(Node source, Node destination) {
        LinkedList<Node> nextToVisit = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        nextToVisit.add(source);

        while (!nextToVisit.isEmpty()) {
            Node node = nextToVisit.removeFirst();

            if (node == destination) {
                return true;
            }

            if (visited.contains(node.id)) {
                continue;
            }

            visited.add(node.id);

            for (Node child : node.adjacent) {
                nextToVisit.add(child);
            }
        }
        return false;
    }

    public static class Node {

        LinkedList<Node> adjacent = new LinkedList<>();
        private int id;

        private Node(int id) {
            this.id = id;
        }
    }

}
