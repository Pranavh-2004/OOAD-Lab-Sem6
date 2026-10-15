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

    // Bad design:
    // The book class has two responsibilities, 1: maintain the metadta of the book, 2. search the book
    // This violates the single responsibility principle of the class
    public void searchBook(String text) {
    }
}

class BadSingleResponsibility {
    public static void main(String args[]) {
        Book b = new Book("title", "author", "content");
        b.searchBook("text");
    }
}
