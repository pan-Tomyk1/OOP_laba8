package Users;

public class TeacherUserProfile extends UserProfile {
    public void setAdvancedDegree(String advancedDegree) {
        this.advancedDegree = advancedDegree;
    }

    public void setScopeOfTeaching(String scopeOfTeaching) {
        this.scopeOfTeaching = scopeOfTeaching;
    }

    protected String advancedDegree;

    public String getAdvancedDegree() {
        return advancedDegree;
    }

    public String getScopeOfTeaching() {
        return scopeOfTeaching;
    }

    protected String scopeOfTeaching;
    public TeacherUserProfile(String name, String surname, String email, String phoneNumber, String advancedDegree, String scopeOfTeaching) {
        super(name, surname, email, phoneNumber);
        this.advancedDegree = advancedDegree;
        this.scopeOfTeaching = scopeOfTeaching;
    }

    public TeacherUserProfile() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + this.getName() + '\'' +
                ", surname='" + this.getSurname() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", phoneNumber='" + this.getPhoneNumber() + '\'' +
                ", AmountTakenDocuments=" + this.getAmountTakenDocuments() +'\'' +
                ", listOfTakenDocuments=" + this.getListOfTakenDocuments() +'\'' +
                ", advancedDegree='"+this.getAdvancedDegree()+'\''+
                ", scopeOfTeaching='"+this.getScopeOfTeaching()+'\''+
                '}';
    }
    public String beautifulOutput(){
        return "User type : Teacher" +"\n"+
                "User name : " +this.getName()+"\n"+
                "User surname : " +this.getSurname()+"\n"+
                "User email : " +this.getEmail()+"\n"+
                "User phoneNumber : " +this.getPhoneNumber()+"\n"+
                "User advancedDegree : " +this.getAdvancedDegree()+"\n"+
                "User scopeOfTeaching : " +this.getScopeOfTeaching()+"\n"+
                "User AmountTakenDocuments : " +this.getAmountTakenDocuments()+"\n"+
                "User listOfTakenDocuments : " +this.getListOfTakenDocuments()+"\n";
    }
    public int printAllAtributes() {
        System.out.println("1 name");
        System.out.println("2 surname");
        System.out.println("3 email");
        System.out.println("4 phoneNumber");
        System.out.println("5 advancedDegree");
        System.out.println("6 scopeOfTeaching");
        return 6;
    }
}
