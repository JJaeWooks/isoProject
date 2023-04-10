import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB {
    public static void db_connet(int num,String user_name,String user_pw)

    {
        String url = "jdbc:mysql://orange.gnu.ac.kr/d2019011459"; // JDBC URL
        String user = "2019011459"; // 데이터베이스 사용자 이름
        String password = "2019011459"; // 데이터베이스 비밀번호

        try {
            // JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스 연결
            Connection conn = DriverManager.getConnection(url, user, password);

            // 쿼리 실행
            Statement stmt = conn.createStatement();


            if(num==1) { //1번 회원가입을 들어 왔을시 인설트문
                String sql = "Insert into login(username,password)values('" + user_name + "','" + user_pw + "')";
                stmt.executeUpdate(sql); //sql문을 날림
                stmt.close();
                conn.close();
                view.menu(); //다시 메뉴로 되돌아가기
            }else if (num==2){  //DB 조회후 로그인
                String sql="select * from login";
                ResultSet rs= stmt.executeQuery(sql);
                while(rs.next()){
                    if(user_name.equals(rs.getString("username"))&&user_pw.equals(rs.getString("password"))) {
                        System.out.println("로그인 성공");
                        view.menu();
                        break; //break후 이동할 폼 작성
                    }
                }
                System.out.println("로그인 실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
