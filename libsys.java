class libsys {
    public static void main(String[] args) {
        LibraryController lc = new LibraryController();

        lc.addBook("Clean Code", "Robert C. Martin");
        lc.addBook("Design Patterns", "Gang of Four");

        lc.registerUser(1, "Alice");
        
        lc.displayAvailableBooks();
        lc.borrowBook(1, "Clean Code");
        lc.displayAvailableBooks();

        lc.displayUserDetails(1);

        lc.returnBook(1, "Clean Code");
        lc.displayAvailableBooks();
    }
}
