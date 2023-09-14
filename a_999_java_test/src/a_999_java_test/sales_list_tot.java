
package a_999_java_test;

import java.sql.*;
import java.util.*;

class sales_total{															
    public int     ord_pdt_id;		//상품코드
    public int     ord_buying;		//주문수량
    public int     ord_price;		//금액
    public String     tot_system_date;		//금액
    public int     pdt_id;		
    public String  pdt_id_name;		//상품이름
    
    public int     cnt;				//순서
    
    void printScore() {
        System.out.printf("%3d   %6s    %4d     %6d    %6d      %1s \n",
                cnt, tot_system_date,  ord_buying, ord_price, ord_pdt_id, pdt_id_name);
    }
}
public class sales_list_tot {																

    public static void main(String[] args) {													
    	Scanner kpbl=new Scanner(System.in);
    	int List=0;						//변수 생성	
    	
        int num_count =0;				//순번
        do {							//do문 시작
    
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
            
            // 지금까지 입력된 코드들 총합
            sql="select count(*) num from tbl_order_total";            
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            num_count = rs.getInt("num");
            System.out.println("등록된코드:"+num_count+"건");
            
           
            //변수가 1이면 전체 출력 9이면 종료 그외에는 상품코드를 입력
            System.out.println("주문번호를 입력하세요. 주문 리스트를 출력합니다. 전체:1 종료:9");
            List=kpbl.nextInt();			//변수 입력
            
	        if(List==1) {					//변수가 1이면 전체 출력 
	            							//순서대로 상품코드,수량,금액,상품이름 출력
	            	sql="select to_char(tot_system_date,'yyyy-mm-dd') sys , ord_buying , ord_price , pdt_id , pdt_id_name from "
	            			+ "tbl_product_master a, tbl_order_list b, tbl_order_total c where pdt_id=ord_pdt_id and ord_no = tot_ord_no "
	            			+ "order by pdt_id,sys asc";
            }else if(List==9) {				//변수가 9이면 메인 화면으로
            	S21223_kiosk.main(args);	//메인으로 이동
                break;
            }else if(List!=1||List!=9){		//변수에 순번을 입력
            								// where or_pdt_id="+변수"+ and .... 형태로 입력 
            	sql="select to_char(tot_system_date,'yyyy-mm-dd') sys , ord_buying , ord_price , pdt_id , pdt_id_name from "
            			+ "tbl_product_master a, tbl_order_list b, tbl_order_total c where pdt_id=ord_pdt_id and ord_no = tot_ord_no "
            			+ "order by pdt_id, sys asc";
            }
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            System.out.println("================================================");
            System.out.println(" 순번    상품코드    수량       금액       상품이름");
            System.out.println("================================================");

            num_count = 0;					//순번을 0부터시작
            int total=0;					//매출합계 변수
            int buying_count=0;				//수량 변수
            sales_total p =new sales_total();
            while(rs.next()) {				
                p.cnt = num_count+1;		//p.cnt = 순번+1
                num_count++;				//순번+1
                p.ord_pdt_id = rs.getInt("ord_pdt_id");
                p.ord_buying = rs.getInt("ord_buying");
                p.ord_price = rs.getInt("ord_price");
                p.tot_system_date = rs.getString("tot_system_date");
                p.pdt_id_name = rs.getString("pdt_id_name");
                   
                p.printScore();		        //출력
                    
                buying_count = buying_count + p.ord_buying;						//수량
                total = total + p.ord_price;//매출합계
            }								
                
            System.out.println("================================================");
            System.out.println("*전체판매출합계: "+buying_count+"  "+ total);					
                							//else 끝
    }catch(Exception e) {					//try 끝  catch문 시작
        e.printStackTrace();
    } 										//catch문 끝
        continue;							//다시 시작
        }while(true);						//do 끝
   }																							
}
