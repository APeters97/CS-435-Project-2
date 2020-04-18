import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WeightedGraph
{
	//5b	
	List<Node> vertices;
	public WeightedGraph()
	{
		vertices = new ArrayList<Node>();
	}
	
	public void addNode(final int value)
	{
		vertices.add(new Node(value));
	}
	public void addNode_TEST_ONLY(Node n)		//used for testing
	{
		vertices.add(n);
	}
	
	public void addWeightedEdge(final Node first, final Node second, final int edgeWeight)
	{
		if(vertices.size() < 2)		//don't add an edge if the graph is less than 2 nodes
			return;
		
		first.weightedNeighbors.add(new Edge(second, edgeWeight));
	}
	
	public void removeDirectedEdge(final Node first, final Node second)
	{
		if(vertices.size() < 2)		//don't remove an edge if the graph is less than 2 nodes
			return;
		
		for(Edge e : first.weightedNeighbors)
			if(e.destination == second)
				first.weightedNeighbors.remove(e);
	}
	
	public HashSet<Node> getAllNodes()
	{
		HashSet<Node> allNodes = new HashSet<Node>();
		for(Node n : vertices)
			allNodes.add(n);
		
		return allNodes;
	}
}