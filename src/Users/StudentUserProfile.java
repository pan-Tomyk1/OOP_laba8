package Users;

public class StudentUserProfile extends UserProfile {
    protected int course;

    public int getCourse() {
        return course;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getGroup() {
        return group;
    }

    public String getFieldOfKnowledge() {
        return fieldOfKnowledge;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setFieldOfKnowledge(String fieldOfKnowledge) {
        this.fieldOfKnowledge = fieldOfKnowledge;
    }

    protected String faculty;
    protected String group;
    protected String fieldOfKnowledge;

    public StudentUserProfile(String name, String surname, String email, String phoneNumber, int course, String faculty, String group, String fieldOfKnowledge) {
        super(name, surname, email, phoneNumber);
        this.course = course;
        this.faculty = faculty;
        this.group = group;
        this.fieldOfKnowledge = fieldOfKnowledge;
    }

    public StudentUserProfile() {
    }

    @Override
    public String toString() {
       return  "Student{" +
               "name='" + this.getName() + '\'' +
               ", surname='" + this.getSurname() + '\'' +
               ", email='" + this.getEmail() + '\'' +
               ", phoneNumber='" + this.getPhoneNumber() + '\'' +
               ", AmountTakenDocuments=" + this.getAmountTakenDocuments() +'\'' +
               ", listOfTakenDocuments=" + this.getListOfTakenDocuments() +'\'' +
               ", course='"+this.getCourse()+'\''+
               ", faculty='"+this.getFaculty()+'\''+
               ", group='"+this.getGroup()+'\''+
               ", fieldOfKnowledge='"+this.getFieldOfKnowledge()+'\''+
               '}';
    }
    public String beautifulOutput(){
        return "User type : Student" +"\n"+
                "User name : " +this.getName()+"\n"+
                "User surname : " +this.getSurname()+"\n"+
                "User email : " +this.getEmail()+"\n"+
                "User phoneNumber : " +this.getPhoneNumber()+"\n"+
                "User course : " +this.getCourse()+"\n"+
                "User faculty : " +this.getFaculty()+"\n"+
                "User group : " +this.getGroup()+"\n"+
                "User fieldOfKnowledge : " +this.getFieldOfKnowledge()+"\n"+
                "User AmountTakenDocuments : " +this.getAmountTakenDocuments()+"\n"+
                "User listOfTakenDocuments : " +this.getListOfTakenDocuments()+"\n";
    }
    public int printAllAtributes() {
        System.out.println("1 name");
        System.out.println("2 surname");
        System.out.println("3 email");
        System.out.println("4 phoneNumber");
        System.out.println("5 course");
        System.out.println("6 faculty");
        System.out.println("7 group");
        System.out.println("8 fieldOfKnowledge");
        return 8;
    }
}
