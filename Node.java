import java.util.*;
class Node
{
    int value;		//used for integer tests
    String val;		//used for string tests
    List<Node> neighbors;
    List<Edge> weightedNeighbors;
    boolean visited;
        
    public Node(final int item)		//integer constructor
    {
        value = item;
        neighbors = new ArrayList<Node>();
        weightedNeighbors = new ArrayList<Edge>();
        visited = false;
    }
    public Node(final String item)	//string constructor
    {
        val = item;
        neighbors = new ArrayList<Node>();
        weightedNeighbors = new ArrayList<Edge>();
        visited = false;
    }
}