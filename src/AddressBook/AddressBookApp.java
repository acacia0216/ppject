package AddressBook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookApp {
	public static void main(String args[]) throws FileNotFoundException, IOException {
		
		Scanner sc = new Scanner(System.in);
		Scanner isc = new Scanner(System.in);
		  
		List<PersonInfo> address = new ArrayList<PersonInfo>();//리스트생성
		Reader fr = new FileReader("C:\\eclipse-jee-oxygen-2-win32-x86_64\\eclipse\\workspace\\pProject\\src\\Address.txt");
		BufferedReader br = new BufferedReader(fr);
		
		
		String line;
		while(true)//파일 불러오기
		{
			line = br.readLine();
			if(line == null)
			{
				break;
			}
			String a[] = line.split(",");//콤마 구분
			address.add(new PersonInfo(a[0],a[1],a[2]));//객채 생성
		}
		
		while(true)
		{
			System.out.println("<<<주소록 관리>>>");
			System.out.println("========================");
			System.out.println("1. 연락처 추가");
			System.out.println("2. 연락처 삭제");
			System.out.println("3. 모든 연락처 보기");
			System.out.println("4. 종료");
			System.out.print("항목을 선택하세요 : ");
			
			int num;
			num = isc.nextInt();//항목선택
			switch(num)
			{
			case 1: 
				System.out.println("<<연락처 추가>>");//추가
				System.out.println("이름 : ");
				String input1 = sc.next();
				System.out.println("핸드폰 : ");
				String input2 = sc.next();
				System.out.println("회사 : ");
				String input3 = sc.next();
				address.add(new PersonInfo(input1, input2, input3));//객체생성, 추가
				break;
			case 2:
				System.out.println("<<연락처 삭제>>");//삭제
				System.out.print("삭제할 이름을 입력하세요 : ");
				String delete = sc.nextLine();
				int del = 0;
				while(!delete.equals(address.get(del).getName()))
				{
					del++;
				}
				address.remove(del);
				break;
			case 3:
				for(int i=0; i<address.size(); i++)//출력
				{
					address.get(i).getInfo();
				}
				break;
			case 4:
				System.out.println("종료합니다.");//파일 출력
				//파일 출력
				Writer fw = new FileWriter("C:\\eclipse-jee-oxygen-2-win32-x86_64\\eclipse\\workspace\\pProject\\src\\Address.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				String str = "";
				int count = 0;
				while(true)
				{
					if(count == address.size())
						{
							break;
						}
					bw.write(address.get(count).getName());//이름가져오기
					bw.flush();
					bw.write(',');
					bw.flush();
					bw.write(address.get(count).getHp());//핸드폰번호 가져오기
					bw.flush();
					bw.write(',');
					bw.flush();
					bw.write(address.get(count).getCp());//회사번호 가져오기
					bw.flush();
					bw.newLine();
					bw.flush();
					count++;
				}
				sc.close();
				isc.close();
				br.close();
				bw.close();
				System.exit(0);
				break;
			}
		}
		
	}

}
