package a_999_java_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

class Product{
	private int		pdt_id;				//상품코드
	private String 	pdt_id_name;		//상품명
	private int 	pdt_unit_price;		//단가
	private int 	pdt_order_method;	//1단품 2세트 3추가
	
	public int getPdt_id() {
		return pdt_id;
	}

	public void setPdt_id(int pdt_id) {
		this.pdt_id = pdt_id;
	}

	public String getPdt_id_name() {
		return pdt_id_name;
	}

	public void setPdt_id_name(String pdt_id_name) {
		this.pdt_id_name = pdt_id_name;
	}

	public int getPdt_unit_price() {
		return pdt_unit_price;
	}

	public void setPdt_unit_price(int pdt_unit_price) {
		this.pdt_unit_price = pdt_unit_price;
	}

	public int getPdt_order_method() {
		return pdt_order_method;
	}

	public void setPdt_order_method(int pdt_order_method) {
		this.pdt_order_method = pdt_order_method;
	}
	public int 		cnt;
	
	void printScore() {
		System.out.printf("%3d %5d %5d %4d %5s \n",
				cnt,pdt_id, pdt_unit_price, pdt_order_method,pdt_id_name);
	}
}

public class Kiosk_Product_Insert {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String buffer;
			Scanner input = new Scanner(System.in);
			
			System.out.print("상품코드 입력은 몇 건 입니까(숫자입력) : ");
			int num =input.nextInt();
			Product p[] = new Product[num];
			
			for(int i=0; i<p.length; i++) {
				p[i] =new Product();
				
				buffer = input.nextLine();
				System.out.print("상품명을 입력하세요: ");
				p[i].setPdt_id_name(input.nextLine());
				System.out.print("상품코드를 입력하세요: ");
				p[i].setPdt_id(input.nextInt());
				System.out.print("상품단가를 입력하세요: ");
				p[i].setPdt_unit_price(input.nextInt());
				System.out.print("주문방법을 입력하세요: ");
				p[i].setPdt_order_method(input.nextInt());
				
				}
				System.out.println("=========상품코드 등록내용==========");
				System.out.println("NO 상품코드  단가 주문방법 상품명       ");
				System.out.println("===============================");
				for(int i = 0; i<p.length; i++) {
					p[i].cnt = i+1;
					p[i].printScore();
				}
				
			
				System.out.println("================================");
				System.out.println("위 내용을 저장 시 1번 그외는 취소합니다");
				num = input.nextInt();
				
				if(num==1) {
					
					Connection conn = null;
					PreparedStatement pstmt = null;
					String sql;
					
					String url = "jdbc:oracle:thin:@localhost:1521:xe";
					String id = "system";
					String pw = "1234";
					try {
						Class.forName("oracle.jdbc.OracleDriver");
						System.out.println("클래스 로딩 성공");
						conn = DriverManager.getConnection(url, id, pw);
						System.out.println("DB 접속");
						
						for(int i =0; i<p.length; i++) {
							sql = "insert into tbl_product_master Values (?, ?, ?, ?)";
							pstmt = conn.prepareStatement(sql);
							
							pstmt.setInt(1,p[i].getPdt_id());
							pstmt.setString(2,p[i].getPdt_id_name());
							pstmt.setInt(3,p[i].getPdt_unit_price());
							pstmt.setInt(4,p[i].getPdt_order_method());
							
							pstmt.executeUpdate();
					}
						System.out.println("입력된 작업은 정상 등록되었습니다");
					
				}catch(Exception e) {
					e.printStackTrace();
				}
		}else {
			System.out.println("입력된 작업은 등록 취소되었습니다");
			S21223_kiosk.main(args);
		}
	}
	
}



