import java.util.*;
import javafx.util.Pair;

public class Graph {
    private ArrayList<Vertex> Vertices = new ArrayList<>();

    public Vertex addvertex(String id) {
        Vertex newvertex = new Vertex(id);
        Vertices.add(newvertex);
        return newvertex;
    }

    public void addvertex(Vertex v) {

        Vertices.add(v);
    }

    public Vertex getvertex(String s) {
        for (Vertex v : Vertices) {
            if (v.Name == s)
                return v;
        }
        return null;
    }

    public void newedge(Vertex from, Vertex to, int dist, int tim) {
        Edge newedge = new Edge(from, to);
        newedge.distance = dist;
        newedge.time = tim;
    }

    //Shortest distance
    public Pair<Integer, Map<Vertex, Vertex>> ShortestDistance(Vertex source, Vertex stop) { //start & stop
        Map<Vertex, Vertex> PredecessorMap = new HashMap<>();
        Map<Vertex, Integer> DistanceMap = new HashMap<>();
        Map<Vertex, Boolean> ClearMap = new HashMap<>();

        // initialize arrays (distance)
        System.out.println("\n" + "Distance maps created");
        for (Vertex v : Vertices) {
            DistanceMap.put(v, 1000);
            PredecessorMap.put(v, null);
            ClearMap.put(v, false);
        }
        DistanceMap.put(source, 0);

        for (int counter = 0; counter < Vertices.size(); counter++) {
            Vertex i = getmin(DistanceMap, ClearMap);
            for (Edge ij : i.OutEdges) {
                if (DistanceMap.get(i) + ij.distance < DistanceMap.get(ij.getTovertex())){
                    DistanceMap.put(ij.getTovertex(), DistanceMap.get(i) + ij.distance );
                    PredecessorMap.put(ij.getTovertex(), i);
                }
            }
            ClearMap.put(i, true);
        }


        return (new Pair<Integer, Map<Vertex, Vertex>>(DistanceMap.get(stop), PredecessorMap));
    }

    public Vertex getmin(Map<Vertex, Integer> distanceMap, Map<Vertex, Boolean> clearMap) {
        Vertex minVertex = null;
        Integer minInt = null;

        for (Map.Entry<Vertex, Integer> entry : distanceMap.entrySet()) {
            if ((minVertex == null && minInt == null)|| (entry.getValue() < minInt)){
                if(!clearMap.get(entry.getKey())) {

                    minVertex = entry.getKey();
                    minInt = entry.getValue();
                }
            }
        }
        return minVertex;

    }

    //Shortest Time
    public Pair<Integer, Map<Vertex,Vertex> > ShortestTime(Vertex source, Vertex stop) { //start & stop
        Map<Vertex, Vertex> PredecessorMapTime = new HashMap<>();
        Map<Vertex, Integer> DistanceMapTime = new HashMap<>();
        Map<Vertex, Boolean> ClearMapTime = new HashMap<>();

        // initialize arrays (distance (time))
                System.out.println("Time maps created");
                for (Vertex v : Vertices) {
                    DistanceMapTime.put(v, 1000);
                    PredecessorMapTime.put(v, null);
                    ClearMapTime.put(v, false);
        }
                DistanceMapTime.put(source, 0);


        for (int counter = 0; counter < Vertices.size(); counter++) {
            Vertex i = getmin(DistanceMapTime, ClearMapTime);
            for (Edge ij : i.OutEdges) {
                if (DistanceMapTime.get(i) + ij.distance < DistanceMapTime.get(ij.getTovertex())){
                    DistanceMapTime.put(ij.getTovertex(), DistanceMapTime.get(i) + ij.distance );
                    PredecessorMapTime.put(ij.getTovertex(), i);
                }
            }
            ClearMapTime.put(i, true);
        }

        return (new Pair<Integer, Map<Vertex, Vertex>>(DistanceMapTime.get(stop), PredecessorMapTime));
    }

    public Vertex gettime(Map<Vertex, Integer> distanceMapTime, Map<Vertex, Boolean> clearMapTime) {
        Vertex minVertex = null;
        Integer minInt = null;

        for (Map.Entry<Vertex, Integer> entry : distanceMapTime.entrySet()) {
            if ((minVertex == null && minInt == null)|| (entry.getValue() < minInt)){
                if(!clearMapTime.get(entry.getKey())) {

                    minVertex = entry.getKey();
                    minInt = entry.getValue();
                }
            }
        }
        return minVertex;
    }

}

//We have to use the vertex and edge class, other then we can change the whole source code
class Vertex{
    public String Name;
    public ArrayList<Edge> OutEdges = new ArrayList<>();
    public  Vertex(String id){
        Name = id;
    }
    public void addOutEdge(Edge outedge){
        OutEdges.add(outedge);
    }
    public ArrayList<Edge> getOutEdges(){
        return OutEdges;
    }
}

class Edge{
    private Vertex fromvertex;
    private Vertex tovertex;
    public int distance=0;
    public int time=0;

    public Vertex getTovertex() {
        return tovertex;
    }

    public Edge(Vertex from, Vertex to){
        fromvertex=from;
        tovertex=to;
        fromvertex.addOutEdge(this);
        //If not directional
        tovertex.addOutEdge(this);
    }
}