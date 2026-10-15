
import java.util.ArrayList;
import java.util.List;


class Library {
    private List<User> userList = new ArrayList<User>();
    private List<Book> bookList = new ArrayList<Book>();

    public void addUser(String name, int id){
        User newUser = new User(name, id); // CREATOR principle
        userList.add(newUser);
    }

    public void addBook(String title, String author){
        Book newBook = new Book(title, author); // CReator principle
        bookList.add(newBook);
    }

    public List<Book> getBooks(){
        return bookList;
    }

    public List<User> getUsers() {
        return userList;
    }

    public void borrowBook(String title){
        for (Book book : bookList) {
            if(book.getTitle().equalsIgnoreCase(title)){
                if(book.isBookAvailable()){
                    book.borrowBook();
                }
            }
        }
    }

    public void returnBook(String title){
        for (Book book : bookList) {
            if(book.getTitle().equalsIgnoreCase(title)){
                book.returnBook();
            }
        }
    }

     public List<Book> getAvailableBooks(){
        
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : bookList) {
            if(book.isBookAvailable()){
                availableBooks.add(book);
            }
        }

        return availableBooks;
    }
}