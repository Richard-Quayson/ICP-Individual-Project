package ICP_Individual_Project;

/**
 * the file defines the isValidRoute method for the Routable interface
 *
 * @author Richard Quayson
 */
public interface Routable {

    /*
     * Checks if the sourceAirportID and destinationAirportID
     * of this route object are both valid (not null or zero)
     * The implementor must ensure that
     *      (r.getDestinationID && r.getSourceAirportID)
     * is not null or zero (where r is a given route object).
     *
     * @param sourceAirportID
     * @return True or False
     */
    public boolean isValidRoute();
}