// Information Expert 
class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public Boolean isBookAvailable(){
        return isAvailable;
    }

    public String getTitle(){
        return title;
    }

    public void borrowBook(){
        isAvailable = false;
    }

    public void returnBook(){
        isAvailable = true;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nAuthor: " + author + 
        "\nAvailablity: " + (isAvailable ? "YES" : "NO");
    }

    
    
}