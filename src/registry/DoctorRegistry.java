package registry;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import models.Doctor;

public class DoctorRegistry {

    private HashMap<String, Doctor> doctors;

    // Constructor
    public DoctorRegistry() {
        doctors = new HashMap<>();
    }

    // Register a new doctor
    public void registerDoctor(Doctor doctor) {
        if (doctors.containsKey(
                doctor.getDoctorID())) {
            throw new RuntimeException(
                    "Doctor already exists: " +
                            doctor.getDoctorID()
            );
        }
        doctors.put(doctor.getDoctorID(), doctor);
        System.out.println(
                "Doctor registered: " + doctor.getName()
        );
    }

    // Search for a doctor by ID
    public Doctor searchDoctor(String doctorID) {
        if (!doctors.containsKey(doctorID)) {
            throw new RuntimeException(
                    "Doctor not found: " + doctorID
            );
        }
        return doctors.get(doctorID);
    }

    // Search doctors by specialization
    public List<Doctor> searchBySpecialization(
            String specialization) {
        List<Doctor> result = new ArrayList<>();
        for (Doctor d : doctors.values()) {
            if (d.getSpecialization()
                    .equalsIgnoreCase(specialization)) {
                result.add(d);
            }
        }
        if (result.isEmpty()) {
            System.out.println(
                    "No doctors found for: " +
                            specialization
            );
        }
        return result;
    }

    // Update doctor time slots
    public void updateTimeSlots(
            String doctorID,
            List<String> newSlots) {
        Doctor doctor = searchDoctor(doctorID);
        doctor.setAvailableTimeSlots(newSlots);
        System.out.println(
                "Time slots updated for: " + doctorID
        );
    }

    // Remove a doctor
    public void removeDoctor(String doctorID) {
        if (!doctors.containsKey(doctorID)) {
            throw new RuntimeException(
                    "Doctor not found: " + doctorID
            );
        }
        doctors.remove(doctorID);
        System.out.println(
                "Doctor removed: " + doctorID
        );
    }

    // Get all doctors as a list
    public List<Doctor> getAllDoctors() {
        return new ArrayList<>(doctors.values());
    }

    // Display all doctors
    public void displayAll() {
        if (doctors.isEmpty()) {
            System.out.println(
                    "No doctors registered"
            );
            return;
        }
        System.out.println("Registered Doctors:");
        for (Doctor d : doctors.values()) {
            System.out.println(
                    "  " + d +
                            " | Slots: " +
                            d.getAvailableTimeSlots() +
                            " | Fee: Rs." +
                            d.getConsultationFee()
            );
        }
    }

    public int getTotalDoctors() {
        return doctors.size();
    }
}