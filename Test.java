import java.util.*;
public class Test
{
	Random random = new Random();
	GraphSearch gs = new GraphSearch();
	public static void main(String[]args)
	{
		Main part1 = new Main();
		Main part2 = new Main();
		Test test = new Test();
		Test reset = new Test();

//Question 3 - Graph Test///////////////////////////////////////
		
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
			
		test1.addNode_TEST_ONLY(gS);
		test1.addNode_TEST_ONLY(gA);
		test1.addNode_TEST_ONLY(gB);
		test1.addNode_TEST_ONLY(gC);
		test1.addNode_TEST_ONLY(gD);
		test1.addNode_TEST_ONLY(gE);
		test1.addNode_TEST_ONLY(gF);
		test1.addNode_TEST_ONLY(gG);
		test1.addNode_TEST_ONLY(gH);
		test1.addNode_TEST_ONLY(gX);
		
//DFS Recursive Test//////////////////////////////
		System.out.println("\nDFS Recursive Test");
		ArrayList<Node> dfsSearchRec = test.gs.DFSRec(gS, gD);
		System.out.print("Start: S, End: D - ");
		if(dfsSearchRec == null)
			System.out.println("There is no DFS path between " + gS.val + " and " + gD.val);
		else
			for(Node n : dfsSearchRec)
				System.out.print(n.val + " ");
		//Reset graph
		reset.resetGraph(test1);
		System.out.println();
		
		dfsSearchRec = part1.gs.DFSRec(gS, gX);
		System.out.print("Start: S, End: X - ");
		if(dfsSearchRec == null)
			System.out.println("There is no DFS path between " + gS.val + " and " + gX.val);
		else
			for(Node n : dfsSearchRec)
				System.out.print(n.val + " ");
		//Reset graph
		reset.resetGraph(test1);
		System.out.println();
//////////////////////////////////////////////////		
		
//DFS Iterative Test/////////////////////////////
		System.out.println("DFS Iterative Test");
		ArrayList<Node> dfsSearchIter = test.gs.DFSIter(gS, gD);
		System.out.print("Start: S, End: D - ");
		if(dfsSearchIter == null)
			System.out.println("There is no DFS path between " + gS.val + " and " + gD.val);
		else
			for(Node n : dfsSearchIter)
				System.out.print(n.val + " ");
		//Reset graph
		reset.resetGraph(test1);
		System.out.println();
	
		dfsSearchIter = part1.gs.DFSIter(gS, gX);
		System.out.print("Start: S, End: X - ");
		if(dfsSearchIter == null)
			System.out.println("There is no DFS path between " + gS.val + " and " + gX.val);
		else
			for(Node n : dfsSearchIter)
				System.out.print(n.val + " ");
		//Reset graph
		reset.resetGraph(test1);
		System.out.println();
//////////////////////////////////////////////////	
		
//BFS Recursive Test/////////////////////////////
		System.out.println("BFS Recursive Test");
		ArrayList<Node> bfsSearchRec = test.gs.BFTRec(test1);
		for(Node n : bfsSearchRec)
			System.out.print(n.val + " ");
		
		//Reset graph
		reset.resetGraph(test1);
		System.out.println("\n");
//////////////////////////////////////////////////
		
//BFS Recursive Test/////////////////////////////
		System.out.println("BFS Iterative Test");
		ArrayList<Node> bfsSearchIter = test.gs.BFTIter(test1);
		for(Node n : bfsSearchIter)
			System.out.print(n.val + " ");
		
		//Reset graph
		reset.resetGraph(test1);
		System.out.println("\n");
//////////////////////////////////////////////////
				
//BFS Recursive Linked List Test//////////////////
		System.out.println("BFS Recursive Linked List Test");
		ArrayList<Node> bfsRecLL = part1.BFTRecLinkedList(10);
		for(Node n : bfsRecLL)
			System.out.print(n.value + " ");
		
		//Reset graph
		reset.resetGraph(test1);
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
		DirectedGraph kahnTraversalGraph = part2.createRandomDAGIter(1000);
		ArrayList<Node> kahnTraversal = ts.Kahns(kahnTraversalGraph);
		for(Node n : kahnTraversal)
			System.out.println(n.value + " ");
//////////////////////////////////////////////////

//mDFS Traversal Test/////////////////////////////
		System.out.println("mDFS Traversal Test");
		DirectedGraph mdfsTraversalGraph = part2.createRandomDAGIter(1000);
		ArrayList<Node> mdfsTraversal = ts.Kahns(mdfsTraversalGraph);
		for(Node n : mdfsTraversal)
			System.out.println(n.value + " ");
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
		
//Weighted Linked List Graph Testing/////////////////
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
		
		dijkstraTest.addNode_TEST_ONLY(dA);
		dijkstraTest.addNode_TEST_ONLY(dB);
		dijkstraTest.addNode_TEST_ONLY(dC);
		dijkstraTest.addNode_TEST_ONLY(dD);
		dijkstraTest.addNode_TEST_ONLY(dE);
		dijkstraTest.addNode_TEST_ONLY(dF);
		dijkstraTest.addNode_TEST_ONLY(dG);
		dijkstraTest.addNode_TEST_ONLY(dH);
		dijkstraTest.addNode_TEST_ONLY(dI);
		
		
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
		GridNode randDest = randomGraphTest.maze[99][99];
		
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
}