package ICP_Individual_Project;

/**
 * this file defines operations for the Route class
 * operations include constructor and accessor methods,
 * an implementation of the isValidRoute method
 *
 * @author Richard Quayson
 */

/**
 * this class implements the Routable interface
 * to determine whether a given route is valid
 */
public class Route implements Routable {

    /**
     * Instance variables
     */
    private final String airlineCode;
    private final int airlineID;
    private final String sourceAirportCode;
    private final int sourceAirportID;
    private final String destinationAirportCode;
    private final int destinationAirportID;
    private final String codeShare;
    private final int stops;
    private final String equipment;


    /**
     * Constructor:
     * Build and initialise the objects of the Route class
     *
     * @param airlineCode 2-letter IATACode or 3-letter ICAOCode of the airline
     * @param airlineID the unique openFlights identifier for the airline
     * @param sourceAirportCode 3-letter IATACode or 4-letter ICAOCode of the source airport
     * @param sourceAirportID the unique openFlights identifier for the source airport
     * @param destinationAirportCode 3-letter IATACode or 4-letter ICAOCode of the destination airport
     * @param destinationAirportID the unique openFlights identifier for the destination airport
     * @param codeShare "Y" if this flight is not operated by ICP_Individual_Project.Airline, but another carrier
     * @param stops the number of stops on this flight ("0" for direct flight)
     * @param equipment 3-letter codes for plane type(s) generally used on this flight
     */
    public Route(String airlineCode, int airlineID, String sourceAirportCode, int sourceAirportID,
                 String destinationAirportCode, int destinationAirportID,
                 String codeShare, int stops, String equipment) {
        this.airlineCode = airlineCode;
        this.airlineID = airlineID;
        this.sourceAirportCode = sourceAirportCode;
        this.sourceAirportID = sourceAirportID;
        this.destinationAirportCode = destinationAirportCode;
        this.destinationAirportID = destinationAirportID;
        this.codeShare = codeShare;
        this.stops = stops;
        this.equipment = equipment;
    }

    /**
     * returns the attributes of a given route
     * @return string representation of all attributes of a route object
     */
    @Override
    public String toString() {
        return "Route {" +
                "airlineCode='" + airlineCode + '\'' +
                ", airlineID=" + airlineID +
                ", sourceAirportCode='" + sourceAirportCode + '\'' +
                ", sourceAirportID=" + sourceAirportID +
                ", destinationAirportCode='" + destinationAirportCode + '\'' +
                ", destinationAirportID=" + destinationAirportID +
                ", codeShare='" + codeShare + '\'' +
                ", stops=" + stops +
                ", equipment='" + equipment + '\'' +
                '}';
    }

    /**
     * returns the airline's code
     * @return this.airlineCode
     */
    public String getAirlineCode() {
        return this.airlineCode;
    }

    /**
     * returns the airline's ID
     * @return
     */
    public int getAirlineID() {
        return this.airlineID;
    }

    /**
     * returns the airport code of the source airport
     * @return this.sourceAirportCode
     */
    public String getSourceAirportCode() {
        return this.sourceAirportCode;
    }

    /**
     * returns the airport ID of the source airport
     * @return this.sourceAirportID
     */
    public int getSourceAirportID() {
        return this.sourceAirportID;
    }

    /**
     * returns the airport code of the destination airport
     * @return this.destinationAirportCode
     */
    public String getDestinationAirportCode() {
        return this.destinationAirportCode;
    }

    /**
     * returns the airport ID of the destination airport
     * @return this.destinationAirportID
     */
    public int getDestinationAirportID() {
        return this.destinationAirportID;
    }

    /**
     * returns the number of stops the airline will make before reaching the destination airport
     * @return this.stops
     */
    public int getStops() {
        return this.stops;
    }

    /**
     * implements the isValidRoute method of the Routable interface
     * and returns whether a given route is valid
     * @return boolean
     */
    @Override
    public boolean isValidRoute() {
        if (this.getSourceAirportID() != 0 && this.getDestinationAirportID() != 0)
            return true;
        return false;
    }
}