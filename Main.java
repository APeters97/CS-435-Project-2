import java.util.*;

public class Main
{
	Random random = new Random();
	GraphSearch gs = new GraphSearch();
	//3b
	public Graph createRandomUnweightedGraphIter(final int n)	//create random unweighted graph
	{
		Graph newGraph = new Graph();		//create graph to return
		ArrayList<Integer> inGraph = new ArrayList<Integer>();
		int nodeCounter = 0, randNum, randNode;	//helper variables
		while(nodeCounter != n)			//add n number of nodes to graph
		{
			randNum = random.nextInt(n*10)+1;		//generate a random number to add to graph
			while(inGraph.contains(randNum))			//if the number is already in graph, find new number
				randNum = random.nextInt(n*10)+1;
			newGraph.addNode(randNum);		//add number to graph
			inGraph.add(randNum);			//add number to helper list
			nodeCounter++;
		}
		for(Node x : newGraph.vertices)		//go through all nodes of the graph
		{
			randNum = random.nextInt(3)+1;	//generate a random number: 1, 2, or 3 - how many neighbors the node will have
			for(int i = 0; i < randNum; i++)	//execute 1, 2, or 3 times
			{
				randNode = random.nextInt(n);	//used to find a random node in the graph
				Node node = newGraph.vertices.get(randNode);	//get a random node from the graph
				
				//if current node and random node do not have 3 neighbors already, add an edge between them
				if(x.neighbors.size() < 3 && node.neighbors.size() < 3)	
				{
					if(x.value != node.value)	//add an edge if the current node and random node are not the same
						newGraph.addUndirectedEdge(x, node);
				}
			}
		}
		
		return newGraph;
	}
	
	//3c
	public Graph createLinkedList(final int n)	//create a linked list graph
	{
		Graph newLL = new Graph();		//create new graph to return
		for(int i = 1; i <= n; i++)			//add n number of nodes to graph
			newLL.addNode(i);
		
		List<Node> tempVertices = newLL.vertices;	//helper variable
		
		//go through all nodes in graph, and add an edge to a node and the one after it
		for(int i = 0; i < n-1; i++)		
			newLL.addUndirectedEdge(tempVertices.get(i), tempVertices.get(i+1));
		
		return newLL;		//return created graph
	}
	
	//3h
	public ArrayList<Node> BFTRecLinkedList(final int n)	//call BFT recursive on a linked list
	{
		Graph LLgraph = createLinkedList(n);	//create new linked list graph
		return(gs.BFTRec(LLgraph));				//call recursive BFT on graph
	}
	
	//3i
	public ArrayList<Node> BFSIterLinkedList(final int n)	//call BFT iterative on a linked list
	{
		Graph LLgraph = createLinkedList(n);	//create linked list graph
		return(gs.BFTIter(LLgraph));		//call iterative BFT on graph
	}
	
	//4c
	public DirectedGraph createRandomDAGIter(final int n)	//create random directed graph
	{
		DirectedGraph newDAG = new DirectedGraph();		//create DAG to return
		ArrayList<Integer> inGraph = new ArrayList<Integer>();		//create helper list
		int nodeCounter = 0, randNum, randNode;	//helper variables
		while(nodeCounter != n)			//add n number of nodes to graph
		{
			randNum = random.nextInt(n*10)+1;		//generate a random number to add to graph
			while(inGraph.contains(randNum))			//if the number is already in graph, find new number
				randNum = random.nextInt(n*10)+1;
			newDAG.addNode(randNum);		//add number to graph
			inGraph.add(randNum);			//add number to helper list
			nodeCounter++;
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
		for(int i = 0; i < n; i++)		//add n number of nodes to graph
			newWeightedLL.addNode(i);
		
		int randomWeight = random.nextInt(10)+1;	//generate a random uniform weight
		
		for(int i = 0; i < n-1; i++)	//go through all nodes in graph, and add an edge to a node and the one after it
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
		for(Edge e: start.weightedNeighbors)		//look at start's neighbors and add to HashMap with weight from source
		{
			//System.out.println("Adding " + e.destination.val + " to hash with weight " + e.weight);
			pathsAndParents.put(e.destination, new Path(e.weight, start));
			dQueue.add(e.destination);			//add node to queue to be processed
		}
		
		while(!dQueue.isEmpty())		//while there are nodes to process
		{			
			Node curr = dQueue.poll();		//get the current node
			curr.visited = true;			//set to visited
			//System.out.println("\nOn node: " + curr.val);
			//System.out.println("Current weight: " + pathsAndParents.get(curr).weight + " with parent " + pathsAndParents.get(curr).parent.val);
			for(Edge e : curr.weightedNeighbors)		//look through current node's neighbors
			{
				//System.out.println("   Neighbor: " + e.destination.val);
				
				//if the neighbor node is currently in the HashMap, check if weight needs to be updated
				if(pathsAndParents.containsKey(e.destination))
				{
					Path currentNode = pathsAndParents.get(curr);			//grab the path info of the current node
					int currentToNextNode = currentNode.weight + e.weight;
					
					Path nextNode = pathsAndParents.get(e.destination);		//grab the path info of the current neighbor node
					int existingPathToNext = nextNode.weight;
					
					//System.out.println("      Existing weight: " + existingPathToNext);
					//System.out.println("      Possible new weight: " + currentToNextNode);
					
					//if the weight of the new path is less than weight of old path, replace path
					if(currentToNextNode < existingPathToNext)
					{
						//System.out.println("         Replacing weight path");
						pathsAndParents.replace(e.destination, new Path(currentToNextNode, curr));
					}
					else
						//System.out.println("         Not replacing weight path");
					
					//if the neighbor node has not been processed yet, add to queue
					if(e.destination.visited == false && !dQueue.contains(e.destination))
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
		
		for(Node n : pathsAndParents.keySet())		//transfer info from helper HashMap to Dijkstra HashMap to be returned
			shortestPath.put(n, pathsAndParents.get(n).weight);
		
		return shortestPath;	//return the HashMap of shortest paths from source
	}
	
	//6b
	public GridGraph createRandomGridGraph(final int n)	//create random grid maze
	{
		GridGraph randomGraph = new GridGraph(n);		//create a new grid graph of size n x n
		ArrayList<Integer> inGraph = new ArrayList<Integer>();		//create helper list
		int randNumber;		//helper variable
		for(int i = 0; i < n; i++)		//go through columns
		{
			for(int j = 0; j < n; j++)		//go through rows
			{
				randNumber = random.nextInt(n*100)+1;		//generate a random number to add to graph
				while(inGraph.contains(randNumber))			//if the number is already in graph, find new number
					randNumber = random.nextInt(n*100)+1;
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
	public int calculateManhattan(final GridNode curr, final GridNode goal)		//helper method to calculate Manhattan value
	{
		
		int xPos = Math.abs(curr.xPos - goal.xPos);
		int yPos = Math.abs(curr.yPos - goal.yPos);
		
		return (yPos + xPos);
	}
}