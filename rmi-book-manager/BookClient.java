import java.rmi.registry.*;


public class BookClient {

    private BookClient() {};

    public static void main(String[] args) {
        try {
            Registry rgt = LocateRegistry.getRegistry();
            BookInterface stub = (BookInterface)rgt.lookup("Book");
            System.out.println("Looking up ... Done");

            System.out.println(String.format("Get book id = 1 ==> %s", stub.getBook(1).toString()));
            System.out.println("Adding Book: (5, 'title_5', 'author_5', 'isbn_5')");
            System.out.println(String.format("Successfull? %s", stub.insertBook(new Book(5, "title_5", "author_5", "isbn_5"))));
            System.out.println(String.format("Get book id = 5 ==> %s", stub.getBook(5).toString()));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
