import java.util.*;
import java.io.*;
public class Graph
{
	//3a
	List<Node> vertices;				//variables to store all nodes in graph
	public Graph()
	{
		vertices = new ArrayList<Node>();		//initialize vertices variable
	}

	public void addNode(final Node n)		//used in string tests
	{
		if(!vertices.contains(n))
			vertices.add(n);
	}
	
	public void addNode(final int nodeVal)	//add node to vertices
	{	
		vertices.add(new Node(nodeVal));
	}
	
	public void addUndirectedEdge(final Node first, final Node second)		//add an edge between first and second
	{
		if(vertices.size() < 2)		//don't add an edge if there is less than 2 nodes
			return;
		
		if(!first.neighbors.contains(second) && !second.neighbors.contains(first))		//add first and second to the other's neighbor list if they are not already there
		{
			first.neighbors.add(second);
			second.neighbors.add(first);
		}
	}
	
	public void removeUndirectedEdge(final Node first, final Node second)		//remove edge between first and second
	{
		if(vertices.size() < 2)		//don't add an edge if there is less than 2 nodes
			return;
		
		if(first.neighbors.contains(second) && second.neighbors.contains(first))	//remove first and second from the other's neighbor list if they are there
		{
			first.neighbors.remove(second);
			second.neighbors.remove(first);
		}
	}
	
	public HashSet<Node> getAllNodes()			//return set of all nodes in the graph
	{
		HashSet<Node> allNodes = new HashSet<Node>();		//create new set
		for(Node n : vertices)		//add all nodes in graph to the set
			allNodes.add(n);
		
		return allNodes;		//return set
	}
}