import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Map;

public class GraphTests {

    public static void main(String[] args) {
        // Create graph
        GraphTests TestGraph= new GraphTests();
        Graph g = TestGraph.MakeSmallGraph();
        Graph h = TestGraph.SingleWeightGraph();
        Vertex source = g.getvertex("A");
        Vertex stop = g.getvertex("F");
        Pair<Integer, Map<Vertex, Vertex>> results=g.ShortestDistance(source, stop);
        Pair<Integer, Map<Vertex, Vertex>> resultsTime = g.ShortestTime(source, stop);
        Vertex current =stop;
        Vertex currentTime = stop;
        ArrayList<Vertex> Path= new ArrayList<>();
        ArrayList<Vertex> PathTime= new ArrayList<>();
        Path.add(stop);
        PathTime.add(stop);

        while ((current != source) && (results.getValue().get(current)!=null)) {
            current=results.getValue().get(current);
            Path.add(0,current);
        }

        //Print shortest path from MYGRAPH
        System.out.println("The shortest path from " +source.Name+ " to " +stop.Name+ " is: "+ results.getKey() + " ");

        for(Vertex v : Path)
        {
            System.out.print( v.Name);
            if (v!=stop)
                System.out.print("->");
        }

        while ((currentTime != source) && (resultsTime.getValue().get(currentTime)!=null)) {
            currentTime=resultsTime.getValue().get(currentTime);
            PathTime.add(0,currentTime);
        }

        //Print shortest time from MYGRAPH
        System.out.println("\n" + "The shortest time path from " + source.Name+ " to " + stop.Name+ " is: "+resultsTime.getKey());

        for (Vertex v : PathTime)
        {
            System.out.print(v.Name);
            if (v!=stop)
                System.out.println("->");
        }


       //Graph for singleWeightGraph
        Vertex sourceSingle = h.getvertex("10");
        Vertex stopSingle = h.getvertex("6");
        Pair<Integer, Map<Vertex, Vertex>> resultSingle=h.ShortestDistance(sourceSingle, stopSingle);
        Vertex currentSingle =stopSingle;
        ArrayList<Vertex> PathSingle= new ArrayList<>();
        PathSingle.add(stopSingle);

        while ((currentSingle != sourceSingle) && (resultSingle.getValue().get(currentSingle)!=null)) {
            currentSingle=resultSingle.getValue().get(currentSingle);
            PathSingle.add(0,currentSingle);
        }

        //Print shortest path from SINGLE WEIGHT GRAPH
        System.out.println("The shortest path from Single Weight Graph is: " +sourceSingle.Name+ " to " +stopSingle.Name+ " is: "+ results.getKey());

        for(Vertex v : PathSingle)
        {
            System.out.print( v.Name);
            if (v!=stopSingle)
                System.out.print("->");
        }



    }
    public Graph MakeSmallGraph()
    {
        Graph mygraph= new Graph();
        final Vertex A = mygraph.addvertex("A");
        final Vertex B = mygraph.addvertex("B");
        final Vertex C = mygraph.addvertex("C");
        final Vertex D = mygraph.addvertex("D");
        final Vertex E = mygraph.addvertex("E");
        final Vertex F = mygraph.addvertex("F");

        mygraph.newedge(A,B,1,2);
        mygraph.newedge(A,C, 5,1);
        mygraph.newedge(A,D, 4,6);
        mygraph.newedge(B,C, 3,2);
        mygraph.newedge(B,D, 2,3);
        mygraph.newedge(B,E, 2,4);
        mygraph.newedge(C,F, 1,8);
        mygraph.newedge(C,E, 2,2);
        mygraph.newedge(D,F, 2,7);
        mygraph.newedge(E,F, 3,6);


        return mygraph;

    }


    public Graph SingleWeightGraph() {


        Graph singleWeightGraph = new Graph();
        final Vertex One = singleWeightGraph.addvertex("1");
        final Vertex Two = singleWeightGraph.addvertex("2");
        final Vertex Three = singleWeightGraph.addvertex("3");
        final Vertex Four = singleWeightGraph.addvertex("4");
        final Vertex Five = singleWeightGraph.addvertex("5");
        final Vertex Six = singleWeightGraph.addvertex("6");
        final Vertex Seven = singleWeightGraph.addvertex("7");
        final Vertex Eight = singleWeightGraph.addvertex("8");
        final Vertex Nine = singleWeightGraph.addvertex("9");
        final Vertex Ten = singleWeightGraph.addvertex("10");


        singleWeightGraph.newedge(One,Two, 10, 1);
        singleWeightGraph.newedge(One, Four, 20,1);
        singleWeightGraph.newedge(One,Five, 20,1);
        singleWeightGraph.newedge(One, Six, 5, 1);
        singleWeightGraph.newedge(One, Seven, 15,1);
        singleWeightGraph.newedge(Two,Three,5,1);
        singleWeightGraph.newedge(Two,Four,10,1);
        singleWeightGraph.newedge(Three,Two,15,1);
        singleWeightGraph.newedge(Three,Four,5,1);
        singleWeightGraph.newedge(Four,Five,10,1);
        singleWeightGraph.newedge(Five,Six,5,1);
        singleWeightGraph.newedge(Seven,Six,10,1);
        singleWeightGraph.newedge(Eight,Seven,5,1);
        singleWeightGraph.newedge(Eight,One,5,1);
        singleWeightGraph.newedge(Eight,Two,20,1);
        singleWeightGraph.newedge(Nine,Eight,20,1);
        singleWeightGraph.newedge(Nine,Two,15,1);
        singleWeightGraph.newedge(Nine,Ten,10,1);
        singleWeightGraph.newedge(Ten,Two,5,1);
        singleWeightGraph.newedge(Ten,Three,5,1);


        return singleWeightGraph;
    }
}
