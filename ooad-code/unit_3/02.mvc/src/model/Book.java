package model;

public class Book {
    private String id;
    private String name;
    private String author;
    private boolean available;

    Book(String id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.available = true;
    }

    public String getId() { return this.id; }
    public String getName() { return this.name; }
    public String getAuthor() { return this.author; }
    public boolean getAvailable() { return this.available; }

    public void setName(String name) { this.name = name; }
    public void setAuthor(String author) { this.author = author; }
    public void setAvailable(boolean available) { this.available = available; }
}
