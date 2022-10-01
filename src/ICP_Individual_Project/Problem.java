package ICP_Individual_Project;

/**
 * this file defines operations for the abstract generic Problem class
 *
 * @author Richard Quayson
 */

import java.util.ArrayList;

public class Problem<G> {

    /**
     * Generic instance variables
     */
    public final G initialState;
    public final G goalState;


    /**
     * Constructor:
     * Build and initialise the objects of the abstract Problem class
     *
     * @param initState (the initial state of the problem)
     * @param goalState (the goal state of the problem)
     */
    public Problem(G initState, G goalState) {
        this.initialState = initState;
        this.goalState = goalState;
    }


    /**
     * returns whether a given state is the goal state
     * @param state (the state of the problem)
     * @return boolean
     */
    public boolean goalTest(G state) {
        return (this.goalState == state);
    }


    /**
     * abstract methods that always returns null
     * @param state (the state from which certain actions will be valid)
     * @return null
     */
    public ArrayList<G> actions(G state) {
        return null;
    }
}