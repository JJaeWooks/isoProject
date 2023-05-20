import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookList {


    public static void bookmenu() throws IOException {
        BufferedReader bi=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("###########");
        System.out.println("1. 모든 책 조회");
        System.out.println("2. 책 이름으로 검색");
        System.out.println("3. 저자로 검색");
        System.out.println("4. 책구매");
        System.out.println("###########");


        int num=Integer.parseInt(bi.readLine());
        if (num==1){
            DB.bookList();
            BookList.bookmenu();
        } else if (num==2) {
            System.out.println("책이름을 입력하세요");
            String book=bi.readLine();
            DB.bookFind(book);
            BookList.bookmenu();
        }else if (num==3) {
            System.out.println("저자를 입력하세요");
            String author=bi.readLine();
            DB.findAuthor(author);
            BookList.bookmenu();
        }else if(num==4){
            System.out.println("구매할 책의 번호를 입력하세요");
            System.out.println();
            int buy=Integer.parseInt(bi.readLine());
            DB.bookbuy(buy);
        }
    }

}
