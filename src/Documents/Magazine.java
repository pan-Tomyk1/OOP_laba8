package Documents;

import java.util.Objects;

public class Magazine extends Document{
    private String ISSN;
    private int issueNumber;
    private int amountOfPages;
    private String releaseData;

    public Magazine(String name, String author, String publisher, String language, String description, String tags, boolean inLibrary, String ISSN, int issueNumber, int amountOfPages, String releaseData) {
        super(name, author, publisher, language, description, tags, inLibrary);
        this.ISSN = ISSN;
        this.issueNumber = issueNumber;
        this.amountOfPages = amountOfPages;
        this.releaseData = releaseData;
    }

    public Magazine() {
    }

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public int getAmountOfPages() {
        return amountOfPages;
    }

    public void setAmountOfPages(int amountOfPages) {
        this.amountOfPages = amountOfPages;
    }

    public String getReleaseData() {
        return releaseData;
    }

    public void setReleaseData(String releaseData) {
        this.releaseData = releaseData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return issueNumber == magazine.issueNumber && amountOfPages == magazine.amountOfPages && Objects.equals(ISSN, magazine.ISSN) && Objects.equals(releaseData, magazine.releaseData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ISSN, issueNumber, amountOfPages, releaseData);
    }
    public String beautifulOutput(){
        return "Document type : Magazine" +"\n"+
                "Name of the magazine: " +this.getName()+"\n"+
                "Author of the magazine: " +this.getAuthor()+"\n"+
                "Publisher of the magazine: " +this.getPublisher()+"\n"+
                "Language of the magazine: " +this.getLanguage()+"\n"+
                "Description of the magazine: " +this.getDescription()+"\n"+
                "Tags of the magazine: " +this.getTags()+"\n"+
                "Status inLibrary of the magazine: " +this.isInLibrary()+"\n"+
                "ISSN of the magazine: " +this.getISSN()+"\n"+
                "Issue number of the magazine: " +this.getIssueNumber()+"\n"+
                "Amount of pages of the magazine: " +this.getAmountOfPages()+"\n"+
                "Date of release of the magazine: " +this.getReleaseData()+"\n";
    }
    public int printAllAtributes() {
        System.out.println("1 name");
        System.out.println("2 author");
        System.out.println("3 publisher");
        System.out.println("4 language");
        System.out.println("5 description");
        System.out.println("6 tags");
        System.out.println("7 inLibrary");
        System.out.println("8 ISSN");
        System.out.println("9 issue number");
        System.out.println("10 amount of pages");
        System.out.println("11 release data");
        return 11;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "name='" + getName() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", publisher='" + getPublisher() + '\'' +
                ", language='" + getLanguage() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", tags='" + getTags() + '\'' +
                ", inLibrary=" + isInLibrary() +'\'' +
                "ISSN='" + ISSN + '\'' +
                ", issueNumber=" + issueNumber +'\'' +
                ", amountOfPages=" + amountOfPages +'\'' +
                ", releaseData='" + releaseData + '\'' +
                '}';
    }
}
