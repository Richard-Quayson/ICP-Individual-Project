package ICP_Individual_Project;

/**
 * this file defines the operations for the createObjects class
 * operations include createAirportObject, createAirlineObject and createRouteObject
 *
 * @author Richard Quayson
 */

import java.util.ArrayList;

/**
 * this class implements methods that help to
 * create objects of the various classes in the package
 */
class createObjects {

    /**
     * takes a String array representation of the attributes
     * of an airport object, creates and returns an Airport object
     *
     * @param airportArray String array containing the attribute info for an airport object
     * @return Airport object (instance)
     */
    public static Airport createAirportObject(String[] airportArray) {

        int airportID = 0;
        double latitude = 0.0;
        double longitude = 0.0;
        double altitude = 0.0;
        double timezone = 0.0;
        try {
            airportID = Integer.parseInt(airportArray[0]);
            latitude = Double.parseDouble(airportArray[6]);
            longitude = Double.parseDouble(airportArray[7]);
            altitude = Double.parseDouble(airportArray[8]);
            timezone = Double.parseDouble(airportArray[9]);
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException caught: " + nfe.getMessage());
            System.out.println("Argument must be a number");
        }

        String airportName = airportArray[1];
        String city = airportArray[2];
        String country = airportArray[3];
        String IATACode = airportArray[4];
        String ICAOCode = airportArray[5];
        String DST = airportArray[10];
        String Tz = airportArray[11];
        String type = airportArray[12];
        String sourceOfData = airportArray[13];

        return new Airport (
                airportID, airportName, city, country, IATACode,
                ICAOCode, latitude, longitude, altitude, timezone,
                DST, Tz, type, sourceOfData
        );
    }

    /**
     * prints the number of extreme cases in the airport CSV file and the results for later cleanup
     * (an extreme case is a case of extra comma(s) in any of the field and is identified by the
     * length of string array after splitting a row (on commas) in the airports.csv file.
     * a normal airport object is expected to have an array length of 14,
     * if more, then it contains extra commas and is regarded as extreme)
     *
     * (to test this,
     * uncomment the extremeCases array and return it in the readFile method of the readWriteFile class)
     *
     * this method resulted in the creation of the gracefullyHandleAirportObjectCreation
     */
    static void printExtremeAirportCases() {
        ArrayList<String[]> results =
                new ArrayList<>(readWriteFile.readFile("ICP_Individual_Project/src/airports.csv"));
        System.out.println("Number of Extreme cases: " + results.size());
        for (String[] array: results) {
            for (String attribute: array) {
                System.out.print(attribute + " ");
            }
            System.out.println();
        }
    }

    /**
     * printExtremeAirportCases returned:
     * extreme cases in airport name (extra commas in the airport name)
     * airportID: 641, 657, 658, 664, 3256, 3340, 4345, 4351, 5582, 5583, 5589, 6898, 13714
     *
     * extreme cases in city (extra commas in the city)
     * airportID: 5562, 5674, 5675, 5881
     *
     * this method relies on the information above to handle the extra commas
     * if extreme case in airportName, add the next value after airportName to value at airportName index
     * if extreme case in city, add the next value after city to value at city index
     *
     * @param stringAirportArray a String array representation of an extreme case
     * @return newStringArray (the cleaned-up array of the extreme case)
     */
    protected static String[] gracefullyHandleAirportObjectCreation(String[] stringAirportArray) {

        String[] newStringArray;

        if (stringAirportArray[0].equals(5562) || stringAirportArray[0].equals(5674) ||
                stringAirportArray[0].equals(5675) || stringAirportArray[0].equals(5881)) {

            String airportID = stringAirportArray[0];
            String airportName = stringAirportArray[1];
            String city = stringAirportArray[2] + stringAirportArray[3];
            String country = stringAirportArray[4];
            String IATACode = stringAirportArray[5];
            String ICAOCode = stringAirportArray[6];
            String latitude = stringAirportArray[7];
            String longitude = stringAirportArray[8];
            String altitude = stringAirportArray[9];
            String timezone = stringAirportArray[10];
            String DST = stringAirportArray[11];
            String Tz = stringAirportArray[12];
            String type = stringAirportArray[13];
            String sourceOfData = stringAirportArray[14];

            newStringArray = new String[]{airportID, airportName, city, country, IATACode, ICAOCode,
                    latitude, longitude, altitude, timezone, DST, Tz, type, sourceOfData};
        } else {
            String airportID = stringAirportArray[0];
            String airportName = stringAirportArray[1] + stringAirportArray[2];
            String city = stringAirportArray[3];
            String country = stringAirportArray[4];
            String IATACode = stringAirportArray[5];
            String ICAOCode = stringAirportArray[6];
            String latitude = stringAirportArray[7];
            String longitude = stringAirportArray[8];
            String altitude = stringAirportArray[9];
            String timezone = stringAirportArray[10];
            String DST = stringAirportArray[11];
            String Tz = stringAirportArray[12];
            String type = stringAirportArray[13];
            String sourceOfData = stringAirportArray[14];

            newStringArray = new String[]{airportID, airportName, city, country, IATACode, ICAOCode,
                    latitude, longitude, altitude, timezone, DST, Tz, type, sourceOfData};
        }

        return newStringArray;
    }


    /**
     * takes a String array representation of the attributes
     * of an airline object, creates and returns an Airline object
     *
     * @param airlineArray a String array containing the attributes' info for an airline object
     * @return Airline object (instance)
     */
    public static Airline createAirlineObject(String[] airlineArray) {

        int airlineID = 0;
        try {
            airlineID = Integer.parseInt(airlineArray[0]);
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException caught: " + nfe.getMessage());
            System.out.println("Argument must be an int.");
        }

        String airlineName = airlineArray[1];
        String alias = airlineArray[2];
        String IATACode = airlineArray[3];
        String ICAOCode = airlineArray[4];
        String callSign = airlineArray[5];
        String country = airlineArray[6];
        String activeStatus = airlineArray[7];

        return new Airline (
                airlineID, airlineName, alias, IATACode,
                ICAOCode, callSign, country, activeStatus
        );
    }

    /**
     * takes a String array representation of the attributes
     * of a route object, creates and returns a route object
     *
     * @param routeArray String array containing the attributes' info for a route object
     * @return Route object (instance)
     */
    public static Route createRouteObject(String[] routeArray) {

        int airlineID = 0;
        int sourceAirportID = 0;
        int destinationAirportID = 0;
        int stops = 0;

        try {
            airlineID = Integer.parseInt(routeArray[1]);
            sourceAirportID = Integer.parseInt(routeArray[3]);
            destinationAirportID = Integer.parseInt(routeArray[5]);
            stops = Integer.parseInt(routeArray[7]);
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException caught: " + nfe.getMessage());
            System.out.println("Argument must be an int.");
        } catch (ArrayIndexOutOfBoundsException aiob) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + aiob.getMessage());
            aiob.printStackTrace();
        }

        String airlineCode = routeArray[0];
        String sourceAirportCode = routeArray[2];
        String destinationAirportCode = routeArray[4];
        String codeShare = routeArray[6];
        String equipment = routeArray[routeArray.length - 1];

        return new Route(
                airlineCode, airlineID, sourceAirportCode, sourceAirportID,
                destinationAirportCode, destinationAirportID, codeShare, stops, equipment
        );
    }
}