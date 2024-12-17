package DataMaintenance;

import Users.RegularUserProfile;
import Users.StudentUserProfile;
import Users.TeacherUserProfile;
import Users.UserProfile;

import java.util.ArrayList;

public class UserMaintaining {
    private final int MAX_STRING_INPUT_LENGTH = 30;
    private final int MAX_PHONE_NUMBER_LENGTH = 10;
    static UserMaintaining userMaintaining= new UserMaintaining();
    public static UserProfile addUser() {

        int userType = userMaintaining.chooseUserType();
        System.out.println("---Enter user data");
        String name = userMaintaining.enterName();
        String surname=userMaintaining.enterSurname();
        String email=userMaintaining.enterEmail();
        String phoneNumber=userMaintaining.enterPhoneNumber();
        switch (userType) {
            case 1: {
                return new RegularUserProfile(name, surname, email, phoneNumber);
            }
            case 2: {
                int course =userMaintaining.enterCourse();
                String faculty = userMaintaining.enterFaculty();
                String group = userMaintaining.enterGroup();
                String fieldOfKnowledge = userMaintaining.enterFieldOfKnowledge();
                return new StudentUserProfile(name, surname, email, phoneNumber, course, faculty, group, fieldOfKnowledge);

            }
            case 3: {
                String advancedDegree = userMaintaining.enterAdvancedDegree();
                String scopeOfTeaching = userMaintaining.enterScopeOfTeaching();
                return new TeacherUserProfile(name, surname, email, phoneNumber, advancedDegree, scopeOfTeaching);

            }
        }
        return null;
    }

    public String enterName(){
        System.out.println("-Enter the user name");
        return enterStringData(MAX_STRING_INPUT_LENGTH);
    }
    public String enterSurname(){
        System.out.println("-Enter the user surname");
        return enterStringData(MAX_STRING_INPUT_LENGTH);
    }
    private String enterEmail(){
        System.out.println("-Enter the user email");
        return enterStringData(MAX_STRING_INPUT_LENGTH);
    }
    private String enterPhoneNumber(){
        String phoneNumber;
        do{
            System.out.println("-Enter the user phoneNumber");
            phoneNumber = enterStringData(MAX_PHONE_NUMBER_LENGTH);
        }while(!Validation.validatePhoneNumber(phoneNumber.toCharArray()));
        return phoneNumber;
    }
    private int enterCourse(){
        System.out.println("-Enter the course");
        return InputOutput.enterInt(8, 1);
    }
    private String enterFaculty(){
        System.out.println("-Enter the faculty");
        return enterStringData(MAX_STRING_INPUT_LENGTH);
    }
    private String enterGroup(){
        System.out.println("-Enter the group");
        return enterStringData(MAX_STRING_INPUT_LENGTH);
    }
    private String enterAdvancedDegree(){
        System.out.println("-Enter the advancedDegree");
        return enterStringData(MAX_STRING_INPUT_LENGTH);
    }
    private String enterFieldOfKnowledge(){
        System.out.println("-Enter the fieldOfKnowledge");
        return enterStringData(MAX_STRING_INPUT_LENGTH);
    }
    private String enterScopeOfTeaching(){
        System.out.println("-Enter the scopeOfTeaching");
        return enterStringData(MAX_STRING_INPUT_LENGTH);
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
    private int chooseUserType() {
        System.out.println("Select user type");
        printTypeOfUsers();
        return InputOutput.enterInt(3, 1);
    }
    public static void printTypeOfUsers() {
        System.out.println("1 Regular library user");
        System.out.println("2 Student");
        System.out.println("3 Teacher");
    }
    public static void editProfile(Statistics statistics) {
        if(statistics.getAmountUsers()==0){
            System.out.println("No users found, add reader first");
            return;
        }
        userMaintaining.printAllUsers(statistics);
        System.out.println("Select the user you want to edit the data, max = "+(statistics.getAmountUsers())+", min = 1");
        int userIndex=InputOutput.enterInt((statistics.getAmountUsers()),1);
        UserProfile user=statistics.getUser(userIndex-1);
        System.out.println(user.beautifulOutput());
        System.out.println("What data do you want to edit?");
        int numberOfAtributes=user.printAllAtributes();
        System.out.println("Please select the data you want to edit, max="+numberOfAtributes+", min=1");
        int dataType = InputOutput.enterInt(numberOfAtributes, 1);
        switch (dataType){
            case 1:{
                user.setName(userMaintaining.enterName());
                break;}
            case 2:{
                user.setSurname(userMaintaining.enterSurname());
                break;}
            case 3:{
                user.setEmail(userMaintaining.enterEmail());
                break;}
            case 4:{
                user.setPhoneNumber(userMaintaining.enterPhoneNumber());
                break;}
            case 5: {
                if(user.getClass()==StudentUserProfile.class){
                    ((StudentUserProfile) user).setCourse(userMaintaining.enterCourse());
                }else{
                    ((TeacherUserProfile) user).setAdvancedDegree(userMaintaining.enterAdvancedDegree());
                }
                break;
            }
            case 6: {
                if(user.getClass()==StudentUserProfile.class){
                    ((StudentUserProfile) user).setFaculty(userMaintaining.enterFaculty());
                }else{
                    ((TeacherUserProfile) user).setScopeOfTeaching(userMaintaining.enterScopeOfTeaching());
                }
                break;
            }
            case 7:{
                ((StudentUserProfile) user).setGroup(userMaintaining.enterGroup());
                break;
            }
            case 8:{
                ((StudentUserProfile) user).setFieldOfKnowledge(userMaintaining.enterFieldOfKnowledge());
                break;
            }
        }
    }
    public static void printAllUsers(Statistics statistics) {

        System.out.println("No. | User");
        System.out.println("----|--------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < statistics.getAmountUsers(); i++) {
            System.out.printf("%-4d| %s\n", i + 1, statistics.getListOfUsers().get(i));
        }
        System.out.println("----|--------------------------------------------------------------------------------------------------------");
    }
    public static void deleteUser(Statistics statistics){
        if(statistics.getAmountUsers()==0){
            System.out.println("No users found, add reader first");
            return;
        }
        userMaintaining.printAllUsers(statistics);
        System.out.println("Select the user you want to delete, max = "+(statistics.getAmountUsers())+", min = 1");
        int userIndex=InputOutput.enterInt((statistics.getAmountUsers()),1);
        UserProfile userProfile=statistics.getUser(userIndex-1);
        statistics.getListOfUsers().remove(userProfile);
        statistics.setAmountUsers(statistics.getListOfUsers().size());
    }
    public static void printIndividualUser(Statistics statistics){
        if(statistics.getAmountUsers()==0){
            System.out.println("No users found, add reader first");
            return;
        }
        userMaintaining.printAllUsers(statistics);
        System.out.println("Select the user you want to see, max = "+(statistics.getAmountUsers())+", min = 1");
        int userIndex=InputOutput.enterInt((statistics.getAmountUsers()),1)-1;
        System.out.println(statistics.getUser(userIndex).beautifulOutput());
    }
    public static ArrayList<UserProfile> findUserByTheName(String name, Statistics statistics){
        ArrayList<UserProfile> arrayList = new ArrayList<>();
        for(var i: statistics.getListOfUsers()){
            if(i.getName().contains(name)){
                arrayList.add(i);
            }
        }
        return arrayList;
    }
    public static ArrayList<UserProfile> findUserByTheSurname(String surname, Statistics statistics){
        ArrayList<UserProfile> arrayList = new ArrayList<>();
        for(var i: statistics.getListOfUsers()){
            if(i.getSurname().contains(surname)){
                arrayList.add(i);
            }
        }
        return arrayList;
    }
    public static ArrayList<UserProfile> findUserByTheType(UserProfile user, Statistics statistics){
        ArrayList<UserProfile> arrayList = new ArrayList<>();
        for(var i: statistics.getListOfUsers()){
            if(i.getClass()==user.getClass()){
                arrayList.add(i);
            }
        }
        return arrayList;
    }

}
