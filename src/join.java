import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class join {
    public static void Join() throws IOException {
        BufferedReader bi=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("회원가입 창 입니다");
        System.out.println("아이디를 입력하세요");
        String User_name=bi.readLine();
        System.out.println("비밀번호를 입력하세요");
        String User_pw=bi.readLine();
        System.out.println("비밀번호를 다시 입력하세요");
        String User_pw2=bi.readLine();

        if (User_pw2.equals(User_pw)){ //비밀번호 확인이 되었을시 데이터베이스에 저장
            user user=new user();
            user.setUser_name(User_name);
            user.setUser_pw(User_pw);
            DB.db_connet(1,user.getUser_name(), user.getUser_pw()); //num과 아이디 비밀번호를 가지고 db에 접근
        }
        else {
            System.out.println("비밀번호를 잘못 입력했습니다");
        }
    }
}
