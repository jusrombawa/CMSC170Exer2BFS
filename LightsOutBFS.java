import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LightsOutBFS
{
	
	public static void main(String args[])
	{
		boolean switches[][] = new boolean[5][5];
		int stateCount = 0;
		LOState initState, state;
		
		switchInit("lightsout.in",switches);
	
		//print out initial switches array on console
		System.out.println("Initial lights out puzzle:");
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(switches[i][j]) System.out.print("1");
				else System.out.print("0");
			}
			System.out.println();
		}
		
		initState = new LOState(switches);
		 
	}
	
	//file reading for input
	private static boolean[][] switchInit(String fileName, boolean[][] switches)
	{
	
		BufferedReader buffread = null;
		FileReader fileread = null;		
		String curr;
		char[] line;
		int y = 0;
		
		try
		{
			fileread = new FileReader(fileName);
			buffread = new BufferedReader(fileread);
			
			//read line, convert to character array then base boolean line on char line
			while((curr =  buffread.readLine()) != null)
			{
				line = curr.toCharArray();
				for(int x=0;x<line.length;x++)
				{
					if(line[x] == '0')
						switches[x][y] = false;
					else if(line[x] == '1')
						switches[x][y] = true;
					else if(line[x] == '\n');
				}
				y++;
			}
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}

		finally
		{
			try
			{
				if(buffread != null)
					buffread.close();
				if(fileread != null)
					fileread.close();
			}
			
			catch(IOException ie)
			{
				ie.printStackTrace();
			}
		}
		
		return switches;
	}
	
//end of class
}


