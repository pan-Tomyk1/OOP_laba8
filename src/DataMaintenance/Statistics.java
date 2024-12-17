package DataMaintenance;

import Documents.Document;
import Users.UserProfile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Statistics {
    private int amountUsers = 0;
    private int amountDocumnets = 0;
    private List<UserProfile> listOfUsers;
    private List<Document> listOfDocuments;

    public List<UserProfile> getListOfUsers() {
        return listOfUsers;
    }

    public List<Document> getListOfDocuments() {
        return listOfDocuments;
    }

    private Set<Integer> hashSetOfUsers;
    private Set<Integer> hashSetOfDocuments;

    public Statistics() {
        listOfUsers = new ArrayList<>();
        hashSetOfUsers = new HashSet<>();
        listOfDocuments = new ArrayList<>();
        hashSetOfDocuments = new HashSet<>();
    }

    public int getAmountUsers() {
        return amountUsers;
    }

    public void setAmountUsers(int amountUsers) {
        this.amountUsers = amountUsers;
    }

    public int getAmountDocuments() {
        return amountDocumnets;
    }

    public void setAmountDocumnets(int amountDocumnets) {
        this.amountDocumnets = amountDocumnets;
    }

    public void addUser(UserProfile userProfile) throws MyException {
        if (checkUser(userProfile.hashCode())) throw new MyException("Such a user already insinuates in the system");
        hashSetOfUsers.add(userProfile.hashCode());
        listOfUsers.add(userProfile);
        amountUsers = listOfUsers.size();
    }

    public void addDocument(Document document) throws MyException {
        if (checkDocument(document.hashCode())) throw new MyException("Such a user already insinuates in the system");
        hashSetOfDocuments.add(document.hashCode());
        listOfDocuments.add(document);
        amountDocumnets = listOfDocuments.size();
    }

    public boolean checkUser(int hash) {
        return hashSetOfUsers.contains(hash);
    }

    public boolean checkDocument(int hash) {
        return hashSetOfDocuments.contains(hash);
    }

    public UserProfile getUser(int index) {
        return listOfUsers.get(index);
    }

    public Document getDocument(int index) {
        return listOfDocuments.get(index);
    }

    public void deleteUser(int index) {
        UserProfile user = getUser(index);
        hashSetOfUsers.remove(user.hashCode());
        listOfUsers.remove(user);
        amountUsers--;
    }

    public void deleteDocument(int index) {
        Document document = getDocument(index);
        hashSetOfDocuments.remove(document.hashCode());
        listOfDocuments.remove(document);
        amountDocumnets--;
    }
    public List<Document> getListOfAvailableDocuments(){
        List<Document> list=new ArrayList<>();
        for(var i:listOfDocuments){
            if(i.isInLibrary()){
                list.add(i);
            }
        }
       return list;
    }
}
