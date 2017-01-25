import java.util.LinkedList;


public class LOState
{

	boolean[][] switches;
	boolean win;
	LinkedList<int> parents;

	//init state, no previous
	public LOState(boolean[][] switches)
	{
		this.switches = switches;
		win = winCheck();
		parents = new LinkedList<int>();
		
	}
	
	//normal states, with parent state
	public LOState(boolean[][] switches, int parentLocation)
	{
		this.switches = switches;
		
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
