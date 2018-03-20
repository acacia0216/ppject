package addressbook;

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
		Reader fr = new FileReader("D:\\javaStudy\\workspace\\ppject\\PhoneDB.txt");
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
			System.out.println();
			System.out.println("=============================");
			System.out.println("< < <   전화번호 관리 프로그램   > > >");
			System.out.println("=============================");
			System.out.println();
			System.out.print("1.리스트  ");
			System.out.print("2.등록  ");
			System.out.print("3.삭제  ");
			System.out.print("4.검색  ");
			System.out.println("5.종료");
			System.out.println("-----------------------------");
			System.out.print(">메뉴번호 : ");
			
			int num;
			num = isc.nextInt();//항목선택
			switch(num)
			{
			case 1:
				System.out.println();
				for(int i=0; i<address.size(); i++)//출력
				{
					System.out.print(i+1+". ");
					address.get(i).getInfo();
				}
				break;
			case 2: 
				System.out.println();
				System.out.println("<<연락처 추가>>");//추가
				System.out.print("이름 : ");
				String input1 = sc.nextLine();
				System.out.print("핸드폰 : ");
				String input2 = sc.nextLine();
				System.out.print("회사 : ");
				String input3 = sc.nextLine();
				address.add(new PersonInfo(input1, input2, input3));//객체생성, 추가
				System.out.println();
				System.out.println("["+input1+"이(가) 추가되었습니다.]");
				System.out.println();
				break;
			case 3:
				System.out.println();
				System.out.println("<<연락처 삭제>>");//삭제
//				System.out.print("삭제할 이름을 입력하세요 : ");
				System.out.print("삭제할 번호를 입력하세요 : ");
//				String delete = sc.nextLine();
				int del = isc.nextInt();
//				while(!delete.equals(address.get(del).getName()))
//				{
//					del++;
//				}
				String n = address.get(del-1).getName();
				address.remove(del-1);
				System.out.println();
				System.out.println("["+n+"이(가) 삭제되었습니다.]");
				System.out.println();
				break;
			case 4:
				System.out.println();
				System.out.println("<<연락처 검색>>");//검색
				System.out.print("검색할 이름을 입력하세요 : ");
				String search = sc.nextLine();
				int sch=0;
				for(int i=0; i<address.size(); i++)
				{
					if(address.get(sch).getName().contains(search))
						address.get(sch).getInfo();
					sch++;
				}
				break;
			case 5:
				System.out.println();
				System.out.println();
				System.out.println("=============================");
				System.out.println("< < <      감  사  합  니  다      > > >");
				System.out.println("=============================");
				System.out.println();
				//파일 출력
				Writer fw = new FileWriter("D:\\javaStudy\\workspace\\ppject\\PhoneDB.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				String str = "";
				int count = 0;
				while(true)
				{
					if(count == address.size())
						{
							break;
						}
					bw.write(address.get(count).getName()+','+address.get(count).getHp()+
									','+address.get(count).getCp());//파일에 쓰기
					bw.flush();
					bw.newLine();//개행
					count++;
				}
				sc.close();
				isc.close();
				br.close();
				bw.close();
				System.exit(0);
				
				default :
					System.out.println("[다시입력해주세요.]");
					break;
			}
		}
		
	}

}
