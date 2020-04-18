import java.util.*;
public class DirectedGraph
{
	//4b
	List<Node> vertices;
	public DirectedGraph()
	{
		vertices = new ArrayList<Node>();
	}
	
	public void addNode(final int value)
	{
		vertices.add(new Node(value));
	}
	
	public void addDirectedEdge(final Node first, final Node second)
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
	
	public HashSet<Node> getAllNodes()
	{
		HashSet<Node> allNodes = new HashSet<Node>();
		for(Node n : vertices)
			allNodes.add(n);
		
		return allNodes;
	}
}