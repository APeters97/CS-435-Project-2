import java.util.*;
public class GraphSearch
{
	//3d
	public ArrayList<Node> DFSRec(final Node start, final Node end)		//recursive depth-first search
	{
		ArrayList<Node> dfsSearch = new ArrayList<Node>();
		dfsRecursive(start, end, dfsSearch);
		
		if(!dfsSearch.contains(end))	//if the destination node is not in the list, return null
			return null;
		
		return dfsSearch;
	}
	
	public void dfsRecursive(Node start, Node end, ArrayList<Node> al)	//DFS recursive helper
	{
		start.visited = true;		//set start node to visited
		al.add(start);				//add to the path list
		if(start == end)			//if currently on the destination node, return
			return;
		for(Node n : start.neighbors)	//go through neighbors of the current node
		{
			//if node isn't visited, call recursive helper on the node
			if(n.visited == false)
				dfsRecursive(n, end, al);
			
			//if destination has been found, break out to stop looking at the rest of the neighbors
			if(al.contains(end))
				break;
		}
	}
	
	//3e
	public ArrayList<Node> DFSIter(final Node start, final Node end)	//iterative depth-first search
	{
		ArrayList<Node> dfsSearch = new ArrayList<Node>();
		if(start == end)			//if the start node is the destination, add to list and return
		{
			dfsSearch.add(start);
			return dfsSearch;
		}
		
		Stack<Node> dfsStack = new Stack<Node>();		//create stack to use in traversal
		Node curr;
		start.visited = true;		//start to visited
		dfsStack.add(start);		//add start to stack
		while(dfsStack.empty() == false)	//while stack is not empty, so there are nodes to process
		{
			curr = dfsStack.pop();			//pop off stack for current node
			dfsSearch.add(curr);			//add to path list
			if(curr == end)					//if current is the destination, break out
				break;
			for(Node n: curr.neighbors)		//go through current's neighbors
			{
				if(n.visited == false)		//if the node is not visited, set to visited and add to stack
				{
					n.visited = true;
					dfsStack.add(n);
				}
			}
		}
		
		if(!dfsSearch.contains(end))		//if the destination is not in the list, return null
			return null;
		
		return dfsSearch;
	}
	
	//3f
	public ArrayList<Node> BFTRec(final Graph graph)	//recursive breadth-first search
	{
		ArrayList<Node> bfsSearch = new ArrayList<Node>();
		Queue<Node> bfsQueue = new LinkedList<Node>();		//create queue for traversal
		
		for(Node n : graph.vertices)
		{
			//if node is not visited, set to visited, add to queue, and call recursive helper
			if(n.visited == false)			
			{	
				//this code is used for first node in graph, and any disconnected nodes
				n.visited = true;
				bfsQueue.add(n);
				bfsRecursive(bfsQueue, bfsSearch);
			}
		}
			
        return bfsSearch;
	}
	
	public void bfsRecursive(Queue<Node> q, ArrayList<Node> al)	//BFS recursive helper
	{
		if(q.isEmpty())		//if the queue is empty, all nodes have been processed, so return
			return;
		
		Node curr= q.poll();	//pop off head of queue to get current node
		al.add(curr);			//add to path list
		for(Node n : curr.neighbors)	//look through current's neighbors
		{
			if(n.visited == false)		//if node is not visited, set to visited and add to queue
			{
				n.visited = true;
				q.add(n);
			}
		}
		
		bfsRecursive(q, al);
	}
	
	//3g
	public ArrayList<Node> BFTIter(final Graph graph)	//iterative breadth-first search
	{
		ArrayList<Node> bfsSearch = new ArrayList<Node>();
		
		Queue<Node> bfsQueue = new LinkedList<Node>();		//create queue for traversal
		Node curr;
		for(Node n: graph.vertices)
		{
			if(n.visited == false)		//if node is not visited, set to visited and add to queue
			{
				n.visited = true;
				bfsQueue.add(n);
			}
			while(bfsQueue.isEmpty() == false)		//while there are nodes to process
			{
				curr = bfsQueue.poll();				//pop off head of queue to get current node
				bfsSearch.add(curr);				//add to path list
				for(Node x : curr.neighbors)		//look through current's neighbors
				{
					if(x.visited == false)			//if node is not visited, set to visited and add to queue
					{
						x.visited = true;
						bfsQueue.add(x);
					}
				}
			}
		}
		return bfsSearch;
	}
}