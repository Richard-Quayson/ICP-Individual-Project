package ICP_Individual_Project;

/**
 * this file defines operations for the Airline class
 * operations include constructor and accessor methods
 *
 * @author Richard Quayson
 */


public class Airline {

    /**
     * Instance variables
     */
    private final int airlineID;
    private final String airlineName;
    private final String alias;
    private final String IATACode;
    private final String ICAOCode;
    private final String callSign;
    private final String country;
    private final String activeStatus;

    /**
     * Constructor:
     * Build and initialise the objects of the Airline class
     *
     * @param airlineID the unique openFlights identifier for the airline
     * @param airlineName the name of the airline
     * @param alias the alias of the airline
     * @param IATACode 2-letter IATACode for the airline
     * @param ICAOCode 3-letter ICAOCode for the airline
     * @param callSign the airline call sign
     * @param country the country where the airport is located
     * @param activeStatus "Y" if the airline is or has until recently been operational, "N" if defunct
     */
    public Airline(int airlineID, String airlineName, String alias, String IATACode,
                   String ICAOCode, String callSign, String country, String activeStatus) {
        this.airlineID = airlineID;
        this.airlineName = airlineName;
        this.alias = alias;
        this.IATACode = IATACode;
        this.ICAOCode = ICAOCode;
        this.callSign = callSign;
        this.country = country;
        this.activeStatus = activeStatus;
    }

    /**
     * returns the attributes of a given airline object
     * @return the string representation of all the attribute an airline object
     */
    @Override
    public String toString() {
        return "Airline {" +
                "airlineID='" + airlineID + '\'' +
                ", airlineName='" + airlineName + '\'' +
                ", alias='" + alias + '\'' +
                ", IATACode='" + IATACode + '\'' +
                ", ICAOCode='" + ICAOCode + '\'' +
                ", callSign='" + callSign + '\'' +
                ", country='" + country + '\'' +
                ", activeStatus='" + activeStatus + '\'' +
                '}';
    }

    /**
     * returns the airline's ID
     * @return this.airlineID
     */
    public int getAirlineID() {
        return this.airlineID;
    }

    /**
     * returns the name of the airline
     * @return this.airline
     */
    public String getAirlineName() {
        return this.airlineName;
    }

    /**
     * returns the IATACode of the airline
     * @return this.IATACode
     */
    public String getIATACode() {
        return this.IATACode;
    }

    /**
     * returns the ICAOCode of the airline
     * @return this.ICAOCode
     */
    public String getICAOCode() {
        return this.ICAOCode;
    }

    /**
     * returns the name of the country where the airline is operational
     * @return this.country
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * returns whether the airline has been operational recently, Y/N
     * @return this.activeStatus
     */
    public String getActiveStatus() {
        return activeStatus;
    }
}