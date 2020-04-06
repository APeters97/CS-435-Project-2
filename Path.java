class Path		//used for dijkstra testing
{
	Node parent;
	int weight;
	public Path(int w, Node p)
	{
		weight = w;
		parent = p;
	}
}