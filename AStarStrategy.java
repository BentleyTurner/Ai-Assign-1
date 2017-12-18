package ai.assign.pkg1;
import java.util.*;

public class AStarStrategy extends SearchMethod {
	
	public AStarStrategy()
	{
		code = "ASTAR";
		longName = "A-Star Search";
		Fringe = new Frontier();
		Searched = new LinkedList<PuzzleState>();
	}
	
	protected PuzzleState popFrontier()
	{
		//remove an item from the fringe to be searched
		PuzzleState thisState = Fringe.Pop();
		//Add it to the list of searched states, so that it isn't searched again
		Searched.add(thisState);
		
		return thisState;
	}
	
	@Override
	public direction[] Solve(nPuzzle puzzle) {
		//This method uses the fringe as a queue.
		//Therefore, nodes are searched in order of cost, with the lowest cost
		// unexplored node searched next.
		//-----------------------------------------
		
		//put the start state in the Fringe to get explored.
		addToFrontier(puzzle.StartState);
		
		
		ArrayList<PuzzleState> newStates = new ArrayList<PuzzleState>();
				
		while(Fringe.size() > 0)
		{
			//get the next item off the fringe
			PuzzleState thisState = popFrontier();
                        
			
			//is it the goal item?
			if(thisState.equals(puzzle.GoalState))
			{
				//We have found a solution! return it!
				return thisState.GetPathToState();
			}
			
				//This isn't the goal, just explore the node
				
                                newStates = thisState.explore();
				
				for(int i = 0; i < newStates.size(); i++)
				{
                                    PuzzleState Neighbour = newStates.get(i);
                                    
                                    int starCost = thisState.Cost +  HeuristicValue(thisState, Neighbour);
                                    if(starCost < Neighbour.Cost || !Searched.contains(Neighbour))
                                    {
                                        Neighbour.Parent = thisState;
                                        Neighbour.Cost = starCost;
                                        Neighbour.setEvaluationFunction(Neighbour.Cost + HeuristicValue(Neighbour, puzzle.GoalState));
                                        addToFrontier(Neighbour);
                                        
                                    }
                                    
                                    
                                }
                                Collections.sort(Fringe.Items, new PuzzleComparator());
			
		}
		
		//No solution found and we've run out of nodes to search
		//return null.
		return null;
	}
	
        
	public boolean addToFrontier(PuzzleState aState)
	{
		//if this state has been found before,
		if(Searched.contains(aState) || Fringe.contains(aState))
		{
			//discard it
			return false;
		}
		else
		{
			//else put this item on the end of the queue;
			Fringe.add(aState);
			return true;
		}
	}
        
        private int HeuristicValue(PuzzleState aState, PuzzleState goalState)
	{
		//find out how many elements in aState match the goalState
		//return the number of elements that don't match
		int heuristic = 0;
		for(int i = 0; i < aState.Puzzle.length; i++)
		{
			for(int j = 0; j < aState.Puzzle[i].length; j++)
			{
				if(aState.Puzzle[i][j] != goalState.Puzzle[i][j])
					heuristic++;
			}
		}
		
		return heuristic;
	}

}
