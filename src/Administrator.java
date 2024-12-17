import DataMaintenance.*;
import Documents.Article;
import Documents.Book;
import Documents.Document;
import Documents.Magazine;
import Users.RegularUserProfile;
import Users.StudentUserProfile;
import Users.TeacherUserProfile;
import Users.UserProfile;
import java.util.Collections;
import java.util.List;

public class Administrator extends RegularUserProfile  {
    Statistics statistics;
    public Administrator() {
        statistics = new Statistics();
    }

    public void addUser() {
        addUserInList(UserMaintaining.addUser());
        System.out.println("-----User added successfully-----");
    }

    public void editUserProfile() {
        UserMaintaining.editProfile(statistics);
        System.out.println("-----User profile edited successfully-----");
    }

    public void editDocument() {
        DocumentsMaintaining.editDocument(statistics);
        System.out.println("-----Document edited successfully-----");
    }

    private boolean addUserInList(UserProfile userProfile) {
        try {
            statistics.addUser(userProfile);
            return true;
        } catch (MyException e) {
            System.out.println("Invalid input, " + e.getMessage());
            return false;
        }
    }

    private boolean addDocumentInList(Document document) {
        try {
            statistics.addDocument(document);
            return true;
        } catch (MyException e) {
            System.out.println("Invalid input, " + e.getMessage());
            return false;
        }
    }


    public void deleteUser() {
        UserMaintaining.deleteUser(statistics);
        System.out.println("----User deleted successfully-----");
    }

    public void deleteDocument() {
        DocumentsMaintaining.deleteDocument(statistics);
        System.out.println("Document deleted successfully");
    }

    public void printIndividualUser() {
        UserMaintaining.printIndividualUser(statistics);
    }

    public void printIndividualDocument() {
        DocumentsMaintaining.printIndividualDocument(statistics);
    }

    public void sortListOfUsers() {
        if (statistics.getAmountUsers() == 0) {
            System.out.println("No users found, add reader first");
            return;
        }
        System.out.println("Choose what to sort the list");
        System.out.println("1 by name");
        System.out.println("2 by surname");
        int whatToSort = InputOutput.enterInt(2, 1);
        System.out.println("Choose sort type");
        System.out.println("1 Ascending");
        System.out.println("2 Descending");
        int sortType = InputOutput.enterInt(2, 1);
        switch (whatToSort) {
            case 1: {
                if (sortType == 1) {
                    Collections.sort(statistics.getListOfUsers(), (s1, s2) -> s1.getName().compareTo(s2.getName()));
                } else {
                    Collections.sort(statistics.getListOfUsers(), (s1, s2) -> s2.getName().compareTo(s1.getName()));
                }
                break;
            }
            case 2: {
                if (sortType == 1) {
                    Collections.sort(statistics.getListOfUsers(), (s1, s2) -> s1.getSurname().compareTo(s2.getSurname()));
                } else {
                    Collections.sort(statistics.getListOfUsers(), (s1, s2) -> s2.getSurname().compareTo(s1.getSurname()));
                }
                break;
            }
        }
        System.out.println("----List of users sorted successfully-----");
    }

    public void sortListOfDocuments() {
        if (statistics.getAmountDocuments() == 0) {
            System.out.println("No document found, add document first");
            return;
        }
        System.out.println("Choose what to sort the list");
        System.out.println("1 by name");
        System.out.println("2 by author");
        System.out.println("3 by publisher");
        System.out.println("4 by language");
        System.out.println("5 by tags");
        int whatToSort = InputOutput.enterInt(5, 1);
        System.out.println("Choose sort type");
        System.out.println("1 Ascending");
        System.out.println("2 Descending");
        int sortType = InputOutput.enterInt(2, 1);
        switch (whatToSort) {
            case 1: {
                if (sortType == 1) {
                    Collections.sort(statistics.getListOfDocuments(), (s1, s2) -> s1.getName().compareTo(s2.getName()));
                } else {
                    Collections.sort(statistics.getListOfDocuments(), (s1, s2) -> s2.getName().compareTo(s1.getName()));
                }
                break;
            }
            case 2: {
                if (sortType == 1) {
                    Collections.sort(statistics.getListOfDocuments(), (s1, s2) -> s1.getAuthor().compareTo(s2.getAuthor()));
                } else {
                    Collections.sort(statistics.getListOfDocuments(), (s1, s2) -> s2.getAuthor().compareTo(s1.getAuthor()));
                }
                break;
            }
            case 3: {
                if (sortType == 1) {
                    Collections.sort(statistics.getListOfDocuments(), (s1, s2) -> s1.getPublisher().compareTo(s2.getPublisher()));
                } else {
                    Collections.sort(statistics.getListOfDocuments(), (s1, s2) -> s2.getPublisher().compareTo(s1.getPublisher()));
                }
                break;
            }
            case 4: {
                if (sortType == 1) {
                    Collections.sort(statistics.getListOfDocuments(), (s1, s2) -> s1.getLanguage().compareTo(s2.getLanguage()));
                } else {
                    Collections.sort(statistics.getListOfDocuments(), (s1, s2) -> s2.getLanguage().compareTo(s1.getLanguage()));
                }
                break;
            }
            case 5: {
                if (sortType == 1) {
                    Collections.sort(statistics.getListOfDocuments(), (s1, s2) -> s1.getTags().compareTo(s2.getTags()));
                } else {
                    Collections.sort(statistics.getListOfDocuments(), (s1, s2) -> s2.getTags().compareTo(s1.getTags()));
                }
                break;
            }

        }
    }

    public void printAllUsers() {
        UserMaintaining.printAllUsers(statistics);
    }

    public void printAllDocuments() {
        DocumentsMaintaining.printAllDocuments(statistics);
    }

    public void addDocument() {
        addDocumentInList(DocumentsMaintaining.addDocument());
        System.out.println("Document added successfully");
    }

    private UserProfile chooseUser() {
        UserMaintaining.printAllUsers(statistics);
        System.out.println("Please, select a user which wants to lend a book");
        System.out.println("Please, enter a number min = 1, max = " + statistics.getAmountUsers());
        int userIndex = InputOutput.enterInt(statistics.getAmountUsers(), 1);
        return statistics.getUser(userIndex - 1);
    }

    public void borrowBook() {
        if (statistics.getAmountUsers() == 0) {
            System.out.println("No users found, add reader first");
            return;
        }
        if (statistics.getAmountDocuments() == 0) {
            System.out.println("No documents found, add document first");
            return;
        }
        UserProfile user = chooseUser();
        if (user.getAmountTakenDocuments() >= 5) {
            System.out.println("This user took more than 5 books to the library and has not yet returned them.");
            return;
        }
        System.out.println(user.beautifulOutput());
        List<Document> listOfAvailableDocuments=statistics.getListOfAvailableDocuments();
        int amountAvailableBooks=listOfAvailableDocuments.size();
        int maxBooksAllowed=5-user.getAmountTakenDocuments();
        if(maxBooksAllowed>amountAvailableBooks){
            maxBooksAllowed=amountAvailableBooks;
        }
        System.out.println("Enter the number of books you want to borrow from the library, min = 1, max = " + maxBooksAllowed);
        int amount = InputOutput.enterInt(maxBooksAllowed - getAmountTakenDocuments(), 1);
        printDocumentList(listOfAvailableDocuments);
        int documentIndex;
        Document document;
        for (int i = 0; i < amount; i++) {
            System.out.println("Select the document you want to borrow for this");
            System.out.println("Enter the document number min = 1, max = " + amountAvailableBooks);
            documentIndex = InputOutput.enterInt(amountAvailableBooks, 1);
            document = listOfAvailableDocuments.get(documentIndex - 1);
            user.getListOfTakenDocuments().add(document);
            user.setAmountTakenDocuments(user.getAmountTakenDocuments() + 1);
            user.getHashSet().add(document);
            document.setInLibrary(false);
        }
    }

    public void findDocumentLocation() {
        if (statistics.getAmountDocuments() == 0) {
            System.out.println("No document found, add document first");
            return;
        }
        DocumentsMaintaining.printAllDocuments(statistics);
        System.out.println("Please enter the number of the document you want to locate, min = 1, max = " + statistics.getAmountDocuments());
        int documentIndex = InputOutput.enterInt(statistics.getAmountDocuments(), 1);
        Document document = statistics.getDocument(documentIndex - 1);
        if (!document.isInLibrary()) {
            System.out.println("The document is not in the library, it was borrowed by this user");
            System.out.println(DocumentsMaintaining.locateDocument(document, statistics).beautifulOutput());
        } else {
            System.out.println("The document is in the library");
        }
    }

    public void returnBookToLibrary() {
        if (statistics.getAmountDocuments() == 0) {
            System.out.println("No document found, add document first");
            return;
        }
        if (statistics.getAmountUsers() == 0) {
            System.out.println("No users found, add reader first");
            return;
        }
        UserProfile user = chooseUser();
        if (user.getAmountTakenDocuments() == 0) {
            System.out.println("No taken documents found, borrow a document first");
            return;
        }
        System.out.println("Select the book you want to return");
        for (int i = 0; i < user.getAmountTakenDocuments(); i++) {
            System.out.print((i + 1)+"\t");
            System.out.println(user.getListOfTakenDocuments().get(i));
        }
        int documentIndex = InputOutput.enterInt(user.getAmountTakenDocuments(), 1);
        Document document=user.getListOfTakenDocuments().get(documentIndex-1);
        document.setInLibrary(true);
        user.getListOfTakenDocuments().remove(document);
        user.setAmountTakenDocuments(user.getListOfTakenDocuments().size());
    }

    public void searchUser() {
        if (statistics.getAmountUsers() == 0) {
            System.out.println("No users found, add reader first");
            return;
        }
        System.out.println("Choose which field you will search");
        System.out.println("1 name");
        System.out.println("2 surname");
        System.out.println("3 type of reader");
        int type = InputOutput.enterInt(3, 1);
        switch (type) {
            case 1: {
                System.out.println("Enter name :");
                String name = InputOutput.enterString();
                System.out.println(UserMaintaining.findUserByTheName(name, statistics));
                break;
            }
            case 2: {
                System.out.println("Enter surname :");
                String surname = InputOutput.enterString();
                System.out.println(UserMaintaining.findUserByTheSurname(surname, statistics));
                break;
            }
            case 3: {
                UserMaintaining.printTypeOfUsers();
                System.out.println("Select user type min = 1, max = 3");
                int userType = InputOutput.enterInt(3, 1);
                switch (userType) {
                    case 1: {
                        printUserList(UserMaintaining.findUserByTheType(new RegularUserProfile(), statistics));
                        break;
                    }
                    case 2: {
                        printUserList(UserMaintaining.findUserByTheType(new StudentUserProfile(), statistics));
                        break;
                    }
                    case 3: {
                        printUserList(UserMaintaining.findUserByTheType(new TeacherUserProfile(), statistics));
                        break;
                    }
                }
                break;
            }
        }
    }

    public void searchDocument() {
        if (statistics.getAmountDocuments() == 0) {
            System.out.println("No document found, add document first");
            return;
        }
        System.out.println("Choose which field you will search, min = 1, max = 6");
        System.out.println("1 name");
        System.out.println("2 author");
        System.out.println("3 type of document");
        System.out.println("4 publisher");
        System.out.println("5 language");
        System.out.println("6 tags");
        int userChoice = InputOutput.enterInt(6, 1);
        switch (userChoice) {
            case 1: {
                System.out.println("Enter name :");
                String name = InputOutput.enterString();
                printDocumentList(DocumentsMaintaining.findDocumentByTheName(name, statistics));
                break;
            }
            case 2: {
                System.out.println("Enter author :");
                String author = InputOutput.enterString();
                printDocumentList(DocumentsMaintaining.findDocumentByTheAuthor(author, statistics));
                break;
            }
            case 3: {
                int documentType = DocumentsMaintaining.chooseTypeOfDocument();
                switch (documentType) {
                    case 1: {
                        printDocumentList(DocumentsMaintaining.findDocumentByTheType(new Article(), statistics));
                        break;
                    }
                    case 2: {
                        printDocumentList(DocumentsMaintaining.findDocumentByTheType(new Book(), statistics));
                        break;
                    }
                    case 3: {
                        printDocumentList(DocumentsMaintaining.findDocumentByTheType(new Magazine(), statistics));
                        break;
                    }
                }
                break;
            }
            case 4: {
                System.out.println("Enter publisher :");
                String publisher = InputOutput.enterString();
                printDocumentList(DocumentsMaintaining.findDocumentByThePublisher(publisher, statistics));
                break;
            }
            case 5: {
                System.out.println("Enter language :");
                String language = InputOutput.enterString();
                printDocumentList(DocumentsMaintaining.findDocumentByTheLanguage(language, statistics));
                break;
            }
            case 6: {
                System.out.println("Enter tags :");
                String tags = InputOutput.enterString();
                printDocumentList(DocumentsMaintaining.findDocumentByTheTags(tags, statistics));
                break;
            }
        }

    }
    private void printUserList(List<UserProfile> list){
        if(list.isEmpty()){
            System.out.println("No users found for your request");
            return;
        }
        for(var i:list ){
            System.out.println(i);
        }
    }
    private void printDocumentList(List<Document> list){
        if(list.isEmpty()){
            System.out.println("No documents found for your request");
            return;
        }
        for(var i:list ){
            System.out.println(i);
        }
    }
}
