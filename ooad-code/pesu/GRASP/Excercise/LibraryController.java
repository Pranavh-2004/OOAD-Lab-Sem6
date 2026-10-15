import java.util.List;

// Controller principle
class LibraryController {
    private Library library = new Library(); // Model

    public void registerUser(String name, int id){
        library.addUser(name, id);
    }

    public void addNewBook(String title, String author){
        library.addBook(title, author);
    }

    public List<Book> getAvailableBooks(){
        return library.getAvailableBooks();
    }

    public List<User> getAllUsers(){
        return library.getUsers();
    }

    public void borrowBook(String title){
        library.borrowBook(title);
        
    }

    public void returnBook(String title){
        library.returnBook(title);
    }
}