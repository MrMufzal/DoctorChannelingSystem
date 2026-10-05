package registry;
import java.util.HashMap;
import java.util.ArrayList;
import models.Patient;

public class PatientRegistry {

    private HashMap<String, Patient> patients;

    public PatientRegistry() {
        patients = new HashMap<>();
    }

    // Register a new patient
    public void registerPatient(Patient patient) {
        if (patients.containsKey(patient.getPatientID())) {
            throw new RuntimeException(
                    "Patient already exists: " +
                            patient.getPatientID()
            );
        }
        patients.put(patient.getPatientID(), patient);
        System.out.println("Patient registered: " +
                patient.getName());
    }

    // Search for a patient
    public Patient searchPatient(String patientID) {
        if (!patients.containsKey(patientID)) {
            throw new RuntimeException(
                    "Patient not found: " + patientID
            );
        }
        return patients.get(patientID);
    }

    // Update patient details
    public void updatePatient(String patientID,
                              String mobile,
                              String email) {
        Patient patient = searchPatient(patientID);
        patient.setMobile(mobile);
        patient.setEmail(email);
        System.out.println("Patient updated: " + patientID);
    }

    // Remove a patient
    public void removePatient(String patientID) {
        if (!patients.containsKey(patientID)) {
            throw new RuntimeException(
                    "Patient not found: " + patientID
            );
        }
        patients.remove(patientID);
        System.out.println("Patient removed: " + patientID);
    }

    // Display all patients
    public void displayAll() {
        if (patients.isEmpty()) {
            System.out.println("No patients registered");
            return;
        }
        System.out.println("Registered Patients:");
        for (Patient p : patients.values()) {
            System.out.println(p);
        }
    }

    public int getTotalPatients() {
        return patients.size();
    }
}
