import java.util.*;
public class DirectedGraph
{
	//4b
	List<Node> vertices;		//variable to store all nodes of graph
	public DirectedGraph()
	{
		vertices = new ArrayList<Node>();
	}
	
	public void addNode(final int value)	//add node to graph
	{
		vertices.add(new Node(value));
	}
	
	public void addDirectedEdge(final Node first, final Node second)	//add directed edge from first to second
	{
		if(vertices.size() < 2)		//don't add an edge if there is less than 2 nodes 
			return;
		
		if(!first.neighbors.contains(second))	//add edge from first to second if it is not there
			first.neighbors.add(second);
	}
	
	public void removeDirectedEdge(final Node first, final Node second)
	{
		if(vertices.size() < 2)		//don't remove an edge if there is less than 2 nodes
			return;
		
		if(first.neighbors.contains(second))	//remove edge from first to second if it there
			first.neighbors.remove(second);
	}
	
	public HashSet<Node> getAllNodes()	//return HashSet of all nodes in graph
	{
		HashSet<Node> allNodes = new HashSet<Node>();		//create new set
		for(Node n : vertices)		//add all nodes in graph to the set
			allNodes.add(n);
		
		return allNodes;		//return set
	}
}