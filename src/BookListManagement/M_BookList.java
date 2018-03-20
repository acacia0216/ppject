package BookListManagement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class M_BookList {
	
	static Scanner sc = new Scanner(System.in);
	static String book[][] = new String[10][5];
	
	public static void main(String args[]) {
		M_BookList bl = new M_BookList();
		bl.home();
	}
	private void home()
	{
		for(int i=0; i<10; i++)
		{
			book[i][0] = String.valueOf(i);
			
		}
		System.out.println("======================");
		System.out.println("도서 입출력관리 시스템");
		System.out.println("======================");
		System.out.println("1. 도서 입력");
		System.out.println("2. 목록 조회");
		System.out.println("3. 도서 검색");
		System.out.println("4. 저자 검색");
		System.out.println("5. 파일 내보내기(저장)");
		System.out.println("6. 파일 불러오기");
		System.out.println("7. 종료");
		System.out.print("항목을 선택하세요 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		switch(num)
		{
		case 1 : insert();
		break;
		case 2 : listView();
		break;
		case 3 : tSearch();
		break;
		case 4 : aSearch();
		break;
		case 5 : fileExport();
		break;
		case 6 : fileImport();
		break;
		case 7 : quit();
		break;
		}
	}
	private void insert()
	{
		int input;
		System.out.print("몇번째 줄에 입력할까요 : ");
		input = sc.nextInt();
		sc.nextLine();
		
		System.out.println("제목, 저자, 발행일, 가격 순으로 입력하세요");
		System.out.println("(항목별 띄어쓰기)");
		for(int i=1; i<5; i++)
			
		{
			book[input][i] = sc.next();
		}
		System.out.println();
		
		listView();
	}
	private void delete()
	{
		String input;
		System.out.println("삭제할 도서명을 입력하세요");
		input = sc.nextLine();

		for(int i=0; i<10; i++)
		{
			if(book[i][1].equals(input))
			{
				i=0;
				for(int k=1; k<5; k++)
				{
					book[i][k] = "null";
				}
			}
		}
		System.out.println();
		listView();
	}
	private void listView()
	{
		for(int i=0; i<10; i++)
		{
			for(int j=0; j<5; j++)
			{
				System.out.print("["+book[i][j]+"]");
			}
			System.out.println();
		}
		System.out.println("====================");
		System.out.println("1. 도서 입력");
		System.out.println("2. 도서 삭제");
		System.out.println("3. 처음으로");
		System.out.print("항목을 선택하세요 : ");
		int num = sc.nextInt();
		sc.nextLine();
		switch(num)
		{
		case 1: insert();
		break;
		case 2: delete();
		break;
		case 3: home();
		break;
		}
	}
	private void tSearch()//제목검색
	{
		String input;
		System.out.print("제목을 입력하세요 : ");
		input = sc.nextLine();
		
		for(int i=0; i<10; i++)
		{
			if(book[i][0].equals(input))
			{
				for(int j=1; j<5; j++)
				{
					System.out.print("["+book[i][j]+"]");
				}
				System.out.println();
			}
			System.out.println("해당 제목의 도서가 존재하지 않습니다.");
		}
		System.out.println("====================");
		System.out.println("1. 도서 입력");
		System.out.println("2. 도서 삭제");
		System.out.println("3. 처음으로");
		System.out.print("항목을 선택하세요 : ");
		int num = sc.nextInt();
		sc.nextLine();
		switch(num)
		{
		case 1: insert();
		break;
		case 2: delete();
		break;
		case 3: home();
		break;
		}
	}
	private void aSearch()//저자검색
	{
		String input;
		System.out.print("저자 이름을 입력하세요 : ");
		input = sc.nextLine();
		
		for(int i=0; i<10; i++)
		{
			if(book[i][2].equals(input))
			{
				for(int j=1; j<5; j++)
				{
					System.out.print("["+book[i][j]+"]");
				}
				System.out.println();
			}
			System.out.println("해당 저자의 도서가 없습니다.");
		}
		System.out.println("====================");
		System.out.println("1. 도서 입력");
		System.out.println("2. 도서 삭제");
		System.out.println("3. 처음으로");
		System.out.print("항목을 선택하세요 : ");
		int num = sc.nextInt();
		sc.nextLine();
		switch(num)
		{
		case 1: insert();
		break;
		case 2: delete();
		break;
		case 3: home();
		break;
		}
	}
	
	private void fileExport()
	{
		try {
			FileWriter fw = new FileWriter("d:/javaStudy/workspace/BookList.txt");
			
			System.out.println("파일이 저장되었습니다.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				home();
			}
			home();
		}
		catch (IOException e) {
			System.out.println("저장 실패.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				home();
			}
			home();
		}
	}
	
	private void fileImport()
	{
		try 
		{
			while(sc.hasNext())
			{
				BufferedReader br = new BufferedReader(new FileReader("d:/javaStudy/workspace/BookList.txt"));
				try {
					book[10][5] = br.readLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					home();
				}
				System.out.println("파일을 불러왔습니다.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					home();
				}
				home();
			}
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("파일이 존재하지 않습니다.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				home();
			}
			home();
		}
	}
	
	private void quit()
	{
		System.out.println("프로그램을 종료합니다.");
		sc.close();
		System.exit(0);
	}
}
