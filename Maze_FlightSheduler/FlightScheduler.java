import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FlightScheduler {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner input = new Scanner(new File(args[0]));
		HashMap<String, Integer> airportToID = new HashMap<String, Integer>();
		HashMap<Integer, String> iDToAirport = new HashMap<Integer, String>();
		ArrayList<DirectedEdge> edges = new ArrayList<DirectedEdge>();
		HashMap<Integer, Integer> airportIDToConnectTime = new HashMap<Integer, Integer>();
		
		// read flight info
		while (input.hasNextLine()) {
			String[] flightData = input.nextLine().split(", ");
			
			if (!airportToID.containsKey(flightData[0])) {
				airportToID.put(flightData[0], airportToID.size());
			}
			if (!airportToID.containsKey(flightData[1])) {
				airportToID.put(flightData[1], airportToID.size());
			}
			//System.out.println(stringtoint);
			
			String origin = flightData[0];
			String dest = flightData[1];
			double depTime = Double.parseDouble(flightData[2]);
			double arrTime = Double.parseDouble(flightData[3]);

			edges.add(new DirectedEdge(airportToID.get(origin), airportToID.get(dest), depTime, arrTime));
		}
		input.close();
		//create mirror of airportToID
		for (String str : airportToID.keySet()) {
			iDToAirport.put(airportToID.get(str), str);
		}
		// read connectionTime info if given, format: <airport>, <connectTime in min>
		if (args.length > 1) {
			Scanner connectScan = new Scanner(new File(args[1]));
			while (connectScan.hasNextLine()) {
				String[] connectData = connectScan.nextLine().split(", ");
				
				String airport = connectData[0];
				int connectionTime = Integer.parseInt(connectData[1]);
				int airportID = airportToID.get(airport);
				airportIDToConnectTime.put(airportID, connectionTime);
				//System.out.println(airportIDToConnectTime);
			}
		}
		else { //default all connectTime to 30 min
			for (int iD : iDToAirport.keySet()) {
				airportIDToConnectTime.put(iD, 30);
			}
		}
		//System.out.println(airportIDToConnectTime); //delete
		String orig;
		String desti;
		int startTime;
		//user input
		Scanner inputU = new Scanner(System.in);
		System.out.print("Enter Origin: ");
		orig = inputU.next();
		System.out.print("Enter Destination: ");
		desti = inputU.next();
		System.out.print("Enter Departure Time: ");
		startTime = inputU.nextInt();
		
		//create graph
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(airportToID.size());
        for (DirectedEdge edge : edges) {
        	G.addEdge(edge);
        }
        int s = airportToID.get(orig);

        // compute shortest paths
        DijkstraSP sp = new DijkstraSP(G, s, startTime, airportIDToConnectTime);
        
        /*// print shortest paths DELETE LATER
        for (int t = 0; t < G.V(); t++) {
            if (sp.hasPathTo(t)) {
                //StdOut.printf("%d to %d (%.2f)  ", s, t, sp.distTo(t));
            	System.out.print(iDToAirport.get(s) + " to " + iDToAirport.get(t) + " " + (int)sp.distTo(t) + "  ");
                for (DirectedEdge e : sp.pathTo(t)) {
                    //StdOut.print(e + "   ");
                	System.out.print(iDToAirport.get(e.from()) + "->" + iDToAirport.get(e.to()) + 
                			" " + (int)e.depTime() + "->" + (int)e.arrTime() + ", ");
                }
                StdOut.println();
            }
            else {
                //StdOut.printf("%d to %d         no path\n", s, t);
            	System.out.print(iDToAirport.get(s) + " to " + iDToAirport.get(t) + " no path\n");
            }
        }*/
        
        System.out.println();
        //print shortest path from orig to dest
        int destInt = airportToID.get(desti);
        if (sp.hasPathTo(destInt)) {
            //StdOut.printf("%d to %d (%.2f)  ", s, t, sp.distTo(t));
        	System.out.print(iDToAirport.get(s) + " to " + iDToAirport.get(destInt) + " " + (int)sp.distTo(destInt) + "  ");
            for (DirectedEdge e : sp.pathTo(destInt)) {
                //StdOut.print(e + "   ");
            	System.out.print(iDToAirport.get(e.from()) + "->" + iDToAirport.get(e.to()) + 
            			" " + (int)e.depTime() + "->" + (int)e.arrTime() + ", ");
            }
            StdOut.println();
        }
        else {
            //StdOut.printf("%d to %d         no path\n", s, t);
        	System.out.print(iDToAirport.get(s) + " to " + iDToAirport.get(destInt) + " no path\n");
        }

	}
}
