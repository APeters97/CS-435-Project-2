import java.util.*;
class Node
{
    int value;		//used for integer tests
    String val;		//used for string tests
    List<Node> neighbors;
    boolean visited;
        
    public Node(int item)		//integer constructor
    {
        value = item;
        neighbors = new ArrayList<Node>();
        visited = false;
    }
    public Node(String item)	//string constructor
    {
        val = item;
        neighbors = new ArrayList<Node>();
        visited = false;
    }
}