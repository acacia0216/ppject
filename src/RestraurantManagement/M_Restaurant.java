package RestraurantManagement;

import java.util.Scanner;

public class M_Restaurant {
	
	static int select;
	static int price = 0;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String args[]) 
	{
		home();
	}
	 
	private static void home()
	{
		while(true)
		{
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^");
			System.out.println("원하시는 항목을 선택하세요");
			System.out.println("==========================");
			System.out.println("1. 주문하기");
			System.out.println("2. 주문취소");
			System.out.println("3. 계산하기");
			System.out.println("4. 종료");
			select = sc.nextInt();
			
			
			switch(select) 
			{
			case 1 : menu();
				break;
			case 2 : price = 0;
				break;
			case 3 : bill();
				break;
			case 4 : quit();
				break;
			default : System.out.println("다시 입력하세요");home();
				break;
			}
		}
	}
	
	private static void menu()
	{
		while(true)
		{
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^");
			System.out.println("원하시는 항목을 선택하세요");
			System.out.println("==========================");
			System.out.println("1. 식사");
			System.out.println("2. 음료");
			System.out.println("3. 디저트");
			System.out.println("4. 뒤로가기");
			
			select = sc.nextInt();
			
			switch(select) 
			{
			case 1 : meal();
				break;
			case 2 : drink();
				break;
			case 3 : dessert();
				break;
			case 4 : home();
				break;
			default : System.out.println("다시 입력하세요");menu();
				break;
			}
		}
	}
	private static void meal() 
	{
		while(true)
		{
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^");
			System.out.println("원하시는 항목을 선택하세요");
			System.out.println("==========================");
			System.out.println("1. 샐러드		10,000 won");
			System.out.println("2. 스프			 8,000 won");
			System.out.println("3. 파스타		12,000 won");
			System.out.println("4. 피자			15,000 won");
			System.out.println("5. 리조또		13,000 won");
			System.out.println("6. 뒤로가기");
			
			select = sc.nextInt();
			
			switch(select) 
			{
			case 1 : price += 10000;System.out.println("주문되었습니다.");home();
				break;
			case 2 : price += 8000;System.out.println("주문되었습니다.");home();
				break;
			case 3 : price += 12000;System.out.println("주문되었습니다.");home();
				break;
			case 4 : price += 15000;System.out.println("주문되었습니다.");home();
				break;
			case 5 : price += 13000;System.out.println("주문되었습니다.");home();
				break;
			case 6 : menu();
				break;
			default : System.out.println("다시 입력하세요");meal();
				break;
			}
		}
	}
	
	private static void dessert() 
	{
		while(true)
		{
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^");
			System.out.println("원하시는 항목을 선택하세요");
			System.out.println("==========================");
			System.out.println("1. 커피		     5,000 won");
			System.out.println("2. 아이스크림	 3,000 won");
			System.out.println("3. 홍차			 4,000 won");
			System.out.println("4. 녹차			 5,000 won");
			System.out.println("5. 뒤로가기");
			 
			select = sc.nextInt();
			
			switch(select) 
			{
			case 1 : price += 5000;System.out.println("주문되었습니다.");home();
				break;
			case 2 : price += 3000;System.out.println("주문되었습니다.");home();
				break;
			case 3 : price += 4000;System.out.println("주문되었습니다.");home();
				break;
			case 4 : price += 5000;System.out.println("주문되었습니다.");home();
				break;
			case 5 : menu();
				break;
			default : System.out.println("다시 입력하세요");dessert();
				break;
			}
		}
	}
	
	private static void drink() 
	{
		while(true)
		{
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^");
			System.out.println("원하시는 항목을 선택하세요");
			System.out.println("==========================");
			System.out.println("1. 소주			 7,000 won");
			System.out.println("2. 위스키	 	10,000 won");
			System.out.println("3. 와인			 8,000 won");
			System.out.println("4. 맥주			 5,000 won");
			System.out.println("5. 뒤로가기");
			
			select = sc.nextInt();
			
			switch(select) 
			{
			case 1 : price += 7000;System.out.println("주문되었습니다.");home();
				break;
			case 2 : price += 10000;System.out.println("주문되었습니다.");home();
				break;
			case 3 : price += 8000;System.out.println("주문되었습니다.");home();
				break;
			case 4 : price += 5000;System.out.println("주문되었습니다.");home();
				break;
			case 5 : menu();
				break;
			default : System.out.println("다시 입력하세요");drink();
				break;
			}
		}	
	}
	
	private static void bill() 
	{
		System.out.println("총 금액은 : "+price+"입니다.");
		home();
	}
	private static void quit()
	{
		System.out.println("감사합니다");
		System.out.println("다음에 또 이용해 주세요");
		sc.close();
		System.exit(0);
	}
}
