package Documents;

import java.util.Objects;

public class Article extends Magazine{
    private String DOI;

    public Article(String name, String author, String publisher, String language, String description, String tags, boolean inLibrary, String ISSN, int issueNumber, int amountOfPages, String releaseData, String DOI) {
        super(name, author, publisher, language, description, tags, inLibrary, ISSN, issueNumber, amountOfPages, releaseData);
        this.DOI = DOI;
    }

    public Article() {
    }

    public String getDOI() {
        return DOI;
    }

    public void setDOI(String DOI) {
        this.DOI = DOI;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Article article = (Article) o;
        return Objects.equals(DOI, article.DOI);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), DOI);
    }
    public String beautifulOutput(){
        return "Document type : Article" +"\n"+
                "Name of the article: " +this.getName()+"\n"+
                "Author of the article: " +this.getAuthor()+"\n"+
                "Publisher of the article: " +this.getPublisher()+"\n"+
                "Language of the article: " +this.getLanguage()+"\n"+
                "Description of the article: " +this.getDescription()+"\n"+
                "Tags of the article: " +this.getTags()+"\n"+
                "Status inLibrary of the article: " +this.isInLibrary()+"\n"+
                "ISSN of the article: " +this.getISSN()+"\n"+
                "Issue number of the article: " +this.getIssueNumber()+"\n"+
                "Amount of pages of the article: " +this.getAmountOfPages()+"\n"+
                "Date of release of the article: " +this.getReleaseData()+"\n"+
                "DOI of the article: " +this.getDOI()+"\n";
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
        System.out.println("12 DOI");
        return 12;
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + getName() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", publisher='" + getPublisher() + '\'' +
                ", language='" + getLanguage() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", tags='" + getTags() + '\'' +
                ", inLibrary=" + isInLibrary() +
                "ISSN='" + getISSN() + '\'' +
                ", issueNumber=" + getIssueNumber() +
                ", amountOfPages=" + getAmountOfPages() +
                ", releaseData='" + getReleaseData() + '\'' +
                "DOI='" + DOI + '\'' +
                '}';
    }
}
