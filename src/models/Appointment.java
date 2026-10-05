package models;

public class Appointment {

    private String appointmentID;
    private Patient patient;
    private Doctor doctor;
    private String timeSlot;
    private String status;

    // Constructor
    public Appointment(String appointmentID,
                       Patient patient,
                       Doctor doctor,
                       String timeSlot) {
        this.appointmentID = appointmentID;
        this.patient = patient;
        this.doctor = doctor;
        this.timeSlot = timeSlot;
        this.status = "BOOKED";
    }

    // Getters
    public String getAppointmentID() {
        return appointmentID;
    }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public String getTimeSlot() { return timeSlot; }
    public String getStatus() { return status; }

    // Setters
    public void setStatus(String status) {
        this.status = status;
    }
    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    @Override
    public String toString() {
        return "Appointment[" +
                "ID=" + appointmentID +
                ", Patient=" + patient.getName() +
                ", Doctor=" + doctor.getName() +
                ", Slot=" + timeSlot +
                ", Status=" + status +
                "]";
    }
}