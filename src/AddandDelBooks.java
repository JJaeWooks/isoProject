import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddandDelBooks  {


    public static void deletebooks() throws IOException{
        String bookname;
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("삭제할 책 이름을 입력하세요");
        bookname=bi.readLine();
        DB.bookDelete(bookname);

    }
    public static void addbooks() throws IOException {
        String bookname;
        String author;
        int price;

        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("추가할 책 이름을 입력하세요");
        bookname=bi.readLine();
        System.out.println("저자을 입력하세요");
        author=bi.readLine();
        System.out.println("판매 가격을 입력하세요");
        price=Integer.parseInt(bi.readLine());


        Books book = new Books();

        book.setBookName(bookname);
        book.setAuthor(author);
        book.setPrice(price);


        DB.bookInsert(book.getBookName(),book.getAuthor(),book.getPrice(),book.getAmount());
    }

}
