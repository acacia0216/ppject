package memo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileOpen{
	public static void main(String args[]) {
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("example.txt"));
			String str = null;//�о���� ��������
			
			while(true)
				{
					if(str==null)
					{
						break;
					}
					System.out.println(str);
				
				}
			
		}
		catch(IOException e)
		{
			System.err.println(e);
			System.exit(1);
		}
	}
}