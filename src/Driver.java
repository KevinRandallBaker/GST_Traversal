import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Driver
{
    public static void main(String[] args) throws FileNotFoundException
    {
    	String givenState = "283"
    					  + "164"
    					  + "705";
    	
    	String goalState = "123"
    					 + "804"
    					 + "765";
    	
    	String easyState = "134"
    					 + "862"
    					 + "705";
    	
    	String medState = "281"
    					+ "043"
    					+ "765";
    	
    	String hardState = "281"
    					 + "463"
    					 + "075";
    	
    	String worstState = "567"
    					  + "408"
    					  + "321";
    	
    	
    	String[] stateArray = {givenState, easyState, medState, hardState, worstState};
    	
    	PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
    	System.setOut(out);
    	
    	for(int i = 0; i < stateArray.length; i++)
    	{
    		GameStateTree gameTree = new GameStateTree(new Node(stateArray[i]), goalState);
    		System.out.println("[PUZZLE DIFFICULTY: " + (i + 1) + "]");
    		
    		long startTime = System.nanoTime();
        	gameTree.breadthFirstSearch();
        	long finishTime = System.nanoTime();
        	long totalTime = finishTime - startTime;
        	System.out.println("BFS Time: " + totalTime + " nano seconds.");
        	
        	System.out.println("-------------------------------------------");
        	
        	startTime = System.nanoTime();
        	gameTree.depthFirstSearch();
        	finishTime = System.nanoTime();
        	totalTime = finishTime - startTime;
        	System.out.println("DFS Time: " + totalTime + " nano seconds." + "\n");
        	
    	}
    	
    	
    }
}

