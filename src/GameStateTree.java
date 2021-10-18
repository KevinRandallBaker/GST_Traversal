import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class GameStateTree 
{
	private Node root;
	private String goalState;
	
	public Node getRoot()
	{
		return root;
	}
	
	public void setRoot(Node root)
	{
		this.root = root;
	}

	public String getGoalState() 
	{
		return goalState;
	}

	public void setGoalState(String goalState) 
	{
		this.goalState = goalState;
	}
	
	//Constructor
	public GameStateTree(Node root, String goalState)
	{
		this.root = root;
		this.goalState = goalState;
	}
	
	public void breadthFirstSearch()
	{
		Set<String> visited = new HashSet<String>();
	    Node node = new Node(root.getState());
	    Queue<Node> queue = new LinkedList<Node>(); 
	    Node currentNode = node;
	        
	    while (!currentNode.getState().equals(goalState)) // While states remain
	    {
	        visited.add(currentNode.getState()); // Initalize with root node
	        List<String> nodeSuccessors = getSuccessors(currentNode.getState());
	        for (String n : nodeSuccessors) 
	        {
	            if (visited.contains(n)) 
	                continue;
	            visited.add(n); 
	            
	            // Generate children
	            Node child = new Node(n);
	            currentNode.addChild(child);
	            child.setParent(currentNode);
	            queue.add(child);
	            
	        }
	        currentNode = queue.poll(); // Remove left-most state from open
	    }
	    
	    System.out.println("BFS SEARCH SOLUTION");
	    this.printStates(currentNode, visited, root);
	}
	
	public void depthFirstSearch() {
		// Create set of visisted states so no duplicates arrise
        Set<String> visited = new HashSet<String>();
        Node node = new Node(root.getState());
        

        MyQue<Node> mainQueue = new MyQue<>();
        
        MyQue<Node> successorsQueue = new MyQue<>();
        Node currentNode = node;
        while (!currentNode.getState().equals(goalState)) {
            visited.add(currentNode.getState());
            List<String> nodeSuccessors = getSuccessors(currentNode.getState());
            for (String n : nodeSuccessors) {
                if (visited.contains(n))
                    continue;
                visited.add(n);
                Node child = new Node(n);
                currentNode.addChild(child);
                child.setParent(currentNode);
                successorsQueue.enque(child);

            }
            
            mainQueue.addToQue(successorsQueue);
            
            successorsQueue.clear();
            currentNode = mainQueue.deque();

            nodeSuccessors.clear();
        }
        
        System.out.println("DFS SEARCH SOLUTION");
        this.printStates(currentNode, visited, root);

    }
	
	public static List<String>getSuccessors(String state)
	{
		List<String> successors = new ArrayList<String>();
		char temp = '\0';
		char[] tempState = state.toCharArray();
		
		switch(state.indexOf("0"))
		{
			case 0: 
			{
				temp = state.charAt(0); // holds value of empty cell to be swapped
				
				tempState[0] = tempState[1];
				tempState[1] = temp;
				successors.add(String.copyValueOf(tempState));
				
				tempState = state.toCharArray();
				
				tempState[0] = tempState[3];
				tempState[3] = temp;
				successors.add(String.copyValueOf(tempState));		

				break;
			}
			case 1:
			{
				temp = state.charAt(1);
				
				tempState[1] = tempState[0];
				tempState[0] = temp;
				successors.add(String.copyValueOf(tempState));
				
				tempState = state.toCharArray();
				
				tempState[1] = tempState[2];
				tempState[2] = temp;
				successors.add(String.copyValueOf(tempState));
				
				tempState = state.toCharArray();
				
				tempState[1] = tempState[4];
				tempState[4] = temp;
				successors.add(String.copyValueOf(tempState));
				
				break;
			}
			case 2:
			{
				temp = state.charAt(2);
				
				tempState[2] = tempState[1];
				tempState[1] = temp;
				successors.add(String.copyValueOf(tempState));
				
				tempState = state.toCharArray();
				
				tempState[2] = tempState[5];
				tempState[5] = temp;
				successors.add(String.copyValueOf(tempState));
				
				break;
			}
			case 3:
			{
				temp = state.charAt(3);
				
				tempState[3] = tempState[0];
				tempState[0] = temp;
				successors.add(String.copyValueOf(tempState));
				
				tempState = state.toCharArray();
				
				tempState[3] = tempState[4];
				tempState[4] = temp;
				successors.add(String.copyValueOf(tempState));
				
				tempState = state.toCharArray();
				
				tempState[3] = tempState[6];
				tempState[6] = temp;
				successors.add(String.copyValueOf(tempState));
				
				break;
			}
			case 4:
			{
				temp = state.charAt(4);
				
				tempState[4] = tempState[1];
				tempState[1] = temp;
				successors.add(String.copyValueOf(tempState));
				
				tempState = state.toCharArray();
				
				tempState[4] = tempState[3];
				tempState[3] = temp;
				successors.add(String.copyValueOf(tempState));
				
				tempState = state.toCharArray();
				
				tempState[4] = tempState[5];
				tempState[5] = temp;
				successors.add(String.copyValueOf(tempState));
				
				tempState = state.toCharArray();
				
				tempState[4] = tempState[7];
				tempState[7] = temp;
				successors.add(String.copyValueOf(tempState));
				
				break;
			}
			case 5:
			{
				temp = state.charAt(5);
				
				tempState[5] = tempState[2];
				tempState[2] = temp;
				successors.add(String.copyValueOf(tempState));
				
				tempState = state.toCharArray();
				
				tempState[5] = tempState[4];
				tempState[4] = temp;
				successors.add(String.copyValueOf(tempState));
				
				tempState = state.toCharArray();
				
				tempState[5] = tempState[8];
				tempState[8] = temp;
				successors.add(String.copyValueOf(tempState));
				
				
				break;
			}
			case 6:
			{
				temp = state.charAt(6);
				
				tempState[6] = tempState[3];
				tempState[3] = temp;
				successors.add(String.copyValueOf(tempState));
				
				tempState = state.toCharArray();
				
				tempState[6] = tempState[7];
				tempState[7] = temp;
				successors.add(String.copyValueOf(tempState));
				
				
				break;
			}
			case 7:
			{
				temp = state.charAt(7);
				
				tempState[7] = tempState[4];
				tempState[4] = temp;
				successors.add(String.copyValueOf(tempState));
				
				tempState = state.toCharArray();
				
				tempState[7] = tempState[6];
				tempState[6] = temp;
				successors.add(String.copyValueOf(tempState));
				
				tempState = state.toCharArray();
				
				tempState[7] = tempState[8];
				tempState[8] = temp;
				successors.add(String.copyValueOf(tempState));
				
				
				break;
			}
			case 8:
			{
				temp = state.charAt(8);
				
				tempState[8] = tempState[5];
				tempState[5] = temp;
				successors.add(String.copyValueOf(tempState));
				
				tempState = state.toCharArray();
				
				tempState[8] = tempState[7];
				tempState[7] = temp;
				successors.add(String.copyValueOf(tempState));
	
				break;
			}
		
		}
		
		return successors;
	}
	
	public static void printStates(Node goal, Set<String> visited, Node root)
	{
		Stack<Node> solution = new Stack<Node>();
		solution.push(goal);
		
		while(!goal.getState().equals(root.getState()))
		{
			solution.push(goal.getParent());
			goal = goal.getParent();
		}
		
		//String source = root.getState();
		//String destination;
		
		
		
//		for(int i = solution.size() - 1; i >= 0; i--)
//		{
//			System.out.println("~-~-~-~-~-~-~-~-~-");
//			System.out.println(solution.get(i).getState().substring(0, 3));
//			System.out.println(solution.get(i).getState().substring(3, 6));
//			System.out.println(solution.get(i).getState().substring(6, 9));
//			System.out.println("~-~-~-~-~-~-~-~-~-");
//		}
		
		System.out.println("Total of " + visited.size() + " states visited.");
	}
}


