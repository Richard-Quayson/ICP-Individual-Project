//package ICP_Individual_Project;
//
//import java.io.*;
//import java.util.ArrayList;
//
//public class Test {
//
//    public static ArrayList<Route> routeData;
//    public static void createRouteMap (String filename) {
//
//        try {
//            File file = new File(filename);
//            BufferedReader read = new BufferedReader(new FileReader(file));
//            String line;
//            while ((line = read.readLine()) != null) {
//                String[] routeArray = line.split(",");
//                try {
//                    Route routeObj = new Route (
//                            routeArray[0],
//                            Integer.parseInt(routeArray[1]),
//                            routeArray[2],
//                            Integer.parseInt(routeArray[3]),
//                            routeArray[4],
//                            Integer.parseInt(routeArray[5]),
//                            routeArray[6],
//                            Integer.parseInt(routeArray[5]),
//                            routeArray[routeArray.length - 1]
//                    );
//                    routeData.add(routeObj);
//                } catch (NumberFormatException ne) {
//                    System.out.println(ne.getMessage());
//                }
//            }
//        } catch (FileNotFoundException fe) {
//            System.out.println(fe.getMessage());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public ArrayList<Route> actions(int state) {
//        ArrayList<Route> possibleRoutes = new ArrayList<>();
//        for (Route route: map) {
//            if (route.getSourceAirportID() == state) {
//                possibleRoutes.add(route);
//            }
//        }
//        return possibleRoutes;
//    }
//}