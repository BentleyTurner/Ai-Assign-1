package ai.assign.pkg1;

import java.util.*;

public class Frontier {
	//We can use a linked list here because it's more efficient than an array
	//and because we only want to add/remove items from the start or end.
	public LinkedList<PuzzleState> Items;
	
	public Frontier()
	{
		Items = new LinkedList<PuzzleState>();
	}
	
	public PuzzleState Pop()
	{	
		return Items.pop();
	}
	
	public void Push(PuzzleState aState)
	{
		Items.push(aState);
	}
        
        public void clear()
	{
		Items.clear();
	}
        
        public int size()
	{
		return Items.size();
	}
        
        public void add( PuzzleState aState)
        {
            Items.add(aState);
        }
        
        public boolean contains( PuzzleState aState)
        {
            return Items.contains(aState);
        }
        
        public void addLast( PuzzleState aState)
        {
            Items.addLast(aState);
        }
        
        public PuzzleState pollFirst()
        {
            return Items.pollFirst();
        }
        
	public void Push(PuzzleState[] aStates)
	{
		for(int i = 0; i < aStates.length; i++)
		{
			//add each item at the start of the list.
			Items.push(aStates[i]);
		}
	}
	
	public void Enqueue(PuzzleState aState)
	{
		//This can be done using the addToArray method from the nPuzzler class
		Items.offer(aState);
	}
	
	public void Enqueue(PuzzleState[] aStates)
	{
		//This can be done using the addToArray method from the nPuzzler class
		for(int i = 0; i < aStates.length; i++)
		{
			Items.offer(aStates[i]);
		}
	}
	
	public void SortByCostAsc()
	{
            int min = Items.getFirst().Cost;
            
		//TODO: Implement SortByCostAsc()
                 for(int i = 0; i < Items.size(); i++)
		{
			if(Items.get(i).Cost < min)
                        {
                            min = Items.get(i).Cost;
                            PuzzleState temp = Items.get(i);
                            Items.remove(i);
                            Items.addFirst(temp);
 
                        }
                }
		
	}
	
	public void SortByCostDesc()
	{
		//TODO: Implement SortByCostDesc() 
            int max = Items.getFirst().Cost;
            
		//TODO: Implement SortByCostAsc()
                 for(int i = 0; i < Items.size(); i++)
		{
			if(Items.get(i).Cost < max)
                        {
                            max = Items.get(i).Cost;
                            PuzzleState temp = Items.get(i);
                            Items.remove(i);
                            Items.addFirst(temp);
 
                        }
                }
		
	}
	
	public void SortByHeuristicAsc()
	{
		//TODO: Implement SortByHeuristicAsc()
            int min = Items.getFirst().HeuristicValue;
            
		//TODO: Implement SortByCostAsc()
                 for(int i = 0; i < Items.size(); i++)
		{
			if(Items.get(i).HeuristicValue < min)
                        {
                            min = Items.get(i).HeuristicValue;
                            PuzzleState temp = Items.get(i);
                            Items.remove(i);
                            Items.addFirst(temp);
 
                        }
                }
		
	}
	
	public void SortByHeuristicDesc()
	{
		//TODO: Implement SortByHeuristicDesc()
            int min = Items.getFirst().HeuristicValue;
            
		//TODO: Implement SortByCostAsc()
                 for(int i = 0; i < Items.size(); i++)
		{
			if(Items.get(i).HeuristicValue < min)
                        {
                            min = Items.get(i).HeuristicValue;
                            PuzzleState temp = Items.get(i);
                            Items.remove(i);
                            Items.addFirst(temp);
 
                        }
                }
		
	}
}

