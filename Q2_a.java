import java.util.ArrayList;
import java.util.List;
class Book {
    String title;
    String author;
    int numberOfAvailableCopies;
    public Book(String title, String author, int numberOfAvailableCopies) {
        this.title = title; this.author = author;
        this.numberOfAvailableCopies = numberOfAvailableCopies;
    }
    void buyBook() throws  BookOutOfStockException{
        if(numberOfAvailableCopies>0)
            numberOfAvailableCopies-=1;
        else throw new BookOutOfStockException("[BookOutOfStockException] The value of numberOfAvailableCopies is 0.");
     }

     public static class BookOutOfStockException extends Exception{
        public BookOutOfStockException (String txt){
            super(txt);
        }
     }


}

class Library {
    List<Book> books;

    Library() {
        books = new ArrayList<>();
    }

    void addBook(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).title.equals(book.title)) {
                return;
            }
        }
        books.add(book);
    }

    void buyBook(String bookTitle) {
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.title.equals(bookTitle)) {
                try {
                    b.buyBook();
                    books.set(i, new Book(b.title, b.author, b.numberOfAvailableCopies));
                } catch (  Book.BookOutOfStockException e) {
                    System.out.println("The book you are willing to order is unavailable");
                }
                break;
            }
        }
    }
}

