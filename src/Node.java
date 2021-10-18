import java.util.ArrayList;

public class Node 
{
	private String state;
	private ArrayList<Node> children;
	private Node parent;
	private int cost;
	private int estimatedCostToGoal;
	private int totalCost;
	private int depth;
	public boolean visited;
	
	public void setState(String state) 
	{
		this.state = state;
	}
	
	public Node getParent() 
	{
		return parent;
	}
	
	public void setParent(Node parent) 
	{
		this.parent = parent;
	}
	
	public int getCost() 
	{
		return cost;
	}
	
	public void setCost(int cost) 
	{
		this.cost = cost;
	}
	
	public int getEstimatedCostToGoal() 
	{
		return estimatedCostToGoal;
	}

	public void setEstimatedCostToGoal(int estimatedCostToGoal) 
	{
		this.estimatedCostToGoal = estimatedCostToGoal;
	}
	
	public int getTotalCost() 
	{
		return totalCost;
	}
	
	public void setTotalCost(int totalCost) 
	{
		this.totalCost = totalCost;
	}
	
	public void setTotalCost(int cost, int estimatedCost)
	{
		this.totalCost = cost + estimatedCost;
	}
	
	public int getDepth() 
	{
		return this.depth;
	}
	
	public void setDepth(int depth) 
	{
		this.depth = depth;
	}
	
	public boolean isVisited()
	{
		return this.visited;
	}
	
	public void setVisited(boolean visited)
	{
		this.visited = visited;
	}
	
	public ArrayList<Node> getChildren()
	{
		return this.children;
	}
	
	public void addChild(Node child)
	{
		this.children.add(child);
	}
	
	public String getState()
	{
		return this.state;
	}
	
	// Constructor
	public Node(String state)
	{
		this.state = state;
		this.children = new ArrayList<Node>();
	}
	
	
	
	
	
}
