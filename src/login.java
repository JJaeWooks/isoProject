import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class login {
    public static void Login() throws IOException {
        BufferedReader bi=new BufferedReader(new InputStreamReader(System.in));
        user user=new user();
        System.out.println("로그인창 입니다");
        System.out.println("아이디를 입력하세요");
        String User_name=bi.readLine();
        System.out.println("비밀번호를 입력하세요");
        String User_pw=bi.readLine();
        user.setUser_name(User_name);
        user.setUser_pw(User_pw);
        DB.db_connet(2, user.getUser_name(), user.getUser_pw());
    }
}
