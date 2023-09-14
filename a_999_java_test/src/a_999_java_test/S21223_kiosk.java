package a_999_java_test;

import java.util.Scanner;

public class S21223_kiosk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("==================================");
		System.out.println("****KIOSK 상품등록 및 매장 운영프로그램****");
		System.out.println("==================================");
		System.out.println("1.상품코드 등록");
		System.out.println("2.등록된 상품코드 조회");
		System.out.println("3.KIOSK 매장 운영 프로그램(주문입력)");
		System.out.println("4.매장 매출현황(주문서별 합계)");
		System.out.println("5.매장 주문서별 LIST");
		System.out.println("6.매장 주문서별 LIST");
		System.out.println("7.매장 주문서별 LIST");
		System.out.println("0.작업을 종료합니다");
		System.out.println("----------------------------------");
		System.out.println("작업 번호를 선택하세요?");
		int num = sc.nextInt();
		if(num == 1) {
			Kiosk_Product_Insert.main(args);
			
		}else if(num == 2) {
			Kiosk_Product_InquiryChoice.main(args);
			
		}else if(num == 3) {
			Kiosk_Product_BuyTotal.main(args);
		
		}else if(num == 4) {
			
			Kiosk_Product_BuyChoice.main(args);
		}else if(num == 5) {
			Kiosk_Product_BuyList.main(args);
		}else if(num == 6) {
			sales_list.main(args);
		}else if(num == 7) {
			sales_list_tot.main(args);
			
		}else if(num == 0) {
			System.out.println("작업을 종료합니다");
			break;
			
		}else {
			System.out.println("다시입력");
			continue;
		}
	
	
		}
		
	}

}
