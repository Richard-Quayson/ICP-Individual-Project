package ICP_Individual_Project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * this file implements the uniform cost search algorithm
 * @author Richard Quayson
 */

public class SearchAlgorithm {

    public static Solution UniformCostSearch(AirplaneRoutePlanning problem) {
        System.out.println("\nAbout to do Uniform Cost Search on problem: ");
        PriorityQueue<Node> frontier = new PriorityQueue<>();
        HashSet<Integer> explored = new HashSet<>();

        Node initNode = new Node(problem.getInitialState());
        frontier.add(initNode);

        while (frontier.size() > 0) {
            Node node = frontier.poll();

            if (problem.goalTest(node.getState())) {
                System.out.println("Found a solution: " + node);
                return node.solutionPath();
            } else {
                explored.add(node.getState());
                System.out.println("Expanding: " + node);

                try {
                    ArrayList<Route> neighbours = problem.actions(node.getState());

                    System.out.println("Available destination airports: " + neighbours);
                    for (Route route : neighbours) {
                        try {
                            Integer newState = route.getDestinationAirportID();
                            double pathCost = node.getPathCost() + Main.getDistance(node.getState(), newState);
                            Node child = new Node(newState, node, newState, pathCost);

                            if (!explored.contains(child.getState()) && !frontier.contains(child)) {
                                frontier.add(child);
                            } else if (frontier.contains(child)) {
                                double oldCost = frontier.peek().getPathCost();
                                if (oldCost > child.getPathCost()) {
                                    frontier.remove(child);
                                    frontier.add(child);
                                }
                            }
                        } catch (NullPointerException npe) {
                            System.out.println("NullPointerException caught: " + npe.getMessage());
                            System.out.println("Destination airport cannot be null.");
                        }
                    }
                } catch (NullPointerException npe) {
                    System.out.println("NullPointerException caught: " + npe.getMessage());
                    System.out.println("No neighbours found.");
                }
            }
        }
        System.out.println("No valid route exist!!");
        return null;
    }
}