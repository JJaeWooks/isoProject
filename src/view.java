import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public  class view{

    public static void menu() throws IOException {

        System.out.println("################");
        System.out.println("1: 회원가입");
        System.out.println("2: 로그인");
        System.out.println("################");
        int num=0;
        BufferedReader bi=new BufferedReader(new InputStreamReader(System.in)); //버퍼 형식으로 입력
        try {
            System.out.println("숫자를 입력하세요");
            num = Integer.parseInt(bi.readLine());  //버퍼형식을 정수형으로 변환한후 저장
        }
        catch (NumberFormatException e){
            System.out.println("잘못입력했습니다.");
        }
        if (num==1){   //회원가입
           login user=new login();
           System.out.println("회원가입 창 입니다");
           System.out.println("아이디를 입력하세요");
           String User_name=bi.readLine();
            System.out.println("비밀번호를 입력하세요");
            String User_pw=bi.readLine();
            System.out.println("비밀번호를 다시 입력하세요");
            String User_pw2=bi.readLine();

            if (User_pw2.equals(User_pw)){ //비밀번호 확인이 되었을시 데이터베이스에 저장
                user.setUser_name(User_name);
                user.setUser_pw(User_pw);
                DB.db_connet(1,user.getUser_name(), user.getUser_pw()); //num과 아이디 비밀번호를 가지고 db에 접근
            }
            else {
                System.out.println("비밀번호를 잘못 입력했습니다");
            }

        }
        if (num==2){
            login user=new login();
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
}
