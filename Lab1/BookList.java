import java.util.ArrayList;

class BookList {

    private ArrayList<Book> books;

    BookList() {
        books = new ArrayList<>();
    }

    BookList(ArrayList<Book> books) {
        this.books = books;
    }

    void add(Book book) {
        if (book != null) {
            books.add(book);
        } else {
            throw new NullPointerException("Null pointer");
        }
    }

    Book getByIndex(int index) {
        if ((index < books.size()) && (index >= 0)) {
            return books.get(index);
        } else {
            throw new ArrayIndexOutOfBoundsException("Index is out of bounds");
        }
    }

    void update(int index, Book book) {
        if ((index < books.size()) && (index >= 0)) {
            if (book != null) {
                books.set(index, book);
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("Index is out of bounds");
        }
    }

    void delete(int index) {
        if ((index < books.size()) && (index >= 0)) {
            books.remove(index);
        } else {
            throw new ArrayIndexOutOfBoundsException("Index is out of bounds");
        }
    }

    void printBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    ArrayList<Book> getByNumber(int number) {
        ArrayList<Book> res = new ArrayList<>();
        for (Book book : books) {
            if (book.getNumber() == number) {
                res.add(book);
            }
        }
        return res;
    }

    ArrayList<Book> getByAuthor(String author) {
        ArrayList<Book> res = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                res.add(book);
            }
        }
        return res;
    }

    ArrayList<Book> getByName(String name) {
        ArrayList<Book> res = new ArrayList<>();
        for (Book book : books) {
            if (book.getName().equals(name)) {
                res.add(book);
            }
        }
        return res;
    }

    ArrayList<Book> getByReleaseDate(int releaseDate) {
        ArrayList<Book> res = new ArrayList<>();
        for (Book book : books) {
            if (book.getReleaseDate() == releaseDate) {
                res.add(book);
            }
        }
        return res;
    }
}
