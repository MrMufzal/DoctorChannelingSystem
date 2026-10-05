package models;

import java.util.List;
import java.util.ArrayList;

public class Doctor {

    private String doctorID;
    private String name;
    private String specialization;
    private List<String> availableTimeSlots;
    private double consultationFee;

    // Constructor
    public Doctor(String doctorID, String name,
                  String specialization,
                  List<String> availableTimeSlots,
                  double consultationFee) {
        this.doctorID = doctorID;
        this.name = name;
        this.specialization = specialization;
        this.availableTimeSlots = availableTimeSlots;
        this.consultationFee = consultationFee;
    }

    // Getters
    public String getDoctorID() { return doctorID; }
    public String getName() { return name; }
    public String getSpecialization() {
        return specialization;
    }
    public List<String> getAvailableTimeSlots() {
        return availableTimeSlots;
    }
    public double getConsultationFee() {
        return consultationFee;
    }

    // Setters
    public void setAvailableTimeSlots(
            List<String> availableTimeSlots) {
        this.availableTimeSlots = availableTimeSlots;
    }
    public void setConsultationFee(
            double consultationFee) {
        this.consultationFee = consultationFee;
    }

    @Override
    public String toString() {
        return "Doctor[" +
                "ID=" + doctorID +
                ", Name=" + name +
                ", Specialization=" + specialization +
                ", Fee=Rs." + consultationFee +
                "]";
    }
}
