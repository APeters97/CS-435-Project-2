import java.util.*;
public class Test
{
	Random random = new Random();
	GraphSearch gs = new GraphSearch();
	public static void main(String[]args)
	{
		Test part1 = new Test();
		
		//graph to test DFS and BFS code
		Graph test1 = new Graph();
		Node s = new Node("S");
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node e = new Node("E");
		Node f = new Node("F");
		Node g = new Node("G");
		Node h = new Node("H");
		Node d = new Node("D");
		Node x = new Node("X");
		
		s.neighbors = new ArrayList<Node>(Arrays.asList(a));
		a.neighbors = new ArrayList<Node>(Arrays.asList(s, b, c));
		b.neighbors = new ArrayList<Node>(Arrays.asList(a,c,e,f));
		c.neighbors = new ArrayList<Node>(Arrays.asList(a,b,f,g));
		e.neighbors = new ArrayList<Node>(Arrays.asList(b,d));
		f.neighbors = new ArrayList<Node>(Arrays.asList(b,c,g,h));
		g.neighbors = new ArrayList<Node>(Arrays.asList(c,f));
		h.neighbors = new ArrayList<Node>(Arrays.asList(f,d));
		d.neighbors = new ArrayList<Node>(Arrays.asList(e,h));
		
		test1.addNode(s);
		test1.addNode(a);
		test1.addNode(b);
		test1.addNode(c);
		test1.addNode(d);
		test1.addNode(e);
		test1.addNode(f);
		test1.addNode(g);
		test1.addNode(h);
		test1.addNode(x);

		
//Create new Unweighted Random Graph Test/////////
		System.out.println("Unweighted Random Graph Test");
		Graph randomUnweightedGraph = part1.createRandomUnweightedGraphIter(10);
		for(Node n : randomUnweightedGraph.vertices)
		{
			System.out.print(n.value + ": [ ");
			for(Node neighbor : n.neighbors)
				System.out.print(neighbor.value + " ");
			System.out.println("]");
		}
//////////////////////////////////////////////////
		
//Create new Linked List Graph Test///////////////
		System.out.println("\nLinked List Graph Test");
		Graph linkedList = part1.createLinkedList(10);
		for(Node n : linkedList.vertices)
		{
			System.out.print(n.value + ": [ ");
			for(Node neighbor : n.neighbors)
				System.out.print(neighbor.value + " ");
			System.out.println("]");
		}
///////////////////////////////////////////////////
		
//Get all nodes in HashSet Test///////////////////
		System.out.println("\nAll Nodes in HashSet Test");
		HashSet<Node> allNodes = linkedList.getAllNodes();	//using graph from above linked list
		for(Node n : allNodes)
			System.out.print(n.value + " ");
		System.out.println();
//////////////////////////////////////////////////
	
//DFS Recursive Test//////////////////////////////
		System.out.println("\nDFS Recursive Test");
		ArrayList<Node> dfsSearchRec = part1.gs.DFSRec(s, d);
		System.out.print("Start: S, End: D - ");
		if(dfsSearchRec == null)
			System.out.println("There is no DFS path between " + s.val + " and " + d.val);
		else
			for(Node n : dfsSearchRec)
				System.out.print(n.val + " ");
		//Reset graph
		part1.resetGraph(test1);
		System.out.println();
		
		dfsSearchRec = part1.gs.DFSRec(s, x);
		System.out.print("Start: S, End: X - ");
		if(dfsSearchRec == null)
			System.out.println("There is no DFS path between " + s.val + " and " + x.val);
		else
			for(Node n : dfsSearchRec)
				System.out.print(n.val + " ");
		//Reset graph
		part1.resetGraph(test1);
		System.out.println();
//////////////////////////////////////////////////		
		
//DFS Iterative Test/////////////////////////////
		System.out.println("DFS Iterative Test");
		ArrayList<Node> dfsSearchIter = part1.gs.DFSIter(s, d);
		System.out.print("Start: S, End: D - ");
		if(dfsSearchIter == null)
			System.out.println("There is no DFS path between " + s.val + " and " + d.val);
		else
			for(Node n : dfsSearchIter)
				System.out.print(n.val + " ");
		//Reset graph
		part1.resetGraph(test1);
		System.out.println();
	
		dfsSearchIter = part1.gs.DFSIter(s, x);
		System.out.print("Start: S, End: X - ");
		if(dfsSearchIter == null)
			System.out.println("There is no DFS path between " + s.val + " and " + x.val);
		else
			for(Node n : dfsSearchIter)
				System.out.print(n.val + " ");
		//Reset graph
		part1.resetGraph(test1);
		System.out.println();
//////////////////////////////////////////////////	
		
//BFS Recursive Test/////////////////////////////
		System.out.println("BFS Recursive Test");
		ArrayList<Node> bfsSearchRec = part1.gs.BFTRec(test1);
		for(Node n : bfsSearchRec)
			System.out.print(n.val + " ");
		
		//Reset graph
		part1.resetGraph(test1);
		System.out.println("\n");
//////////////////////////////////////////////////
		
//BFS Recursive Test/////////////////////////////
		System.out.println("BFS Iterative Test");
		ArrayList<Node> bfsSearchIter = part1.gs.BFTIter(test1);
		for(Node n : bfsSearchIter)
			System.out.print(n.val + " ");
		
		//Reset graph
		part1.resetGraph(test1);
		System.out.println("\n");
//////////////////////////////////////////////////
				
//BFS Recursive Linked List Test//////////////////
		System.out.println("BFS Recursive Linked List Test");
		ArrayList<Node> bfsRecLL = part1.BFTRecLinkedList(10);
		for(Node n : bfsRecLL)
			System.out.print(n.value + " ");
		
		//Reset graph
		part1.resetGraph(test1);
		System.out.println("\n");
//////////////////////////////////////////////////
		
//BFS Iterative Linked List Test//////////////////
		System.out.println("BFS Iterative Linked List Test");
		ArrayList<Node> bfsIterLL = part1.BFSIterLinkedList(10);
		for(Node n : bfsIterLL)
			System.out.println(n.value + " ");
//////////////////////////////////////////////////
		
	}
	public void resetGraph(Graph g)		//used to reset visited variables in graph tests
	{
		for(Node n : g.vertices)
			n.visited = false;
	}
	
	//3b
	public Graph createRandomUnweightedGraphIter(int n)	//create random unweighted graph
	{
		Graph newGraph = new Graph();		//create graph to return
		int nodeCounter = 0, randNum, randNode;	//helper variables
		boolean dontAdd = false;				//helper variable
		while(nodeCounter != n)			//add n number of nodes to graph
		{
			randNum = random.nextInt(n*10)+1;	//generate a random number to add to graph
			for(Node currNode: newGraph.vertices)	//look through graph to make sure random number is not already there
			{
				if(randNum == currNode.value)	//if number is already in graph, set dontAdd to true
				{
					dontAdd = true;
					break;
				}
			}
			if(!dontAdd)	//only add the number if it is not in the graph, increment nodeCouter
			{
				newGraph.addNode(randNum);
				nodeCounter++;
			}
		}
		for(Node x : newGraph.vertices)		//go through all nodes of the graph
		{
			randNum = random.nextInt(3)+1;	//generate a random number: 1, 2, or 3 - how many neighbors the node will have
			for(int i = 0; i < randNum; i++)	//execute 1, 2, or 3 times
			{
				randNode = random.nextInt(n);	//used to find a random node in the graph
				Node node = newGraph.vertices.get(randNode);	//get a random node from the graph
				if(x.neighbors.size() < 3 && node.neighbors.size() < 3)		//if current node and random node do not have 3 neighbors already, add an edge between them
				{
					if(x.value != node.value)	//add an edge if the current node and random node are not the same
						newGraph.addUndirectedEdge(x, node);
				}
			}
		}
		
		return newGraph;
	}
	
	//3c
	public Graph createLinkedList(int n)	//create a linked list graph
	{
		Graph newGraph = new Graph();		//create new graph to return
		for(int i = 1; i <= n; i++)			//add n number of nodes to graph
			newGraph.addNode(i);
		
		List<Node> tempVertices = newGraph.vertices;	//helper variable
		for(int i = 0; i < n-1; i++)					//go through all nodes in graph, and add an edge to a node and the one after it
			newGraph.addUndirectedEdge(tempVertices.get(i), tempVertices.get(i+1));
		
		return newGraph;		//return created graph
	}
	
	//3h
	public ArrayList<Node> BFTRecLinkedList(int n)	//call BFT recursive on a linked list
	{
		Graph LLgraph = createLinkedList(n);	//create new linked list graph
		return(gs.BFTRec(LLgraph));				//call recursive BFT on graph
	}
	
	//3i
	public ArrayList<Node> BFSIterLinkedList(int n)	//call BFT iterative on a linked list
	{
		Graph LLgraph = createLinkedList(n);	//create linked list graph
		return(gs.BFTIter(LLgraph));		//call iterative BFT on graph
	}
}