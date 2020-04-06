import java.util.*;
public class Test
{
	Random random = new Random();
	GraphSearch gs = new GraphSearch();
	public static void main(String[]args)
	{
		Test part1 = new Test();
		Test part2 = new Test();

//Question 3 - Graph Test///////////////////////////////////////
		
		//graph to test DFS and BFS code
		Graph test1 = new Graph();
		Node gS = new Node("S");
		Node gA = new Node("A");
		Node gB = new Node("B");
		Node gC = new Node("C");
		Node gE = new Node("E");
		Node gF = new Node("F");
		Node gG = new Node("G");
		Node gH = new Node("H");
		Node gD = new Node("D");
		Node gX = new Node("X");
		
		gS.neighbors = new ArrayList<Node>(Arrays.asList(gA));
		gA.neighbors = new ArrayList<Node>(Arrays.asList(gS,gB,gC));
		gB.neighbors = new ArrayList<Node>(Arrays.asList(gA,gC,gE,gF));
		gC.neighbors = new ArrayList<Node>(Arrays.asList(gA,gB,gF,gG));
		gE.neighbors = new ArrayList<Node>(Arrays.asList(gB,gD));
		gF.neighbors = new ArrayList<Node>(Arrays.asList(gB,gC,gG,gH));
		gG.neighbors = new ArrayList<Node>(Arrays.asList(gC,gF));
		gH.neighbors = new ArrayList<Node>(Arrays.asList(gF,gD));
		gD.neighbors = new ArrayList<Node>(Arrays.asList(gE,gH));
		
		test1.addNode(gS);
		test1.addNode(gA);
		test1.addNode(gB);
		test1.addNode(gC);
		test1.addNode(gD);
		test1.addNode(gE);
		test1.addNode(gF);
		test1.addNode(gG);
		test1.addNode(gH);
		test1.addNode(gX);

		
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
		ArrayList<Node> dfsSearchRec = part1.gs.DFSRec(gS, gD);
		System.out.print("Start: S, End: D - ");
		if(dfsSearchRec == null)
			System.out.println("There is no DFS path between " + gS.val + " and " + gD.val);
		else
			for(Node n : dfsSearchRec)
				System.out.print(n.val + " ");
		//Reset graph
		part1.resetGraph(test1);
		System.out.println();
		
		dfsSearchRec = part1.gs.DFSRec(gS, gX);
		System.out.print("Start: S, End: X - ");
		if(dfsSearchRec == null)
			System.out.println("There is no DFS path between " + gS.val + " and " + gX.val);
		else
			for(Node n : dfsSearchRec)
				System.out.print(n.val + " ");
		//Reset graph
		part1.resetGraph(test1);
		System.out.println();
//////////////////////////////////////////////////		
		
//DFS Iterative Test/////////////////////////////
		System.out.println("DFS Iterative Test");
		ArrayList<Node> dfsSearchIter = part1.gs.DFSIter(gS, gD);
		System.out.print("Start: S, End: D - ");
		if(dfsSearchIter == null)
			System.out.println("There is no DFS path between " + gS.val + " and " + gD.val);
		else
			for(Node n : dfsSearchIter)
				System.out.print(n.val + " ");
		//Reset graph
		part1.resetGraph(test1);
		System.out.println();
	
		dfsSearchIter = part1.gs.DFSIter(gS, gX);
		System.out.print("Start: S, End: X - ");
		if(dfsSearchIter == null)
			System.out.println("There is no DFS path between " + gS.val + " and " + gX.val);
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
		
//////////////////////////////////////////////////////////////////

	
//Question 4 - Directed Graph Testing/////////////////////////////
		TopSort ts = new TopSort();
		
//Create new Random Directed Graph Test/////////
		System.out.println("Random Directed Graph Test");
		DirectedGraph randomDirectedGraph = part2.createRandomDAGIter(10);
		for(Node n : randomDirectedGraph.vertices)
		{
			System.out.print(n.value + ": [ ");
			for(Node neighbor : n.neighbors)
				System.out.print(neighbor.value + " ");
			System.out.println("]");
		}
		System.out.println();
//////////////////////////////////////////////////
		
//Kahn Traversal Test/////////////////////////////
		System.out.println("Kahn Traversal Test");
		DirectedGraph kahnTraversalGraph = part2.createRandomDAGIter(10);
		ArrayList<Node> kahnTraversal = ts.Kahns(kahnTraversalGraph);
		for(Node n : kahnTraversal)
			System.out.print(n.value + " ");
//////////////////////////////////////////////////

//mDFS Traversal Test/////////////////////////////
		System.out.println("mDFS Traversal Test");
		DirectedGraph mdfsTraversalGraph = part2.createRandomDAGIter(10);
		ArrayList<Node> mdfsTraversal = ts.Kahns(mdfsTraversalGraph);
		for(Node n : mdfsTraversal)
			System.out.print(n.value + " ");
//////////////////////////////////////////////////
		
/////////////////////////////////////////////////////////////////


//Question 5 - Weighted Graph Test///////////////////////////////
		
//Complete Weighted Graph Testing/////////////////
		System.out.println("Complete Weighted Graph Testing - (node, edge weight)");
		WeightedGraph completeGraph = part2.createRandomCompleteWeightedGraph(10);
		for(Node n : completeGraph.vertices)
		{
			System.out.print(n.value + ": [ ");
			for(Edge e : n.weightedNeighbors)
			{
				System.out.print("(" + e.destination.value + "," + e.weight + "), ");
			}
			System.out.println("]");
		}
//////////////////////////////////////////////////
		
//Complete Weighted Graph Testing/////////////////
		System.out.println("\nWeighted Linked List Graph Testing - (node, edge weight)");
		WeightedGraph weightedLL = part2.createWeightedLinkedList(10);
		for(Node n : weightedLL.vertices)
		{
			System.out.print(n.value + ": [ ");
			for(Edge e : n.weightedNeighbors)
			{
				System.out.print("(" + e.destination.value + "," + e.weight + ")");
			}
			System.out.println(" ]");
		}
//////////////////////////////////////////////////
		
//Dijkstra's Algorithm Testing////////////////////
		System.out.println("Dijkstra's Algorithm Testing");
		WeightedGraph dijkstraTest = new WeightedGraph();
		Node dA = new Node("a");
		Node dB = new Node("b");
		Node dC = new Node("c");
		Node dD = new Node("d");
		Node dE = new Node("e");
		Node dF = new Node("f");
		Node dG = new Node("g");
		Node dH = new Node("h");
		Node dI = new Node("i");
		
		dijkstraTest.addNode(dA);
		dijkstraTest.addNode(dB);
		dijkstraTest.addNode(dC);
		dijkstraTest.addNode(dD);
		dijkstraTest.addNode(dE);
		dijkstraTest.addNode(dF);
		dijkstraTest.addNode(dG);
		dijkstraTest.addNode(dH);
		dijkstraTest.addNode(dI);
		
		
		dijkstraTest.addWeightedEdge(dA, dB, 4);
		
		dijkstraTest.addWeightedEdge(dB, dC, 11);
		dijkstraTest.addWeightedEdge(dB, dD, 9);
		
		dijkstraTest.addWeightedEdge(dC, dA, 8);
		
		dijkstraTest.addWeightedEdge(dD, dC, 7);
		dijkstraTest.addWeightedEdge(dD, dE, 2);
		dijkstraTest.addWeightedEdge(dD, dF, 6);
		
		dijkstraTest.addWeightedEdge(dE, dB, 8);
		dijkstraTest.addWeightedEdge(dE, dH, 4);
		dijkstraTest.addWeightedEdge(dE, dG, 7);
		
		dijkstraTest.addWeightedEdge(dF, dC, 1);
		dijkstraTest.addWeightedEdge(dF, dE, 5);
		
		dijkstraTest.addWeightedEdge(dG, dH, 14);
		dijkstraTest.addWeightedEdge(dG, dI, 9);
		
		dijkstraTest.addWeightedEdge(dH, dF, 2);
		dijkstraTest.addWeightedEdge(dH, dI, 10);
		
		
		
		HashMap<Node, Integer> shortestPaths = part2.dijkstras(dG);
		System.out.println("\nShortest Paths From Source");
		for(Node n : shortestPaths.keySet())
			System.out.println(n.val + ": [" + shortestPaths.get(n) + "]");
		
//////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////
		
//Question 6 - A*////////////////////////////////////////////////

//Create Random Grid Testing////////////////////////
		GridGraph randomGraph = part2.createRandomGridGraph(5);
		for(int x = 0; x < randomGraph.maze.length; x++)
		{
			for(int y = 0; y < randomGraph.maze.length; y++)
			{
				System.out.print(randomGraph.maze[x][y].value + " ");
			}
			System.out.println();
		}
		System.out.println();
		for(int x = 0; x < randomGraph.maze.length; x++)
		{
			for(int y = 0; y < randomGraph.maze.length; y++)
			{
				System.out.print(randomGraph.maze[x][y].value + ": [ ");
				for(GridNode gn : randomGraph.maze[x][y].neighbors)
				{
					System.out.print(gn.value + ",");
				}
				System.out.println(" ]");
			}
			
		}
		System.out.println("\n");
//////////////////////////////////////////////////
		
//A* Testing//////////////////////////////////////
		System.out.println("A* Testing");
		GridGraph aStarTest = new GridGraph(6);
		int counter = 1;
		for(int x = 0; x < 6; x++)
		{
			for(int y = 0; y < 6; y++)
			{
				aStarTest.maze[y][x] = new GridNode(x, y, counter);
				counter++;
			}
		}
		
		aStarTest.addUndirectedEdge(aStarTest.maze[0][0], aStarTest.maze[1][0]);
		aStarTest.addUndirectedEdge(aStarTest.maze[1][0], aStarTest.maze[2][0]);
		aStarTest.addUndirectedEdge(aStarTest.maze[2][0], aStarTest.maze[3][0]);	//for test B, comment this out
		aStarTest.addUndirectedEdge(aStarTest.maze[3][0], aStarTest.maze[4][0]);
		aStarTest.addUndirectedEdge(aStarTest.maze[4][0], aStarTest.maze[5][0]);

		aStarTest.addUndirectedEdge(aStarTest.maze[0][0], aStarTest.maze[0][1]);
		aStarTest.addUndirectedEdge(aStarTest.maze[5][0], aStarTest.maze[5][1]);
		////////////////////
		aStarTest.addUndirectedEdge(aStarTest.maze[0][1], aStarTest.maze[0][2]);
		aStarTest.addUndirectedEdge(aStarTest.maze[5][1], aStarTest.maze[5][2]);
		////////////////////
		aStarTest.addUndirectedEdge(aStarTest.maze[2][2], aStarTest.maze[3][2]);
		aStarTest.addUndirectedEdge(aStarTest.maze[3][2], aStarTest.maze[4][2]);
		aStarTest.addUndirectedEdge(aStarTest.maze[4][2], aStarTest.maze[5][2]);
		
		//aStarTest.addUndirectedEdge(aStarTest.maze[0][2], aStarTest.maze[0][3]);	//for test B, uncomment this
		aStarTest.addUndirectedEdge(aStarTest.maze[2][2], aStarTest.maze[2][3]);
		aStarTest.addUndirectedEdge(aStarTest.maze[3][2], aStarTest.maze[3][3]);
		////////////////////
		//aStarTest.addUndirectedEdge(aStarTest.maze[0][3], aStarTest.maze[1][3]);	//for test B, uncomment this
		aStarTest.addUndirectedEdge(aStarTest.maze[1][3], aStarTest.maze[2][3]);
		aStarTest.addUndirectedEdge(aStarTest.maze[2][3], aStarTest.maze[3][3]);
		
		aStarTest.addUndirectedEdge(aStarTest.maze[1][3], aStarTest.maze[1][4]);
		aStarTest.addUndirectedEdge(aStarTest.maze[3][3], aStarTest.maze[3][4]);
		////////////////////
		aStarTest.addUndirectedEdge(aStarTest.maze[0][4], aStarTest.maze[1][4]);
		aStarTest.addUndirectedEdge(aStarTest.maze[3][4], aStarTest.maze[4][4]);
		aStarTest.addUndirectedEdge(aStarTest.maze[4][4], aStarTest.maze[5][4]);
		
		aStarTest.addUndirectedEdge(aStarTest.maze[0][4], aStarTest.maze[0][5]);
		aStarTest.addUndirectedEdge(aStarTest.maze[1][4], aStarTest.maze[1][5]);
		aStarTest.addUndirectedEdge(aStarTest.maze[3][4], aStarTest.maze[3][5]);
		aStarTest.addUndirectedEdge(aStarTest.maze[5][4], aStarTest.maze[5][5]);
		///////////////////
		aStarTest.addUndirectedEdge(aStarTest.maze[0][5], aStarTest.maze[1][5]);
		aStarTest.addUndirectedEdge(aStarTest.maze[1][5], aStarTest.maze[2][5]);
		aStarTest.addUndirectedEdge(aStarTest.maze[2][5], aStarTest.maze[3][5]);
		
		GridNode source = aStarTest.maze[0][0];
		GridNode dest = aStarTest.maze[5][5];
		
		ArrayList<GridNode> aStarPath = part2.astar(source, dest);
		for(GridNode n : aStarPath)
			System.out.print(n.value + " ");
		System.out.println("\n");
//////////////////////////////////////////////////
		
//A* Testing - Random Graph///////////////////////
		System.out.println("A* Testing");
		GridGraph randomGraphTest = part2.createRandomGridGraph(100);
		for(int x = 0; x < randomGraphTest.maze.length; x++)
		{
			for(int y = 0; y < randomGraphTest.maze.length; y++)
			{
				if(randomGraphTest.maze[x][y].neighbors.size() == 0)
					System.out.print("X   ");
				else
				{
					if(randomGraphTest.maze[x][y].value < 10)
						System.out.print(randomGraphTest.maze[x][y].value + "   ");
					else if(randomGraphTest.maze[x][y].value == 100)
						System.out.print(randomGraphTest.maze[x][y].value + " ");
					else
						System.out.print(randomGraphTest.maze[x][y].value + "  ");
				}	
			}
			System.out.println();
		}
		System.out.println();
		for(int x = 0; x < randomGraphTest.maze.length; x++)
		{
			for(int y = 0; y < randomGraphTest.maze.length; y++)
			{
				System.out.print(randomGraphTest.maze[x][y].value + ": [ ");
				for(GridNode gn : randomGraphTest.maze[x][y].neighbors)
				{
					System.out.print(gn.value + ",");
				}
				System.out.println(" ]");
			}
			
		}
		
		GridNode randSource = randomGraphTest.maze[0][0];
		GridNode randDest = randomGraphTest.maze[100][100];
		
		ArrayList<GridNode> aStarPathRand = part2.astar(randSource, randDest);
		if(aStarPathRand == null)
			System.out.println("There was no path from " + randSource.value + " to " + randDest.value);
		else
		{
			for(GridNode n : aStarPathRand)
				System.out.print(n.value + " ");
		}
		
		System.out.println("\n");
//////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////
		
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
		Graph newLL = new Graph();		//create new graph to return
		for(int i = 1; i <= n; i++)			//add n number of nodes to graph
			newLL.addNode(i);
		
		List<Node> tempVertices = newLL.vertices;	//helper variable
		for(int i = 0; i < n-1; i++)					//go through all nodes in graph, and add an edge to a node and the one after it
			newLL.addUndirectedEdge(tempVertices.get(i), tempVertices.get(i+1));
		
		return newLL;		//return created graph
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
	
	//4c
	public DirectedGraph createRandomDAGIter(final int n)	//create random directed graph
	{
		DirectedGraph newDAG = new DirectedGraph();
		int nodeCounter = 0, randNum, randNode;	//helper variables
		boolean dontAdd = false;				//helper variable
		while(nodeCounter != n)			//add n number of nodes to graph
		{
			randNum = random.nextInt(n*10)+1;	//generate a random number to add to graph
			for(Node currNode: newDAG.vertices)	//look through graph to make sure random number is not already there
			{
				if(randNum == currNode.value)	//if number is already in graph, set dontAdd to true
				{
					dontAdd = true;
					break;
				}
			}
			if(!dontAdd)	//only add the number if it is not in the graph, increment nodeCouter
			{
				newDAG.addNode(randNum);
				nodeCounter++;
			}
		}
		for(int i = 0; i < n; i++)	//go through each node of the graph
		{
			if(i == n-1)
				continue;
			Node currNode = newDAG.vertices.get(i);	//get current node
			//System.out.println("On index [" + i + "] on node [" + currNode.value + "]");
			randNum = random.nextInt(n-i-1) + 1;	//generate a random number of pointers to give the node
			//System.out.println("Adding " + randNum + " nodes");
			for(int j = 0; j < randNum; j++)	//execute 1, 2, or 3 times
			{
				randNode = random.nextInt(n-i-1) + i + 1;		//find a random node located after the current node
				//System.out.println("Choose index:  " + randNode);
				Node node = newDAG.vertices.get(randNode);	//get the random node from the graph
				newDAG.addDirectedEdge(currNode, node);	//add a directed edge between the current node and random node
			}
		}
		
		return newDAG;	//return DAG
	}
	
	//5c
	public WeightedGraph createRandomCompleteWeightedGraph(final int n)	//create random weighted complete graph
	{
		WeightedGraph newWeightedGraph = new WeightedGraph();		//create graph to return
		int randWeight;
		for(int i = 0; i < n; i++)		//add n nodes to the graph
			newWeightedGraph.addNode(i);
		
		for(Node curr : newWeightedGraph.vertices)		//go through each node in the graph
		{
			for(Node eachNode : newWeightedGraph.vertices)		//go through each node again (the neighbors)
			{
				if(eachNode.value == curr.value)		//if neighbor node is on current node, skip
					continue;
				
				randWeight = random.nextInt(10)+1;			//generate a random weight
				newWeightedGraph.addWeightedEdge(curr, eachNode, randWeight);	//add a weighted edge from current to the neighbor node
			}
		}
		
		return newWeightedGraph;		//return weighted graph
	}
	
	//5d
	public WeightedGraph createWeightedLinkedList(final int n)	//create weighted linked list graph
	{
		WeightedGraph newWeightedLL = new WeightedGraph();		//create new graph to return
		for(int i = 0; i < n; i++)			//add n number of nodes to graph
			newWeightedLL.addNode(i);
		
		int randomWeight = random.nextInt(10)+1;		//generate a random uniform weight
		
		for(int i = 0; i < n-1; i++)					//go through all nodes in graph, and add an edge to a node and the one after it
			newWeightedLL.addWeightedEdge(newWeightedLL.vertices.get(i), newWeightedLL.vertices.get(i+1), randomWeight);
		
		return newWeightedLL;		//return created graph
	}
	
	//5e
	public HashMap<Node, Integer> dijkstras(final Node start)	//returns HashMap of all the node's shortest path from source node
	{
		/*TO SEE DIJKSTRA LOGIC, UNCOMMENT PRINTLN STATEMENTS*/
		
		HashMap<Node, Integer> shortestPath = new HashMap<Node, Integer>();		//create Dijkstra HashMap to return
		
		HashMap<Node, Path> pathsAndParents = new HashMap<Node, Path>();		//create HashMap with parents for testing
		Queue<Node> dQueue = new LinkedList<Node>();							//create queue for processing
		pathsAndParents.put(start, new Path(0, null));							//add start node to HashMap with weight 0
		start.visited = true;													//set node to visited
		//System.out.println("\nStarting at node: " + start.value);
		for(Edge e: start.weightedNeighbors)									//look at start's neighbors and add to HashMap with weight from source
		{
			//System.out.println("Adding " + e.destination.val + " to hash with weight " + e.weight);
			pathsAndParents.put(e.destination, new Path(e.weight, start));
			dQueue.add(e.destination);											//add node to queue to be processed
		}
		
		while(!dQueue.isEmpty())						//while there are nodes to process
		{			
			Node curr = dQueue.poll();					//get the current node
			curr.visited = true;						//set to visited
			//System.out.println("\nOn node: " + curr.val);
			//System.out.println("Current weight: " + pathsAndParents.get(curr).weight + " with parent " + pathsAndParents.get(curr).parent.val);
			for(Edge e : curr.weightedNeighbors)		//look through current node's neighbors
			{
				//System.out.println("   Neighbor: " + e.destination.val);
				if(pathsAndParents.containsKey(e.destination))		//if the neighbor node is currently in the HashMap, check if weight needs to be updated
				{
					Path currentNode = pathsAndParents.get(curr);			//grab the path info of the current node
					int currentToNextNode = currentNode.weight + e.weight;
					
					Path nextNode = pathsAndParents.get(e.destination);		//grab the path info of the current neighbor node
					int existingPathToNext = nextNode.weight;
					
					//System.out.println("      Existing weight: " + existingPathToNext);
					//System.out.println("      Possible new weight: " + currentToNextNode);
					if(currentToNextNode < existingPathToNext)		//if the weight of the new path is less than weight of old path, replace path
					{
						//System.out.println("         Replacing weight path");
						pathsAndParents.replace(e.destination, new Path(currentToNextNode, curr));
					}
					else
						//System.out.println("         Not replacing weight path");
					
					if(e.destination.visited == false && !dQueue.contains(e.destination))	//if the neighbor node has not been processed yet, add to queue
						dQueue.add(e.destination);
				}
				else					//neighbor node is not in HashMap, add it to HashMap with weight from current node
				{
					Path currentNode = pathsAndParents.get(curr);	//grab the path info of the current node
					int currPath = currentNode.weight;
					
					int totalWeight = currPath + e.weight;	//total weight is from current plus to the neighbor node
					pathsAndParents.put(e.destination, new Path(totalWeight, curr));	//add to HashMap
					//System.out.println("      Not in hash, adding " + e.destination.val + " to hash with weight " + totalWeight);
					dQueue.add(e.destination);			//add to queue to be processed
				}
			}
		}
		
		for(Node n : pathsAndParents.keySet())						//transfer info from helper HashMap to Dijkstra HashMap to be returned
			shortestPath.put(n, pathsAndParents.get(n).weight);
		
		return shortestPath;			//return the HashMap of shortest paths from source
	}
	
	//6b
	public GridGraph createRandomGridGraph(int n)	//create random grid maze
	{
		GridGraph randomGraph = new GridGraph(n);		//create a new grid graph of size n x n
		ArrayList<Integer> inGraph = new ArrayList<Integer>();		//create helper list
		int randNumber;		//helper variable
		for(int i = 0; i < n; i++)		//go through columns
		{
			for(int j = 0; j < n; j++)		//go through rows
			{
				randNumber = random.nextInt(n*10)+1;		//generate a random number to add to graph
				while(inGraph.contains(randNumber))			//if the number is already in graph, find new number
					randNumber = random.nextInt(n*10)+1;
				randomGraph.addGridNode(i, j, randNumber);		//add number to graph
				inGraph.add(randNumber);						//add number to helper list
			}
		}
		for(int i = 0; i < n; i++)		//go through maze columns
		{
			for(int j = 0; j < n; j++)		//go though maze rows
			{
				int randNum;		//random number variable
				if(i+1 < n)			//if there is a node to the right of the current node
				{
					randNum = random.nextInt(2);	//generate random number 0 or 1
					if(randNum == 0)				//add an edge if number is 0
						randomGraph.addUndirectedEdge(randomGraph.maze[i][j], randomGraph.maze[i+1][j]);
				}
				if(j+1 < n)			//if there is a node below the current node
				{
					randNum = random.nextInt(2);	//generate random number 0 or 1
					if(randNum == 0)				//add an edge if number is 0
						randomGraph.addUndirectedEdge(randomGraph.maze[i][j], randomGraph.maze[i][j+1]);
				}
			}
		}
		return randomGraph;		//return random maze
	}
	
	//6d
	public ArrayList<GridNode> astar(final GridNode source, final GridNode dest)	//returns list of A* path from source to dest
	{
		ArrayList<GridNode> aStarPath = new ArrayList<GridNode>();		//create path list
		
		HashMap<GridNode, int[]> nodeDistances = new HashMap<GridNode, int[]>();	//create HashMap of nodes and destination values
		int[] distances = {0, calculateManhattan(source, dest)};		//give destination values for source
		nodeDistances.put(source, distances);		//add source to HashMap
		GridNode curr = source;			//current node
		while(curr != dest)				//while current node is not the destination
		{
			//System.out.println("One node: " + curr.value);
			curr.visited = true;				//set current to visited
			if(!aStarPath.contains(curr))		//add to path if not in there
				aStarPath.add(curr);
			GridNode nextNode = null;			//next node helper variable
			int nextNodeValue = Integer.MAX_VALUE;	//next node helper variable
			
			for(GridNode neighbor : curr.neighbors)		//go through current's neighbors
			{
				//System.out.println("   On neighbor: " + neighbor.value);
				if(neighbor.visited == false)		//if neighbor is not visited
				{
					//System.out.println("      Node is not visited");
					int[] temp = nodeDistances.get(curr);	//get distance values of current node
					int[] dist = {temp[0]+1, calculateManhattan(neighbor, dest)};	//generate distance values of neighbor
					nodeDistances.put(neighbor, dist);		//add neighbor to HashMap
					
					int possibleSmallest = dist[0] + dist[1];		//calculate g+h of neighbor
					if(possibleSmallest < nextNodeValue)		//if neighbor has smallest g+h value, override helper variables
					{
						nextNode = neighbor;
						nextNodeValue = possibleSmallest;
						neighbor.parent = curr;				//set parent variable for backtracking
					}
				}
			}
			if(nextNodeValue == Integer.MAX_VALUE)		//if helper variable is still max, so no optimal neighbors were found
			{
				if(curr.parent == null)			//if on the source node, return null
					return null;
				aStarPath.remove(curr);			//remove current node from path
				curr = curr.parent;				//set current to parent
			}
			else			//an optimal neighbor was found
			{	
				curr = nextNode;	//set current to helper variable
				//System.out.println("Going to node: " + curr.value);
			}
		}
		aStarPath.add(curr);		//once current equals destination, add to path list
		
		return aStarPath;		//return path list
	}
	public int calculateManhattan(GridNode curr, GridNode goal)		//helper method to calculate Manhattan value
	{
		int currX = curr.xPos;
		int currY = curr.yPos;
		int goalX = goal.xPos;
		int goalY = goal.yPos;
		
		int xPos = Math.abs(currX - goalX);
		int yPos = Math.abs(currY - goalY);
		
		return (yPos + xPos);
	}
}