package calc;
import java.util.*;
public class Calc {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String a[] = new String[3];
		double calc = 0;
	
		while(true)
		{
			System.out.print("����� ���� ���� �����Ͽ� �Է��ϼ��� : ");
			a[0] = sc.next();
			a[1] = sc.next();
			a[2] = sc.next();
			double s1 = Double.parseDouble(a[0]);
			char buho =a[1].charAt(0);
			double s2 = Double.parseDouble(a[2]);
			
			if(buho=='+')
			{
				calc = s1 + s2;
				System.out.println(calc);
			}
			else if(buho =='-')
			{
				calc = s1 - s2;
				System.out.println(calc);
			}
			else if(buho == '*')
			{
				calc = s1 * s2;
				System.out.println(calc);
			}
			else if(buho == '/')
			{
				calc = s1 / s2;
				System.out.println(calc);
			}
			else if(s1=='q')
			{
				System.out.println("����");
				break;
			}
			else {System.out.println("�ٽ� �Է��ϼ���");}
		}
	}
}
