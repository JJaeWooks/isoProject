import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 관리자모드 {
    public static void root() throws IOException {
        BufferedReader bi=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("관리자 모드 입니다");
        System.out.println("비밀번호 4자리를 입력하시오");
        int pass=Integer.parseInt(bi.readLine());
        if (pass==7777){
            System.out.println("1. 회원 아이디 조회");
            System.out.println("2. 회원 삭제");
            System.out.println("3. 책 추가");
            System.out.println("4. 책 삭제");
            System.out.println("5. 각 책의 매출 조회");


            int num=Integer.parseInt(bi.readLine());
            if(num==1){
                DB.db_connet(3,null,null);
            } else if (num==2) {
                DB.db_connet(4,null,null);
            }else if(num==3){
                AddandDelBooks.addbooks();
            }else if(num==4){
                AddandDelBooks.deletebooks();
            }
        }
    }
}
