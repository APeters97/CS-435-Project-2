import java.util.HashSet;

public class GridGraph
{
	//6a
	GridNode[][] maze;			//variable to store all nodes in maze
	public GridGraph(final int n)		//create maze of size n x n
	{
		maze = new GridNode[n][n];
	}
	public void addGridNode(final int x, final int y, int nodeVal)	//add node of value nodeVal to position x,y
	{
		maze[x][y] = new GridNode(x, y, nodeVal);
	}
	
	public void addUndirectedEdge(final GridNode first, final GridNode second)	//add edge between first and second
	{
		int firstXPos = first.xPos;
		int firstYPos = first.yPos;
		int secondXPos = second.xPos;
		int secondYPos = second.yPos;
		if(firstXPos+1 == secondXPos && firstYPos == secondYPos)	//check that second is right neighbor of first
		{
			//if nodes are not already neighbors, add to each others neighbor's list
			if(!first.neighbors.contains(second) && !second.neighbors.contains(first))
			{
				first.neighbors.add(second);
				second.neighbors.add(first);
			}
		}
		else if(firstXPos == secondXPos && firstYPos+1 == secondYPos)	//check that second is bottom neighbor of first
		{
			//if nodes are not already neighbors, add to each others neighbor's list
			if(!first.neighbors.contains(second) && !second.neighbors.contains(first))
			{
				first.neighbors.add(second);
				second.neighbors.add(first);
			}
		}
		else if(firstXPos-1 == secondXPos && firstYPos == secondYPos)	//check that second is left neighbor of first
		{
			//if nodes are not already neighbors, add to each others neighbor's list
			if(!first.neighbors.contains(second) && !second.neighbors.contains(first))
			{
				first.neighbors.add(second);
				second.neighbors.add(first);
			}
		}
		else if(firstXPos == secondXPos && firstYPos-1 == secondYPos)	//check that second is above neighbor of first
		{
			//if nodes are not already neighbors, add to each others neighbor's list
			if(!first.neighbors.contains(second) && !second.neighbors.contains(first))
			{
				first.neighbors.add(second);
				second.neighbors.add(first);
			}
		}
	}
	
	public void removeUndirectedEdge(final GridNode first, final GridNode second)	//remove edge between first and second
	{
		if(first.neighbors.contains(second) && second.neighbors.contains(first))	//remove edge if the edge exists
		{
			first.neighbors.remove(second);
			second.neighbors.remove(first);
		}
	}
	
	public HashSet<GridNode> getAllNodes()	//returns HashSet of all nodes in maze
	{
		HashSet<GridNode> allNodes = new HashSet<GridNode>();		//create new set
		for(int i = 0; i < maze.length; i++)
		{
			for(int j = 0; j < maze.length; j++)
			{
				allNodes.add(maze[i][j]);
			}
		}
		
		return allNodes;		//return HashSet
	}
}