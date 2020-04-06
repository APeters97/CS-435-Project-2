import java.util.*;
class GridNode
{
	int xPos, yPos;
	int value;
	boolean visited;
	GridNode parent;	//used for backtracking
	List<GridNode> neighbors;
	public GridNode(int x, int y, int val)
	{
		xPos = x;
		yPos = y;
		value = val;
		neighbors = new ArrayList<GridNode>();
		visited = false;
		parent = null;
	}
}