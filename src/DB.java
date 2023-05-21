import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB {
    public static String url = "jdbc:mysql://orange.gnu.ac.kr/d2019011459"; // JDBC URL
    public static String user = "2019011459"; // 데이터베이스 사용자 이름
    public static String password = "2019011459"; // 데이터베이스 비밀번호


    public static void bookselect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String sql2= "select * from books";
            ResultSet rs = stmt.executeQuery(sql2);
            while (rs.next()) {
                System.out.println(rs.getString("bid") + "번 \n책이름 :" + rs.getString("book") +"\n총 판매금액 : "+rs.getString("totalprice"));
            }

            System.out.println();
            관리자모드.관리자Menu();
        }
        catch (Exception e){
            System.out.println("잘못입력하셨습니다.");
            e.printStackTrace();
        }
    }
    public static void bookAllSelect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String sql2= "SELECT SUM(totalprice) AS total_sum\n" +
                    "FROM books;\n";
            ResultSet rs = stmt.executeQuery(sql2);
            rs.next();
            System.out.println("총매출은 "+rs.getString("total_sum")+ "원 입니다");

            System.out.println();
            관리자모드.관리자Menu();
        }
        catch (Exception e){
            System.out.println("잘못입력하셨습니다.");
            e.printStackTrace();
        }
    }

    public static void bookbuy(int num){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String sql = "UPDATE books SET amount = amount + 1 where bid='"+num+"'";
            String sql2= "select * from books where bid='"+num+"'";
            String sql3="UPDATE books\n" + "SET totalprice = price * amount;";

            ResultSet rs = stmt.executeQuery(sql2);

            while (rs.next()) {
                System.out.println(Login.user_name + "님 " + rs.getString("book") + "책이 구매되었습니다.");
            }
            stmt.executeUpdate(sql);
            System.out.println();
            stmt.executeUpdate(sql3);
        }
        catch (Exception e){
            System.out.println("잘못입력하셨습니다.");
            e.printStackTrace();
        }


    }
    public static void bookFind(String book){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String sql = "select * from books where book='"+book+"'";
            ResultSet rs = stmt.executeQuery(sql);
            int count=0;
            while (rs.next()) {
                System.out.println("---------------------");
                System.out.println(rs.getString("bid") + "번 \n책이름 :" + rs.getString("book") + "\n저자 :" + rs.getString("author")+"\n금액 : "+rs.getInt("price"));
                count=count+1;
           }
            if (count==0){
                System.out.println("찾으시는 책이 없습니다.");
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void findAuthor(String author){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String sql = "select * from books where author='"+author+"'";
            ResultSet rs = stmt.executeQuery(sql);
            int count=0;
            while (rs.next()) {
                System.out.println("---------------------");
                System.out.println(rs.getString("bid") + "번 \n책이름 :" + rs.getString("book") + "\n저자 :" + rs.getString("author")+"\n금액 : "+rs.getInt("price"));
                count=count+1;
            }
            if (count==0){
                System.out.println("찾으시는 책이 없습니다.");
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void bookList(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            String sql = "select * from books";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("bid") + "번 책이름 :" + rs.getString("book") + "\n저자 :" + rs.getString("author")+"\n 금액 : "+rs.getInt("price"));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        }

    public static void bookDelete(String book){
        try {
            // JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 데이터베이스 연결
            Connection conn = DriverManager.getConnection(url, user, password);

            // 쿼리 실행
            Statement stmt = conn.createStatement();
            String sql = "delete from books where book='" + book + "'";
            stmt.executeUpdate(sql); //sql문을 날림
            stmt.close();
            conn.close();
            관리자모드.관리자Menu(); //다시 메뉴로 되돌아가기

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void bookInsert(String book,String author,int price,int amount){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO books (book, author, price) VALUES ('" + book + "', '" + author + "', " + price+")";
            stmt.executeUpdate(sql); //sql문을 날림
            stmt.close();
            conn.close();
            관리자모드.관리자Menu(); //다시 메뉴로 되돌아가기

        }
        catch (Exception e){
            e.printStackTrace();
        }

        }


    public static void db_connet(int num, String user_name, String user_pw) {
        try {
            // JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스 연결
            Connection conn = DriverManager.getConnection(url, user, password);

            // 쿼리 실행
            Statement stmt = conn.createStatement();


            if (num == 1) { //1번 회원가입을 들어 왔을시 인설트문
                String sql = "Insert into login(username,password)values('" + user_name + "','" + user_pw + "')";
                stmt.executeUpdate(sql); //sql문을 날림
                stmt.close();
                conn.close();
                System.out.println("환영합니다 !!");
                View.menu(); //다시 메뉴로 되돌아가기
            } else if (num == 2) {  //DB 조회후 로그인
                String sql = "select * from login";
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {

                    if (user_name.equals(rs.getString("username")) && user_pw.equals(rs.getString("password"))) {
                        System.out.println("로그인 성공");
                        BookList.bookmenu();
                       break;

                    }
                    else{
                        System.out.println("로그인 실패");
                        break;
                    }

                }




            } else if (num == 3) {
                String sql = "select * from login";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    System.out.println(rs.getString("id") + "번 유저의 아이디 :" + rs.getString("username") + "\n유저의 비밀번호 :" + rs.getString("password"));
                }
                관리자모드.관리자Menu();;
            } else if (num == 4) {
                BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));

                while (true) {
                    System.out.println("삭제하실 번호를 알려주세요");
                    String id = bi.readLine();
                    String sql = "delete from login where id='" + id + "'";
                    stmt.executeUpdate(sql);
                    System.out.println(id + "번 유저가 삭제되었습니다.");
                    System.out.println("계속 하시겠습니까? y/n");
                    String c = bi.readLine();
                    if (c.equals("y")) {
                        continue;
                    } else if (c.equals("n")) {
                        관리자모드.관리자Menu(); //수정
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
