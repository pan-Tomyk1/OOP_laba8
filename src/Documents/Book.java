package Documents;

import java.util.Objects;

public class Book extends Document {

    private String ISBN;
    private String genre;
    private int amountOfPages;

    public Book(String name, String author, String publisher, String language, String description, String tags, boolean inLibrary, String ISBN, String genre, int amountOfPages) {
        super(name, author, publisher, language, description, tags, inLibrary);
        this.ISBN = ISBN;
        this.genre = genre;
        this.amountOfPages = amountOfPages;
    }

    public Book() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return amountOfPages == book.amountOfPages && Objects.equals(ISBN, book.ISBN) && Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ISBN, genre, amountOfPages);
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAmountOfPages() {
        return amountOfPages;
    }

    public void setAmountOfPages(int amountOfPages) {
        this.amountOfPages = amountOfPages;
    }
    public String beautifulOutput(){
        return "Document type : Book" +"\n"+
                "Name of the book: " +this.getName()+"\n"+
                "Author of the book: " +this.getAuthor()+"\n"+
                "Publisher of the book: " +this.getPublisher()+"\n"+
                "Language of the book: " +this.getLanguage()+"\n"+
                "Description of the book: " +this.getDescription()+"\n"+
                "Tags of the book: " +this.getTags()+"\n"+
                "Status inLibrary of the book: " +this.isInLibrary()+"\n"+
                "ISbN of the book: " +this.getISBN()+"\n"+
                "Genre of the book: " +this.getGenre()+"\n"+
                "Amount of pages of the book: " +this.getAmountOfPages()+"\n";

    }
    public int printAllAtributes() {
        System.out.println("1 name");
        System.out.println("2 author");
        System.out.println("3 publisher");
        System.out.println("4 language");
        System.out.println("5 description");
        System.out.println("6 tags");
        System.out.println("7 inLibrary");
        System.out.println("8 ISBN");
        System.out.println("9 genre");
        System.out.println("10 amount of pages");
        return 10;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + getName() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", publisher='" + getPublisher() + '\'' +
                ", language='" + getLanguage() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", tags='" + getTags() + '\'' +
                ", inLibrary=" + isInLibrary() +'\'' +
                "ISBN='" + ISBN + '\'' +
                ", genre='" + genre + '\'' +
                ", amountOfPages=" + amountOfPages +
                '}';
    }
}
