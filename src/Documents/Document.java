package Documents;
public abstract class Document {
    private String name;
    private String author;
    private static int counter_ID=0;

    private String publisher;
    private String language;
    private String description;
    private String tags;
    private boolean inLibrary=true;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static int getCounter_ID() {
        return counter_ID;
    }

    public static void setCounter_ID(int counter_ID) {
        Document.counter_ID = counter_ID;
    }


    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Document{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", language='" + language + '\'' +
                ", description='" + description + '\'' +
                ", tags='" + tags + '\'' +
                ", inLibrary=" + inLibrary +
                '}';
    }

    public Document() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public boolean isInLibrary() {
        return inLibrary;
    }

    public void setInLibrary(boolean inLibrary) {
        this.inLibrary = inLibrary;
    }

    public Document(String name, String author, String publisher, String language, String description, String tags, boolean inLibrary) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.language = language;
        this.description = description;
        this.tags = tags;
        this.inLibrary = inLibrary;
    }
    public  abstract String beautifulOutput();
    public  abstract int printAllAtributes();
}
