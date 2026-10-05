package models;

public class Patient {

    private String patientID;
    private String name;
    private String mobile;
    private String email;
    private String city;
    private int age;
    private String medicalHistory;

    // Constructor
    public Patient(String patientID, String name,
                   String mobile, String email,
                   String city, int age,
                   String medicalHistory) {
        this.patientID = patientID;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.city = city;
        this.age = age;
        this.medicalHistory = medicalHistory;
    }

    // Getters
    public String getPatientID() { return patientID; }
    public String getName() { return name; }
    public String getMobile() { return mobile; }
    public String getEmail() { return email; }
    public String getCity() { return city; }
    public int getAge() { return age; }
    public String getMedicalHistory() {
        return medicalHistory;
    }

    // Setters
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    @Override
    public String toString() {
        return "Patient[" +
                "ID=" + patientID +
                ", Name=" + name +
                ", Age=" + age +
                ", City=" + city +
                ", Mobile=" + mobile +
                "]";
    }
}