import java.rmi.registry.*;
import java.rmi.server.*;
import java.rmi.RemoteException;
import java.util.ArrayList;


public class BookServer implements BookInterface {

    ArrayList<Book> books;

    public BookServer() {
        this.books = new ArrayList<Book>();
        this.books.add(new Book(1, "title_1", "author_1", "isbn_1"));
    }

    @Override
    public Book getBook(int id) throws RemoteException {
        for(int i = 0; i < this.books.size(); ++i) {
            Book _book = this.books.get(i);
            if(_book.getId() == id) {
                return _book;
            }
        }
        return null;
    }

    @Override
    public boolean insertBook(Book newBook) throws RemoteException {
        return this.books.add(newBook);
    }

    public static void main(String []args) {
        try {
            BookServer sv = new BookServer();

            BookInterface stub = (BookInterface)UnicastRemoteObject.exportObject(sv, 0);
            Registry rgt = LocateRegistry.getRegistry();

            rgt.bind("Book", stub);
            System.out.println("Book server is listening");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
