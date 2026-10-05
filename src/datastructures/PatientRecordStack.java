package datastructures;

import java.util.Stack;
import models.Patient;

public class PatientRecordStack {

    private Stack<Patient> stack;

    // ── Constructor ───────────────────────────────────────
    public PatientRecordStack() {
        stack = new Stack<>();
        System.out.println(
                "Patient Record Stack created successfully"
        );
    }

    // ── Push: add patient record to top ──────────────────
    public void push(Patient patient) {
        // Precondition check — patient must be valid
        if (patient == null) {
            throw new RuntimeException(
                    "Cannot push null patient record"
            );
        }
        // Precondition check — no duplicates
        if (contains(patient.getPatientID())) {
            throw new RuntimeException(
                    "Patient already exists in stack: " +
                            patient.getPatientID()
            );
        }
        stack.push(patient);
        System.out.println(
                "Patient record added: " +
                        patient.getName() +
                        " (Total records: " + stack.size() + ")"
        );
    }

    // ── Pop: retrieve and remove newest record ───────────
    public Patient pop() {
        // Precondition check — stack must not be empty
        if (isEmpty()) {
            throw new RuntimeException(
                    "Cannot retrieve record — " +
                            "no patient records exist"
            );
        }
        Patient retrieved = stack.pop();
        System.out.println(
                "Retrieved record: " +
                        retrieved.getName() +
                        " (Remaining records: " + stack.size() + ")"
        );
        return retrieved;
    }

    // ── Peek: view newest record without removing ────────
    public Patient peek() {
        // Precondition check — stack must not be empty
        if (isEmpty()) {
            throw new RuntimeException(
                    "Cannot peek — " +
                            "no patient records exist"
            );
        }
        return stack.peek();
    }

    // ── isEmpty:  check if stack has no records ───────────
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // ── size: return total number of records ─────────────
    public int size() {
        return stack.size();
    }

    // ── contains — check if patient already exists ────────
    public boolean contains(String patientID) {
        for (Patient p : stack) {
            if (p.getPatientID().equals(patientID)) {
                return true;
            }
        }
        return false;
    }

    // ── displayAll: show all records newest to oldest ────
    public void displayAll() {
        if (isEmpty()) {
            System.out.println(
                    "No patient records in stack"
            );
            return;
        }

        System.out.println(
                "\n════════════════════════════════"
        );
        System.out.println(
                "  Patient Records (Newest to Oldest)"
        );
        System.out.println(
                "════════════════════════════════"
        );

        // Use temp stack to preserve original
        Stack<Patient> temp = new Stack<>();
        int position = 1;

        // Pop from original — print — push to temp
        while (!stack.isEmpty()) {
            Patient p = stack.pop();
            System.out.println(
                    position++ + ". " +
                            "ID: "      + p.getPatientID() +
                            " | Name: " + p.getName() +
                            " | Age: "  + p.getAge() +
                            " | City: " + p.getCity() +
                            " | History: " + p.getMedicalHistory()
            );
            temp.push(p);
        }

        // Restore original stack from temp
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        System.out.println(
                "════════════════════════════════\n"
        );
    }

    // ── displayTop — show only the most recent record ─────
    public void displayTop() {
        if (isEmpty()) {
            System.out.println(
                    "No patient records in stack"
            );
            return;
        }
        Patient top = stack.peek();
        System.out.println(
                "Most Recent Record: " +
                        "ID: "      + top.getPatientID() +
                        " | Name: " + top.getName() +
                        " | Age: "  + top.getAge()
        );
    }
}