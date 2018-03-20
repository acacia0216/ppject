package memo;
import java.awt.FileDialog;
import java.io.BufferedWriter;//���۵Ȱ� ����
import java.io.FileWriter;//���Ͽ� ����
import java.io.IOException;

public class FileSave implements M_Frame{
	public FileSave()
	{
		FileDialog dialog = new FileDialog(this, "����", FileDialog.SAVE);
		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter("example.txt"));
			String str = "�̰� �޸��忡�� ��� ��������...";
			
			bw.write(str); bw.newLine();
			
			bw.close();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}
}
