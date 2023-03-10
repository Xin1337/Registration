public class OOP {
    // Variables
    private int age;
    private String names;
    private String gender;
    private int contactNumber;
    private String address;
    private String course;
    private String year;

    // Constructor for the OOP class
    public OOP(int age, String names, String gender, int contactNumber, String address, String course, String year) {
        this.age = age;
        this.names = names;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.address = address;
        this.course = course;
        this.year = year;
    }

    // Getters
    public int getAge() {
        return age;
    }

    public String getName() {
        return names;
    }

    public String getGender() {
        return gender;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getCourse() {
        return course;
    }

    public String getYear() {
        return year;
    }
}