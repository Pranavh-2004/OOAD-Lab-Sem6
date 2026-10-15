package controller;

import java.util.ArrayList;

import model.Library;
import model.Book;
import model.User;

import utils.Result;

public class LibrarySystem {
    private Library library;

    public LibrarySystem() {
        this.library = new Library();
    }

    public Result addBook(String id, String name, String author) {
        return this.library.addBook(id, name, author);
    }

    public Result borrowBook(String id) {
        return this.library.borrowBook(id);
    }

    public Result returnBook(String id) {
        return this.library.returnBook(id);
    }

    public Result registerUser(String id, String name) {
        return this.library.registerUser(id, name);
    }

    public ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> result = new ArrayList<Book>();
        ArrayList<Book> books = this.library.getBooks();

        for (Book book : books) {
            if (book.getAvailable() == true) {
                result.add(book);
            }
        }

        return result;
    }

    public User getUser(String id) {
        ArrayList<User> users = this.library.getUsers();

        for (User user: users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }
}
