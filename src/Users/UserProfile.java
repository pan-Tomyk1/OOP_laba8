package Users;

import Documents.Document;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public abstract class UserProfile {
    HashSet<Document>hashSet;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private int AmountTakenDocuments;

    public List<Document> getListOfTakenDocuments() {
        return listOfTakenDocuments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAmountTakenDocuments() {
        return AmountTakenDocuments;
    }

    public void setAmountTakenDocuments(int amountTakenDocuments) {
        AmountTakenDocuments = amountTakenDocuments;
    }

    private List<Document> listOfTakenDocuments;

    public UserProfile(String name, String surname, String email, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        AmountTakenDocuments = 0;
        listOfTakenDocuments = new ArrayList<Document>();
        hashSet=new HashSet<>();
    }

    public UserProfile() {
    }

    public HashSet<Document> getHashSet() {
        return hashSet;
    }

    public void setHashSet(HashSet<Document> hashSet) {
        this.hashSet = hashSet;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UserProfile that = (UserProfile) o;
//        return AmountTakenDocuments == that.AmountTakenDocuments && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(email, that.email) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(listOfTakenDocuments, that.listOfTakenDocuments);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, surname, email, phoneNumber, AmountTakenDocuments, listOfTakenDocuments);
//    }

    @Override
    public String toString() {
        return "Regular user{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", AmountTakenDocuments=" + AmountTakenDocuments +
                ", listOfTakenDocuments=" + listOfTakenDocuments +
                '}';
    }

    public String beautifulOutput() {
        return "User type : Regular user" + "\n" +
                "User name : " + this.name + "\n" +
                "User surname : " + this.surname + "\n" +
                "User email : " + this.email + "\n" +
                "User phoneNumber : " + this.phoneNumber + "\n" +
                "User AmountTakenDocuments : " + this.AmountTakenDocuments + "\n" +
                "User listOfTakenDocuments : " + this.listOfTakenDocuments + "\n";
    }

    public int printAllAtributes() {
        System.out.println("1 name");
        System.out.println("2 surname");
        System.out.println("3 email");
        System.out.println("4 phoneNumber");
        return 4;
    }
}
