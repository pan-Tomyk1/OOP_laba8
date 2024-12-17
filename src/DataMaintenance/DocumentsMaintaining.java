package DataMaintenance;
import Documents.Article;
import Documents.Book;
import Documents.Document;
import Documents.Magazine;
import Users.UserProfile;

import java.util.ArrayList;

public class DocumentsMaintaining {
    private final int MAX_STRING_INPUT_LENGTH=40;
    private final int MAX_DESCRIPTION_LENGTH=500;
    private final int MAX_TAG_LENGTH=100;
    static DocumentsMaintaining documentsMaintaining = new DocumentsMaintaining();
    public static Document addDocument(){
        int type=documentsMaintaining.chooseTypeOfDocument();
        String name=documentsMaintaining.enterName();
        String author=documentsMaintaining.enterAuthor();
        String dateOfRelease=documentsMaintaining.enterDateOfRelease();
        String publisher=documentsMaintaining.enterPublisher();
        String language=documentsMaintaining.enterLanguage();
        String description=documentsMaintaining.enterDescription();
        String tags=documentsMaintaining.enterTags();
        switch (type){
            case 1:{
                String DOI=documentsMaintaining.enterDOI();
                String ISSN=documentsMaintaining.enterISSN();
                String releaseDate=documentsMaintaining.enterDateOfRelease();
                int amountOfPages=documentsMaintaining.enterAmountOfPages();
                int issueNumber=documentsMaintaining.enterIssueNumber();
                Article article=new Article(name,author,publisher,language,description,tags,true,ISSN, issueNumber,amountOfPages,releaseDate,DOI);
                return article;
                }
            case 2:{
                String ISBN=documentsMaintaining.enterISBN();
                String genre=documentsMaintaining.enterGenre();
                int amountOfPages=documentsMaintaining.enterAmountOfPages();
                Book book=new Book(name, author, publisher,language,description,tags,true,ISBN,genre,amountOfPages);
                return book;
            }
            case 3:{
                String ISSN=documentsMaintaining.enterISSN();
                String releaseDate=documentsMaintaining.enterDateOfRelease();
                int amountOfPages=documentsMaintaining.enterAmountOfPages();
                int issueNumber=documentsMaintaining.enterIssueNumber();
                Magazine magazine=new Magazine(name, author, publisher,language,description,tags,true,ISSN,issueNumber,amountOfPages,releaseDate);
                return magazine;
                }
        }
        return null;
    }

    private String enterStringData(int maxLength) {
        String input;
        boolean checkAtribute;
        do {
            input = InputOutput.enterString();
            checkAtribute = input.length() <= maxLength;
            if (!checkAtribute) {
                System.out.println("Invalid input, input is too long");
            }
        } while (!checkAtribute);
        return input;
    }
    private String enterName(){
        System.out.println("-Enter the name of the document");
        return enterStringData(MAX_STRING_INPUT_LENGTH);
    }
    private String enterDOI(){
        System.out.println("-Enter the DOI of the article");
        return enterStringData(MAX_STRING_INPUT_LENGTH);
    }
    private String enterISBN(){
        System.out.println("-Enter the ISBN of the book");
        return enterStringData(MAX_STRING_INPUT_LENGTH);
    }
    private String enterGenre(){
        System.out.println("-Enter the genre of the book");
        return enterStringData(MAX_STRING_INPUT_LENGTH);
    }
    private String enterISSN(){
        System.out.println("-Enter the DOI of the article");
        return enterStringData(MAX_STRING_INPUT_LENGTH);
    }
    private int enterAmountOfPages(){
        System.out.println("-Enter the amount of pages of the document");
        return InputOutput.enterInt(Integer.MAX_VALUE,0);
    }
    private int enterIssueNumber(){
        System.out.println("-Enter the issue number of the document");
        return InputOutput.enterInt(Integer.MAX_VALUE,0);
    }
    private String releaseData(){
        System.out.println("-Enter the release data of the document");
        return enterStringData(MAX_STRING_INPUT_LENGTH);
    }
    private String enterAuthor(){
        System.out.println("-Enter the author of the document");
        return enterStringData(MAX_STRING_INPUT_LENGTH);
    }
    private String enterDateOfRelease(){
        System.out.println("-Enter the date of release of the document");
        return enterStringData(MAX_STRING_INPUT_LENGTH);
    }
    private boolean enterStatus(){
        System.out.println("-Please enter the status of the document i.e.\n" +
                " whether the document is in the library \n" +
                "or it is given to some reader");
        System.out.println("Please enter true if the document is in the library, otherwise enter false");
        boolean checkResult=false;
        boolean status=false;
        while(!checkResult){
            try{
                status=InputOutput.enterBooleanData();
                checkResult=true;
            }catch (Exception e){
                System.out.println("Invalid input. Please, enter true or false");
            }
        }
        return status;
    }
    private boolean enterBooleanData(){
        return InputOutput.enterBooleanData();
    }
    private String enterPublisher(){
        System.out.println("-Enter the publisher of the document");
        return enterStringData(MAX_STRING_INPUT_LENGTH);
    }
    private String enterLanguage(){
        System.out.println("-Enter the language of the document");
        return enterStringData(MAX_STRING_INPUT_LENGTH);
    }
    private String enterDescription(){
        System.out.println("-Enter the description of the document");
        return enterStringData(MAX_DESCRIPTION_LENGTH);
    }
    private String enterTags(){
        System.out.println("-Enter the tags of the document");
        return enterStringData(MAX_TAG_LENGTH);
    }
    public static int chooseTypeOfDocument(){
        System.out.println("Please select a document type");
        System.out.println("1 Article");
        System.out.println("2 Book");
        System.out.println("3 Magazine");
        System.out.println("Select document type min 1, max 3");
        return InputOutput.enterInt(3,1);
    }

    public static void editDocument(Statistics statistics){
        if (statistics.getAmountDocuments() == 0) {
            System.out.println("No document found, add document first");
            return;
        }
        documentsMaintaining.printAllDocuments(statistics);
        System.out.println("Select the document you want to edit the data, max = "+(statistics.getAmountDocuments())+", min = 1");
        int documentIndex=InputOutput.enterInt((statistics.getAmountDocuments()),1);
        Document document=statistics.getDocument(documentIndex-1);
        System.out.println(document.beautifulOutput());
        System.out.println("What data do you want to edit?");
        int numberOfAtributes=document.printAllAtributes();
        System.out.println("Please select the data you want to edit, max="+numberOfAtributes+", min=1");
        int dataType = InputOutput.enterInt(numberOfAtributes, 1);
        switch (dataType){
            case 1:{
                document.setName(documentsMaintaining.enterName());
                break;}
            case 2:{
                document.setAuthor(documentsMaintaining.enterAuthor());
                break;}
            case 3:{
                document.setPublisher(documentsMaintaining.enterPublisher());
                break;}
            case 4:{
                document.setLanguage(documentsMaintaining.enterLanguage());
                break;}
            case 5:{
                document.setDescription(documentsMaintaining.enterDescription());
                break;}
            case 6:{
                document.setTags(documentsMaintaining.enterTags());
                break;}
            case 7:{
                document.setInLibrary(documentsMaintaining.enterStatus());
                break;}
            case 8: {
                if(document.getClass()== Magazine.class){
                    ((Magazine) document).setISSN(documentsMaintaining.enterISSN());
                }
                if(document.getClass()== Article.class){
                    ((Article) document).setISSN(documentsMaintaining.enterISSN());
                }
                if(document.getClass()== Book.class){
                    ((Book) document).setISBN(documentsMaintaining.enterISBN());
                }
                break;
            }
            case 9: {
                if(document.getClass()== Magazine.class){
                    ((Magazine) document).setIssueNumber(documentsMaintaining.enterIssueNumber());
                }
                if(document.getClass()== Article.class){
                    ((Article) document).setIssueNumber(documentsMaintaining.enterIssueNumber());
                }
                if(document.getClass()== Book.class){
                    ((Book) document).setGenre(documentsMaintaining.enterGenre());
                }
                break;
            }
            case 10: {
                if(document.getClass()== Magazine.class){
                    ((Magazine) document).setAmountOfPages(documentsMaintaining.enterAmountOfPages());
                }
                if(document.getClass()== Article.class){
                    ((Article) document).setAmountOfPages(documentsMaintaining.enterAmountOfPages());
                }
                if(document.getClass()== Book.class){
                    ((Book) document).setAmountOfPages(documentsMaintaining.enterAmountOfPages());
                }
                break;
            }
            case 11: {
                if(document.getClass()== Magazine.class){
                    ((Magazine) document).setReleaseData(documentsMaintaining.enterDateOfRelease());
                }
                else{
                    ((Article) document).setReleaseData(documentsMaintaining.enterDateOfRelease());
                }
                break;
            }
            case 12:{
                ((Article) document).setDOI(documentsMaintaining.enterDOI());
                break;
            }
        }
    }
    public static void printAllDocuments(Statistics statistics){
        System.out.println("No. | User");
        System.out.println("----|--------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < statistics.getAmountDocuments(); i++) {
            System.out.printf("%-4d| %s\n", i + 1, statistics.getListOfDocuments().get(i));
        }
        System.out.println("----|--------------------------------------------------------------------------------------------------------");

    }
    public static void printAvailableDocuments(Statistics statistics){
        Document document;
        System.out.println("No. | User");
        System.out.println("----|--------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < statistics.getAmountDocuments(); i++) {
            document=statistics.getListOfDocuments().get(i);
            if(!document.isInLibrary())break;
            System.out.printf("%-4d| %s\n", i + 1, document);
        }
        System.out.println("----|--------------------------------------------------------------------------------------------------------");

    }
    public static void deleteDocument(Statistics statistics){
        if (statistics.getAmountDocuments() == 0) {
            System.out.println("No document found, add document first");
            return;
        }
        documentsMaintaining.printAllDocuments(statistics);
        System.out.println("Select the document you want to delete, max = "+(statistics.getAmountDocuments())+", min = 1");
        int documentIndex=InputOutput.enterInt((statistics.getAmountDocuments()),1)-1;
        Document document=statistics.getDocument(documentIndex);
        statistics.getListOfDocuments().remove(document);
        statistics.setAmountDocumnets(statistics.getListOfDocuments().size());
    }
    public static void printIndividualDocument(Statistics statistics){
        if (statistics.getAmountDocuments() == 0) {
            System.out.println("No document found, add document first");
            return;
        }
        DocumentsMaintaining.printAllDocuments(statistics);
        System.out.println("Select the user you want to see, max = "+(statistics.getAmountDocuments())+", min = 1");
        int documentIndex=InputOutput.enterInt((statistics.getAmountDocuments()),1)-1;
        System.out.println(statistics.getDocument(documentIndex).beautifulOutput());
    }
    public static UserProfile locateDocument(Document document, Statistics statistics){
        for(var i :statistics.getListOfUsers()){
            if(i.getHashSet().contains(document)){
                return i;
            }
        }
        return null;
    }
    public static ArrayList<Document> findDocumentByTheName(String name, Statistics statistics){
        ArrayList<Document> arrayList = new ArrayList<>();
        for(var i: statistics.getListOfDocuments()){
            if(i.getName().contains(name)){
                arrayList.add(i);
            }
        }
        return arrayList;
    }
    public static ArrayList<Document> findDocumentByTheAuthor(String author, Statistics statistics){
        ArrayList<Document> arrayList = new ArrayList<>();
        for(var i: statistics.getListOfDocuments()){
            if(i.getAuthor().contains(author)){
                arrayList.add(i);
            }
        }
        return arrayList;
    }
    public static ArrayList<Document> findDocumentByThePublisher(String publisher, Statistics statistics){
        ArrayList<Document> arrayList = new ArrayList<>();
        for(var i: statistics.getListOfDocuments()){
            if(i.getPublisher().contains(publisher)){
                arrayList.add(i);
            }
        }
        return arrayList;
    }
    public static ArrayList<Document> findDocumentByTheLanguage(String language, Statistics statistics){
        ArrayList<Document> arrayList = new ArrayList<>();
        for(var i: statistics.getListOfDocuments()){
            if(i.getLanguage().contains(language)){
                arrayList.add(i);
            }
        }
        return arrayList;
    }
    public static ArrayList<Document> findDocumentByTheTags(String tags, Statistics statistics){
        ArrayList<Document> arrayList = new ArrayList<>();
        for(var i: statistics.getListOfDocuments()){
            if(i.getTags().contains(tags)){
                arrayList.add(i);
            }
        }
        return arrayList;
    }
    public static ArrayList<Document> findDocumentByTheType(Document document, Statistics statistics){
        ArrayList<Document> arrayList = new ArrayList<>();
        for(var i: statistics.getListOfDocuments()){
            if(i.getClass()==document.getClass()){
                arrayList.add(i);
            }
        }
        return arrayList;
    }
}
