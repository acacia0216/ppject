package memo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;/////////////////////////////////////////////////////////////����
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Memo {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		String memo;
		File file = new File("memoEx.txt");
		FileWriter fw = null;//.txt�� ����� FileWriter��ü�� �����Ѵ�
		while(true)//���ѷ���
		{
			try//�õ�
			{
//				InputStreamReader isr = new InputStreamReader(System.in);
				fw = new FileWriter(file,false);
				memo = sc.nextLine();//memo�� Scanner�� �̿��� ���پ� �Է¹޴´�
//				PrintWriter pw = new PrintWriter(fw);
				fw.flush();//�Է¹��� ���۸� ���Ͽ� ��������
				
				if(memo.equals("/q"))///q�� ������
				{
					System.out.println("����");//����޽��� �����
					break;//����
					
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
//		while(true)//���ѷ���
//		{
//			try//�õ�
//			{
//				memo = sc.nextLine();//memo�� �Է°� ����
//				PrintWriter  p = new PrintWriter(new FileWriter("memo.txt"));//memo.txt�� ����
//				if(memo.equals("/q"))//"/q"������
//				{
//					p.flush();//
//					System.out.println("���α׷� ����");//ȭ�����
//					break;//����
//				}
//			}
//			catch(Exception e)//����,���� 
//			{
//				e.printStackTrace();
//			}
//			
//		}	
	}
}
