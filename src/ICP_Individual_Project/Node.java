package ICP_Individual_Project;

/**
 * this file defines operations for the Node class
 * operations include constructor and accessor methods,
 * compareTo, equals, and solutionPath methods
 *
 * @author Richard Quayson
 */

import java.util.ArrayList;

/**
 * the node class extends Comparable to enable the sorting of Node objects
 */
public class Node implements Comparable<Node> {

    /**
     * instance variables
     */
    private int state;
    private Node parent;
    private int action;
    private double pathCost;


    /**
     * Constructor:
     * Build and initialise the objects of the Node class
     *
     * @param state AirportID
     * @param parent node object of the calling object
     * @param action AirportID
     * @param path_cost distance between the state of the calling Node and this node's state
     */
    public Node(int state, Node parent, int action, double path_cost) {
        this.state = state;
        this.parent = parent;
        this.action = action;
        this.pathCost = path_cost;
    }

    // overloaded constructor
    public Node(Integer state) {
        this.state = state;
        this.parent = null;
        this.action = 0;
        this.pathCost = 0;
    }

    /**
     * returns the state of this node object
     * @return this.state
     */
    public int getState() {
        return this.state;
    }

    /**
     * returns the parent node of this node object
     * @return this.parent
     */
    public Node getParent() {
        return this.parent;
    }

    /**
     * returns the action of this node object
     * @return this.action
     */
    public int getAction() {
        return this.action;
    }

    /**
     * returns the path cost of this node object
     * @return this.pathCost
     */
    public double getPathCost() {
        return this.pathCost;
    }


    /**
     * returns the string representation of a node class
     * @return String
     */
    @Override
    public String toString() {
        if (this.parent != null) {
            return "Node {" +
                    "state=" + state +
                    ", parent=" + parent.getState() +
                    ", action=" + action +
                    ", path_cost=" + pathCost +
                    '}';
        } else {
            return "Node {" +
                    "state=" + state + '}';
        }
    }


    /**
     * checks if two node objects are equal
     * returns true if the two nodes have the same state
     * @param o the node to compare calling node object with
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return getState() == node.getState();
    }


    /**
     * returns the Solution of a given node
     * a Solution consists of the state sequence from the
     * initial state to the goal state of a given problem
     * @return Solution
     */
    public Solution solutionPath() {
        ArrayList<Integer> stateSequence = new ArrayList<>();
        stateSequence.add(0, this.state);
        double finalPathCost = this.getPathCost();

        Node node = this.parent;
        while (!(node == null)) {
            stateSequence.add(0, node.getState());
            node = node.getParent();
        }
        return new Solution(stateSequence, finalPathCost);
    }

    /**
     * returns an int based on whether a node has a greater, equal or lower
     * past cost than the node it is being compared with
     * @param node the node to compare calling node object with
     * @return int (1,-1,0)
     */
    @Override
    public int compareTo(Node node) {
        return Double.compare(this.getPathCost(), node.getPathCost());
    }
}