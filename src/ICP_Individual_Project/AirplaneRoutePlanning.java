package ICP_Individual_Project;

/**
 * this file defines operations for the AirplaneRoutePlanning class
 * operations include goalTest and actions
 *
 * @author Richard Quayson
 */

import java.util.ArrayList;
import java.util.HashMap;


/**
 * this class extends the Problem class and provides additional information
 * for the constructor and an implementation for the goalTest and actions method
 *
 * @param <G> generic data type
 */
public class AirplaneRoutePlanning<G> extends Problem<G> {

    /**
     * instance variables
     */
    private final int initialState;
    private final int goalState;
    public static HashMap<Integer, ArrayList<Route>> map;


    /**
     * Constructor:
     * Build and initialise the objects of this abstract class
     *
     * @param initState (the initial state of the flight)
     * @param goalState (the destination state of the fight)
     * @param map (the map of airports routes)
     */
    public AirplaneRoutePlanning(G initState, G goalState, HashMap<Integer, ArrayList<Route>> map) {
        super(initState, goalState);
        this.initialState = (int) initState;
        this.goalState = (int) goalState;
        AirplaneRoutePlanning.map = map;
    }

    /**
     * returns the initial state of the AirRoutePlanning problem
     * @return this.initialState
     */
    public int getInitialState() {
        return this.initialState;
    }

    /**
     * returns the goal states of the AirRoutePlanning problem
     * @return this.goalState
     */
    public int getGoalState() {
        return this.goalState;
    }

    /**
     * returns the map to be used for the search for the AirRoutePlanning problem
     * @return AirRoutePlanning.map
     */
    public HashMap<Integer, ArrayList<Route>> getMap() {
        return AirplaneRoutePlanning.map;
    }

    /**
     * checks whether a given state is the goal state
     * @param state current state (airport) the airplane is
     * @return boolean
     */
    public boolean goalTest(int state) {
        return (this.goalState == state);
    }

    /**
     * returns the route objects of the possible destination airports
     * the airplane can go from a given state
     *
     * @param state current state (airport) the airplane is
     * @return ArrayList<Route>
     */
    public ArrayList<Route> actions(int state) {
        return map.get(state);
    }

    /**
     * returns a string representation of a given AirRoutePlanning problem
     * @return String
     */
    @Override
    public String toString() {
        return "AirplaneRoutePlanning {" +
                "initialState=" + initialState +
                ", goalState=" + goalState +
                ", map=" + map +
                '}';
    }
}