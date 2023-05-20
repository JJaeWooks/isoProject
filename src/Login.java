import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Login {
    public static String user_name;

    public static void Login() throws IOException {
        BufferedReader bi=new BufferedReader(new InputStreamReader(System.in));
        User user=new User();
        System.out.println("로그인창 입니다");
        System.out.println("아이디를 입력하세요");
        user_name=bi.readLine();
        System.out.println("비밀번호를 입력하세요");
        String user_pw=bi.readLine();
        user.setUser_name(user_name);
        user.setUser_pw(user_pw);
        DB.db_connet(2, user.getUser_name(), user.getUser_pw());

    }

}
