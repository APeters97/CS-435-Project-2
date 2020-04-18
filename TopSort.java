import java.util.*;
public class TopSort
{
	//4d
	public ArrayList<Node> Kahns(final DirectedGraph graph)	//khan traversal of a directed graph
	{
		ArrayList<Node> kahnOutput = new ArrayList<Node>();		//create path list to return
		
		int[] inDegree = new int[graph.vertices.size()];	//create list to track in-degrees
		Arrays.fill(inDegree, 0);							//initialize everything to 0
		for(Node curr : graph.vertices)						//go through all nodes
		{
			for(Node pointer : curr.neighbors)					//look at all the nodes that current node is pointer to
			{
				int index = graph.vertices.indexOf(pointer);	//find index of node
				inDegree[index]++;								//increment appropriate index in in-degree list
			}
		}
		
		Queue<Node> kahnQueue = new LinkedList<Node>();		//create queue for kahn traversal
		addInDegree0(inDegree, kahnQueue, graph);			//add all nodes with in-degree of 0
		while(!kahnQueue.isEmpty())							//while there are nodes to process
		{
			Node curr = kahnQueue.poll();					//remove head of queue and current to that node
			kahnOutput.add(curr);							//add current to the path list
			for(Node pointer : curr.neighbors)				//go through the points of current
			{	
				int index = graph.vertices.indexOf(pointer);	//find respective index in in-degree list
				inDegree[index]--;								//decrement in-degree by 1
			}
			
			addInDegree0(inDegree, kahnQueue, graph);		//call helper method again to add nodes with in-degree 0
		}
		
		return kahnOutput;	//return path list
	}
	public void addInDegree0(int[] inDegreeList, Queue<Node> kahnList, DirectedGraph g)	//helper method to add nodes with in-degree 0 to queue
	{
		for(int i = 0; i < inDegreeList.length; i++)	//go through list
		{
			if(inDegreeList[i] == 0)			//if in-degree is 0, find respective node in graph and add node to queue
			{
				Node n = g.vertices.get(i);
				kahnList.add(n);
				inDegreeList[i]--;		//decrement in-degree to mark that this node is visited
				//System.out.println("Adding " + n.value + " to queue");
			}
		}
	}
	
	//4e
	public ArrayList<Node> mDFS(final DirectedGraph graph)	//mDFS traversal of a directed graph
	{
		ArrayList<Node> mdfsOutput = new ArrayList<Node>();		//create path list
		
		Stack<Node> mdfsStack = new Stack<Node>();		//create stack for traversal
		for(Node n : graph.vertices)		//go through all nodes in graph
		{
			if(n.visited == false)			//if node is not visited, call helper method
				mdfsHelper(n, mdfsStack);
		}
		while(!mdfsStack.empty())			//pop nodes off stack to create mDFS traversal
		{
			Node curr = mdfsStack.pop();
			mdfsOutput.add(curr);
		}
		
		return mdfsOutput;		//return path list
	}
	public void mdfsHelper(Node curr, Stack<Node> stack)	//DFS recursive helper
	{
		curr.visited = true;		//set current node to visited
		for(Node n : curr.neighbors)	//go through neighbors of the current node
		{
			if(n.visited == false)			//if neighbor isn't visited, call recursive helper on the node
				mdfsHelper(n, stack);
		}
		stack.add(curr);		//add current to stack for traversal
	}
}