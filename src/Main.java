import DataMaintenance.InputOutput;
import static java.lang.System.exit;

public class Main {
    static Administrator administrator = new Administrator();

    public static void main(String[] args) {
        Main main = new Main();
        while (true) {
            main.runProgram();
        }
    }

    private void runProgram() {
        System.out.println("-----STUDENT LIBRARY: ACCOUNTING OF LITERATURE AND READER FORMS-----");
        switch (mainMenu_ChooseWorkOption()) {
            case MANAGE_READERS -> manageReaders();
            case MANAGE_DOCUMENTS -> manageDocuments();
            case MANAGE_ISSUANCE-> manageIssuance();
            case SEARCH -> search();
            case EXIT -> exit(0);
        }
    }

    private MainMenuOption mainMenu_ChooseWorkOption() {
        mainMenu();
        System.out.println("Select the option to work with the system\n" +
                "Please enter a number between 1 and 5");
        return MainMenuOption.values()[InputOutput.enterInt(5, 1) - 1];
    }

    private void mainMenu() {
        System.out.println("""
                1 Manage Library Users
                2 Management of library documents (literature)
                3 Document Issuance Management
                4 Search
                5 Exit program""");
    }

    private void manageReaders() {
        switch (managingReaders_ChooseWorkOption()) {
            case ADD_USER -> administrator.addUser();
            case DELETE_USER -> administrator.deleteUser();
            case EDIT_PROFILE -> administrator.editUserProfile();
            case PRINT_USER -> administrator.printIndividualUser();
            case PRINT_ALL_USERS -> administrator.printAllUsers();
            case SORT_USERS -> administrator.sortListOfUsers();
            default -> throw new IllegalStateException("Unexpected value: " + managingReaders_ChooseWorkOption());
        }
    }

    private void manageDocuments() {
        switch (documentManagement_ChooseWorkOption()) {
            case ADD_DOCUMENT -> administrator.addDocument();
            case DELETE_DOCUMENT -> administrator.deleteDocument();
            case EDIT_DOCUMENT -> administrator.editDocument();
            case PRINT_DOCUMENT -> administrator.printIndividualDocument();
            case PRINT_ALL_DOCUMENTS -> administrator.printAllDocuments();
            case SORT_DOCUMENTS -> administrator.sortListOfDocuments();
            default -> throw new IllegalStateException("Unexpected value: " + documentManagement_ChooseWorkOption());
        }
    }

    private void manageIssuance() {
        switch (documentIssuanceManagement_ChooseWorkOption()) {
            case BORROW_BOOK -> administrator.borrowBook();
            case FIND_DOCUMENT -> administrator.findDocumentLocation();
            case RETURN_BOOK -> administrator.returnBookToLibrary();
            default ->
                    throw new IllegalStateException("Unexpected value: " + documentIssuanceManagement_ChooseWorkOption());
        }
    }

    private void search() {
        switch (search_ChooseWorkOption()) {
            case SEARCH_USER -> administrator.searchUser();
            case SEARCH_DOCUMENT -> administrator.searchDocument();
            default -> throw new IllegalStateException("Unexpected value: " + search_ChooseWorkOption());
        }
    }

    private ManageReadersOption managingReaders_ChooseWorkOption() {
        managingReaders_Menu();
        System.out.println("Select the option to work with managing readers\n" +
                "Please enter a number between 1 and 6");
        return ManageReadersOption.values()[InputOutput.enterInt(6, 1) - 1];
    }

    private void managingReaders_Menu() {
        System.out.println("""
                1 Add a user
                2 Delete a user
                3 Change user information
                4 View user information
                5 View a list of all users
                6 Sort""");
    }

    private ManageDocumentsOption documentManagement_ChooseWorkOption() {
        documentManagement_Menu();
        System.out.println("Select the option to work with managing documents\n" +
                "Please enter a number between 1 and 6");
        return ManageDocumentsOption.values()[InputOutput.enterInt(6, 1) - 1];
    }

    private void documentManagement_Menu() {
        System.out.println("""
                1 Add a document
                2 Delete a document
                3 Change document information
                4 View document information
                5 View a list of all document
                6 Sort""");
    }

    private ManageIssuanceOption documentIssuanceManagement_ChooseWorkOption() {
        documentIssuanceManagement_Manu();
        System.out.println("Select the option to work with document issuance management\n" +
                "Please enter a number between 1 and 3");
        return ManageIssuanceOption.values()[InputOutput.enterInt(3, 1) - 1];
    }

    private void documentIssuanceManagement_Manu() {
        System.out.println("""
                1 Lend the user a document
                2 Determine by the document which user he is in
                3 Return document to the library""");
    }

    private SearchOption search_ChooseWorkOption() {
        search_Menu();
        System.out.println("Select the option to work with searching\n" +
                "Please enter a number between 1 and 2");
        return SearchOption.values()[InputOutput.enterInt(2, 1) - 1];
    }

    private void search_Menu() {
        System.out.println("1 Search for a given word among users\n" +
                "2 Search for a given word among documents");
    }

}
