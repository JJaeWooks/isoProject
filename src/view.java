import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public  class view{

    public static void menu() throws IOException {

        System.out.println("################");
        System.out.println("1: 회원가입");
        System.out.println("2: 로그인");
        System.out.println("3: 관리자모드");
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
           join.Join();
        }
        if (num==2){
            login.Login();
        }
        if(num==3){
            관리자모드.root();
        }

    }
}
