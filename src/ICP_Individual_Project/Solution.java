package ICP_Individual_Project;

/**
 * this file defines operations for the Solution class
 * operations include constructor and accessor methods,
 * an implementation of the compareTo method of the Comparable interface,
 * and a createSolutionString method
 *
 * @author Richard Quayson
 */

import java.util.ArrayList;

/**
 * this class implements the Comparable interface
 * to be used by the Collections class for sorting
 */
class Solution implements Comparable<Solution> {

    /**
     * instance variables
     */
    ArrayList<Integer> stateSequence;
    double pathCost;

    /**
     * Constructor:
     * Build and initialise the objects of the Solution class
     *
     * @param stateSequence the sequence of actions from the initial state to the goal state
     * @param pathCost the distance between the stateSequence
     */
    public Solution(ArrayList<Integer> stateSequence, double pathCost) {
        this.stateSequence = stateSequence;
        this.pathCost = pathCost;
    }


    /**
     * returns the state sequence of a given Solution object
     * @return this.stateSequence
     */
    public ArrayList<Integer> getStateSequence() {
        return this.stateSequence;
    }

    /**
     * returns the path cost of a given Solution object
     * @return this.pathCost
     */
    public double getPathCost() {
        return this.pathCost;
    }

    /**
     * returns the String representation of a Solution object
     * @return String
     */
    @Override
    public String toString() {
        return "Solution {" +
                "stateSequence=" + stateSequence +
                ", pathCost=" + pathCost +
                '}';
    }

    /**
     * loops through the state sequence of a given Solution object and
     * retrieves the possible routes for the given state and
     * checks if a particular route has the same destination airport as the next state in the stateSequence
     * if true, creates a string of the airlineCode, sourceAirportCode, destinationAirportCode, total flights,
     * total additional stops, total distance and the optimality criteria
     * @return String
     */
    public StringBuilder createSolutionString() {
        StringBuilder solutionString = new StringBuilder();

        int count = 0;
        int totalStops = 0;

        for (Integer airportID: this.getStateSequence()) {
            for (Route route: Main.routeData.get(airportID)) {
                if (count < (this.getStateSequence().size() -1)) {
                    if (route.getDestinationAirportID() == this.getStateSequence().get(count + 1)) {
                        solutionString.append((count + 1) + ". " +
                                route.getAirlineCode() + " from " +
                                Main.airportData.get(route.getSourceAirportID()).getIATACode() + " to " +
                                Main.airportData.get(route.getDestinationAirportID()).getIATACode() + " " +
                                route.getStops() + " stops.\n"
                        );
                        count++;
                        totalStops += route.getStops();
                    }
                }
            }
        }

        solutionString.append("\nTotal flights: ").append(this.getStateSequence().size() - 1);
        solutionString.append("\nTotal additional stops: ").append(totalStops);
        solutionString.append("\nTotal distance: ").append(this.getPathCost()).append(" km");
        solutionString.append("\nOptimality criteria: distance covered by route");

        return solutionString;
    }

    /**
     * implements the compareTo method of the Comparable interface
     * compares a Solution object based on their path cost
     * @param sol the Solution object to compare the calling Solution object with
     * @return int (1,-1,0)
     */
    @Override
    public int compareTo(Solution sol) {
        return Double.compare(this.getPathCost(), sol.getPathCost());
    }
}