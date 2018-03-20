package memo;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileWriter;

public class Memo_Save {
	public static void main(String args[]) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter printWriter = null;
		
		try
		{
			printWriter = new PrintWriter(new FileWriter("./memo.txt"));
			while(true)
			{
				String input = in.readLine();
				if(input == null)
				{break;}
				if(input.equals("/q"))
				{break;}
				printWriter.println(input);
			}
			printWriter.flush();
		}
		catch (IOException e)
		{e.printStackTrace();}
		finally
		{
			if(in != null)
			{
				try
				{
					in.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
			if(printWriter != null)
			{
				printWriter.close();
			}
		}
	}
}
