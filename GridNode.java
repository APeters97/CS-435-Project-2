import java.util.*;
class GridNode
{
	int xPos, yPos;
	int value;
	boolean visited;
	GridNode parent;	//used for backtracking
	List<GridNode> neighbors;
	public GridNode(final int x, final int y, final int val)
	{
		xPos = x;
		yPos = y;
		value = val;
		neighbors = new ArrayList<GridNode>();
		visited = false;
		parent = null;
	}
}