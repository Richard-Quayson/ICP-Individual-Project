package ICP_Individual_Project;

/**
 * this file defines operations for the Airport class
 * operations include the constructor and accessor methods
 *
 * @author Richard Quayson
 */


public class Airport {

    /**
     * Instance variables
     */
    private final int airportID;
    private final String airportName;
    private final String city;
    private final String country;
    private final String IATACode;
    private final String ICAOCode;
    private final double latitude;
    private final double longitude;
    private final double altitude;
    private final double timezone;
    private final String DST;
    private final String Tz;
    private final String type;
    private final String sourceOfData;


    /**
     * Constructor:
     * Build and initialise the objects of the Airport class
     *
     * @param airportID the unique openFlights identifier for the airport
     * @param airportName name of the airport
     * @param city main city served by the airport
     * @param country country where the airport is located
     * @param IATACode International Air Transport Association 3-letter code for the airport
     * @param ICAOCode International Civil Aviation Organization 4-letter code for tha airport
     * @param latitude airport's latitude position in degrees
     * @param longitude airport's longitude position in degrees
     * @param altitude airport's altitude in feet
     * @param timezone hours offset from UTC
     * @param DST Daylight Savings Time
     * @param tz Timezone
     * @param type type of the airport
     * @param sourceOfData source of this data
     */
    public Airport(int airportID, String airportName, String city, String country,
                   String IATACode, String ICAOCode, double latitude, double longitude,
                   double altitude, double timezone, String DST, String tz,
                   String type, String sourceOfData) {
        this.airportID = airportID;
        this.airportName = airportName;
        this.city = city;
        this.country = country;
        this.IATACode = IATACode;
        this.ICAOCode = ICAOCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.timezone = timezone;
        this.DST = DST;
        this.Tz = tz;
        this.type = type;
        this.sourceOfData = sourceOfData;
    }

    public Airport() {
        this.airportID = 0;
        this.airportName = "";
        this.city = "";
        this.country = "";
        this.IATACode = "";
        this.ICAOCode = "";
        this.latitude = 0.0;
        this.longitude = 0.0;
        this.altitude = 0.0;
        this.timezone = 0.0;
        this.DST = "";
        this.Tz = "";
        this.type = "";
        this.sourceOfData = "";
    }

    /**
     * returns string representation of the attributes of a given airport
     * @return attributes of the airport object
     */
    @Override
    public String toString() {
        return "Airport {" +
                this.airportID +
                ", airportName='" + this.airportName + '\'' +
                ", city='" + this.city + '\'' +
                ", country='" + this.country + '\'' +
                ", IATACode='" + this.IATACode + '\'' +
                ", ICAOCode='" + this.ICAOCode + '\'' +
                ", latitude=" + this.latitude +
                ", longitude=" + this.longitude +
                ", altitude=" + this.altitude +
                ", timezone=" + this.timezone +
                ", DST=" + this.DST +
                ", Tz='" + this.Tz + '\'' +
                ", type='" + this.type + '\'' +
                ", sourceOfData='" + this.sourceOfData + '\'' +
                '}';
    }

    /**
     * returns the airport's ID
     * @return this.airportID
     */
    public int getAirportID() {
        return this.airportID;
    }

    /**
     * returns the airport's name
     * @return this.airportName
     */
    public String getAirportName() {
        return this.airportName;
    }

    /**
     * returns the main city served by the airport
     * @return this.city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * returns the country where the airport is located
     * @return this.country
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * returns the International Air Transport Association code for the airport
     * @return this.IATACode
     */
    public String getIATACode() {
        return this.IATACode;
    }

    /**
     * returns the International Civil Aviation Organization code for tha airport
     * @return this.ICAOCode
     */
    public String getICAOCode() {
        return this.ICAOCode;
    }

    /**
     * returns the airport's latitude position in degrees
     * @return this.latitude
     */
    public double getLatitude() {
        return this.latitude;
    }

    /**
     *  returns the airport's longitude position in degrees
     * @return this.longitude
     */
    public double getLongitude() {
        return this.longitude;
    }

}