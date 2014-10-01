package treesAndGraphs.ctci.Q2;

import java.util.LinkedList;

/*
 * 4.2 Given a directed graph, design an algorithm to find out whether there is
 * a route between two nodes
 */
public class DirectedGraphRoute {

    public enum State {
        Unvisited, Visiting, Visited;
    }

    public boolean routeBFS(Graph g, Node n1, Node n2) {
        if (n1 == n2) {
            return true;
        }
        LinkedList<Node> queue = new LinkedList<Node>();

        for (Node n : g.getNodes()) {
            n.state = State.Unvisited;
        }

        queue.add(n1);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr != null) {
                curr.state = State.Visiting;
                for (Node child : curr.getAdjacent()) {
                    if (child.state == State.Unvisited) {
                        if (child == n2) {
                            return true;
                        } else {
                            queue.add(child);
                            child.state = State.Visiting;
                        }
                    }
                }
            }
            curr.state = State.Visited;
        }
        return false;
    }

    // TODO verify this one
    public boolean routeDFS(Graph g, Node n1, Node n2) {
        if (n1 == n2) {
            return true;
        }
        for (Node child : n1.getAdjacent()) {
            if (child.state == State.Unvisited) {
                if (routeDFS(g, child, n2) == true) {
                    return true;
                }
            }
        }
        n1.state = State.Visited;
        return false;
    }
}
