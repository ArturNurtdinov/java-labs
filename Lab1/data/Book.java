package data;

public class Book {
    public Book(int number, String author, String name, int releaseDate) {
        this.number = number;
        this.author = author;
        this.name = name;
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "data.Book: " + number + " " + author + " " + name + " " + releaseDate;
    }

    int getNumber() {
        return number;
    }

    String getAuthor() {
        return author;
    }

    String getName() {
        return name;
    }

    int getReleaseDate() {
        return releaseDate;
    }

    private int number;
    private String author;
    private String name;
    private int releaseDate;
}
