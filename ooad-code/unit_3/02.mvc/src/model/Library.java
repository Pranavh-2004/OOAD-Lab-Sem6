package model;

import java.util.ArrayList;

import model.Book;
import model.User;
import utils.Result;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
    }

    public Result addBook(String id, String name, String author) {
        if (this._searchBookById(id) == -1) {
            return new Result(1, "Book already present");
        }

        this.books.add(new Book(id, name, author));
        return new Result(0, "Ok");
    }

    public Result borrowBook(String id) {
        int idx = this._searchBookById(id);
        if (idx == -1) {
            return new Result(1, "Book not found");
        }

        if (this.books.get(idx).getAvailable() == false) {
            return new Result(2, "Book not available");
        }

        this.books.get(idx).setAvailable(false);
        return new Result(0, "Ok");
    }

    public Result returnBook(String id) {
        int idx = this._searchBookById(id);
        if (idx == -1) {
            return new Result(1, "Book not found");
        }

        this.books.get(idx).setAvailable(true);
        return new Result(0, "Ok");
    }

    public ArrayList<Book> getBooks() { return this.books; }

    public Result registerUser(String id, String name) {
        if (this._searchUsersById(id) != -1) {
            return new Result(1, "User already registed");
        }

        this.users.add(new User(id, name));
        return new Result(0, "Ok");
    }

    public ArrayList<User> getUsers() { return this.users; }


    private int _searchBookById(String id) {
        for (int i = 0; i < this.books.size(); ++i) {
            if (this.books.get(i).getId() == id) {
                return i;
            }
        }

        return -1;
    }

    private int _searchUsersById(String id) {
        for (int i = 0; i < this.users.size(); ++i) {
            if (this.users.get(i).getId() == id) {
                return i;
            }
        }

        return -1;
    }
}
