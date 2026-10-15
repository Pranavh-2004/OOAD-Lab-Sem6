class Book {
    private String title;
    private String author;
    private String content;

    public Book(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setContent(String content) { this.content = content; }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getContent() { return content; }

}

class BookView {
    private final Book book;

    public BookView(Book book) {
        this.book = book;
    }

    // Good design:
    // The book class has only one responsibilities, maintain the metadta of the book
    // The BookView class is responsibile for searching the book
    // Hence the single responsibility principle of both the class is maintained
    public void searchBook(String text) {
    }
}

class GoodSingleResponsibility {
    public static void main(String args[]) {
        Book b = new Book("title", "author", "content");
        BookView bv = new BookView(b);

        bv.searchBook("text");
    }
}
