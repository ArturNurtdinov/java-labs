package data;

import java.util.ArrayList;

public class BookList {

    private ArrayList<Book> books;

    public BookList() {
        books = new ArrayList<>();
    }

    public BookList(ArrayList<Book> books) {
        this.books = books;
    }

    public void add(Book book) {
        if (book != null) {
            books.add(book);
        } else {
            throw new NullPointerException("Null pointer");
        }
    }

    public Book getByIndex(int index) {
        if ((index < books.size()) && (index >= 0)) {
            return books.get(index);
        } else {
            throw new ArrayIndexOutOfBoundsException("Index is out of bounds");
        }
    }

    public void update(int index, Book book) {
        if ((index < books.size()) && (index >= 0)) {
            if (book != null) {
                books.set(index, book);
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("Index is out of bounds");
        }
    }

    public void delete(int index) {
        if ((index < books.size()) && (index >= 0)) {
            books.remove(index);
        } else {
            throw new ArrayIndexOutOfBoundsException("Index is out of bounds");
        }
    }

    public void printBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public ArrayList<Book> getByNumber(int number) {
        ArrayList<Book> res = new ArrayList<>();
        for (Book book : books) {
            if (book.getNumber() == number) {
                res.add(book);
            }
        }
        return res;
    }

    public ArrayList<Book> getByAuthor(String author) {
        ArrayList<Book> res = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                res.add(book);
            }
        }
        return res;
    }

    public ArrayList<Book> getByName(String name) {
        ArrayList<Book> res = new ArrayList<>();
        for (Book book : books) {
            if (book.getName().equals(name)) {
                res.add(book);
            }
        }
        return res;
    }

    public ArrayList<Book> getByReleaseDate(int releaseDate) {
        ArrayList<Book> res = new ArrayList<>();
        for (Book book : books) {
            if (book.getReleaseDate() == releaseDate) {
                res.add(book);
            }
        }
        return res;
    }
}
