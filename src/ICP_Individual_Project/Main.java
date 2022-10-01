package ICP_Individual_Project;

/**
 * this file defines operations for the Main class
 * operations include, instantiating a hashMap for the
 * airport data, airline data, and route data, getAirportByID
 *
 * @author Richard Quayson
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Main {

    /**
     * instance variables
     */
    public static HashMap<Integer, Airport> airportData = new HashMap<>();
    public static HashMap<Integer, Airline> airlineData = new HashMap<>();
    public static HashMap<Integer, ArrayList<Route>> routeData = new HashMap<>();


    /**
     * method reads the airport file, create objects of them
     * and store the airport ID as key and the entire airport object as the value
     */
    public static void instantiateAirportHashMap() {
        ArrayList<String[]> airportAttributeArray = new
                ArrayList<>(readWriteFile.readFile("src/airports.csv"));
        for (String[] airportArray : airportAttributeArray) {
            Airport airportObject = createObjects.createAirportObject(airportArray);
            airportData.put(airportObject.getAirportID(), airportObject);
        }
    }


    /**
     * method reads the airline file, create objects of them
     * and store the airline ID as key and the entire airline object as the value
     */
    public static void instantiateAirlineHashMap() {
        ArrayList<String[]> airlineAttributeArray = new
                ArrayList<>(readWriteFile.readFile("src/airlines.csv"));
        for (String[] airlineArray : airlineAttributeArray) {
            Airline airlineObject = createObjects.createAirlineObject(airlineArray);
            airlineData.put(airlineObject.getAirlineID(), airlineObject);
        }
    }


    /**
     * method reads the airport file, create objects of them
     * checks if the route is valid
     * checks if the key (source Airport ID) already exists
     * if it exists, get the current value and add the route object to it
     * else, create a new arraylist for the values and add the route object to it
     * and put it in the map with the source Airport ID as key
     */
    public static void instantiateRouteHashMap() {
        ArrayList<String[]> routeAttributeArray = new
                ArrayList<>(readWriteFile.readFile("src/routes.csv"));
        for (String[] stringRoute: routeAttributeArray) {
            Route route = createObjects.createRouteObject(stringRoute);
            if (route.isValidRoute()) {
                if (airlineData.get(route.getAirlineID()).getActiveStatus().equalsIgnoreCase("Y")) {
                    if (routeData.get(route.getSourceAirportID()) == null) {
                        ArrayList<Route> routeArray = new ArrayList();
                        routeArray.add(route);
                        routeData.put(route.getSourceAirportID(), routeArray);
                    }
                    else {
                        ArrayList<Route> value = routeData.get(route.getSourceAirportID());
                        value.add(route);
                    }
                }
            }
        }
    }


    /**
     * returns an Array list of airport IDs whose city and location
     * equals the city and location provided as arguments
     * @param city the city the airport is in
     * @param country the country the airport is in
     * @return ArrayList<Integer>
     */
    protected static ArrayList<Integer> getAirportIDByCityCountry(String city, String country) {
        ArrayList<Integer> airportIDArray = new ArrayList<>();
        for (Airport object: airportData.values()) {
            if (object.getCity().equalsIgnoreCase(city) &&
                    object.getCountry().equalsIgnoreCase(country)) {
                airportIDArray.add(object.getAirportID());
            }
        }
        return airportIDArray;
    }


    /**
     * returns the distance between two airports
     * @param sourceAirportID the airport ID of the source
     * @param destinationAirportID the airport ID of the destination
     * @return double (distance in km)
     */
    public static double getDistance(int sourceAirportID, int destinationAirportID) {

        Airport sourceAirport = airportData.get(sourceAirportID);
        Airport destinationAirport = airportData.get(destinationAirportID);
        return Haversine.distance(sourceAirport.getLatitude(), sourceAirport.getLongitude(),
                destinationAirport.getLatitude(), destinationAirport.getLongitude());
    }


    /**
     * main method
     * @param args arguments
     */
    public static void main(String[] args) {

        // instantiate the data
        instantiateAirportHashMap();
        instantiateAirlineHashMap();
        instantiateRouteHashMap();

        // arraylist for returned valid paths
        ArrayList<Solution> validPaths = new ArrayList<>();

        // read the user input file
        ArrayList<String[]> problemData = new ArrayList<>(readWriteFile.readFile(
                "src/ICP_Individual_Project/accra-winnipeg"));

        // get the source city and country
        String[] sourceCityCountry = problemData.get(0);
        String sourceCity = sourceCityCountry[0].trim();
        String sourceCountry = sourceCityCountry[1].trim();
        ArrayList<Integer> sourceAirportIDs = getAirportIDByCityCountry(sourceCity, sourceCountry);

        // get the destination city and country
        String[] destinationCityCountry = problemData.get(1);
        String destinationCity = destinationCityCountry[0].trim();
        String destinationCountry = destinationCityCountry[1].trim();
        ArrayList<Integer> destinationAirportIDs = getAirportIDByCityCountry(destinationCity, destinationCountry);

        // loop through every source and destination airports
        // compute the valid paths and append to arraylist
        for (Integer sourceAirportID: sourceAirportIDs) {
            for (Integer destinationAirportID: destinationAirportIDs) {
                AirplaneRoutePlanning airRouteProblem =
                        new AirplaneRoutePlanning(sourceAirportID, destinationAirportID, routeData);
                Solution validPath = SearchAlgorithm.UniformCostSearch(airRouteProblem);
                if (validPath != null) {
                    validPaths.add(validPath);
                }
            }
        }

        // sort the arraylist and retrieve the path with the shortest path cost
        // write the information to the output file
        Collections.sort(validPaths);
        Solution optimalPath = validPaths.get(0);
        StringBuilder data = optimalPath.createSolutionString();
        String fileName = "src/ICP_Individual_Project/" +
                sourceCity.toLowerCase() + "-" + destinationCity.toLowerCase() + "-output";
        readWriteFile.writeFile(fileName, data);


        /**
         * uncomment to test
         */

//        createObjects.printExtremeAirportCases();

//        System.out.println("\nSource Airport IDs: " + sourceAirportIDs);
//        System.out.println("Destination Airport IDs: " + destinationAirportIDs);
//        System.out.println("Valid paths are: ");
//        for (Solution validPath: validPaths) {
//            System.out.println(validPath);
//        }
    }
}