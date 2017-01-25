import java.util.LinkedList;


public class LOState
{

	boolean[][] switches;
	boolean win;
	LinkedList<Integer> parents;

	//init state, no previous
	public LOState(boolean[][] switches)
	{
		this.switches = switches;
		win = winCheck();
		parents = new LinkedList<Integer>();
		
	}
	
	//normal states, with parent state
	public LOState(boolean[][] switches, int parentLocation, LinkedList<Integer> ancestors)
	{
		this.switches = switches;
		this.parents = ancestors;
		parents.add(new Integer(parentLocation));
		win = winCheck();
	}
	
	private boolean winCheck()
	{
		boolean win = false;
	
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(switches[i][j] == false)
				{
					win = true;
				}
				else
				{
					//still not winning if at least one on switch
					win = false;
					return win;
				}
			}
		}
		
		return win;
	}
}
