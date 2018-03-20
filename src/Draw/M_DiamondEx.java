package Draw;

import java.util.Scanner;

public class M_DiamondEx {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		
		for(int i=0; i<=n; i++)
		{
			for(int j=n; j>=i; j--)
			{
				System.out.print(" ");
			}
			for(int k=0; k<=i*2; k++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<i+2; j++)
			{
				System.out.print(" ");
			}
			for(int k=n*2; k>i*2+1; k--)
			{
				System.out.print("*");
			}
			System.out.println();
		}

	}
}
