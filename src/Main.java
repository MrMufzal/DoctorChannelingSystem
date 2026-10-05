import models.Patient;
import models.Doctor;
import models.Appointment;
import registry.PatientRegistry;
import registry.DoctorRegistry;
import services.AppointmentService;
import services.SortingService;
import services.RoutingService;
import datastructures.WaitingList;
import datastructures.PatientStack;
import datastructures.PatientRecordStack;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("════════════════════════════════");
        System.out.println("   Doctor Channelling System    ");
        System.out.println("════════════════════════════════\n");

        // ── Setup ─────────────────────────────────────────
        PatientRegistry patientRegistry =
                new PatientRegistry();
        DoctorRegistry doctorRegistry =
                new DoctorRegistry();
        AppointmentService appointmentService =
                new AppointmentService();
        SortingService sortingService =
                new SortingService();

        // ── Register Patients ──────────────────────────────
        System.out.println("── Registering Patients ──");
        Patient p1 = new Patient(
                "P001", "Ali",
                "0771234567", "ali@email.com",
                "Colombo", 45, "Diabetes"
        );
        Patient p2 = new Patient(
                "P002", "Sara",
                "0777654321", "sara@email.com",
                "Kandy", 23, "None"
        );
        Patient p3 = new Patient(
                "P003", "John",
                "0779876543", "john@email.com",
                "Galle", 67, "Hypertension"
        );
        Patient p4 = new Patient(
                "P004", "Emma",
                "0771122334", "emma@email.com",
                "Colombo", 31, "Asthma"
        );
        Patient p5 = new Patient(
                "P005", "Raj",
                "0775566778", "raj@email.com",
                "Kandy", 19, "None"
        );

        patientRegistry.registerPatient(p1);
        patientRegistry.registerPatient(p2);
        patientRegistry.registerPatient(p3);
        patientRegistry.registerPatient(p4);
        patientRegistry.registerPatient(p5);

        System.out.println();
        patientRegistry.displayAll();

        // ── Register Doctors ───────────────────────────────
        System.out.println("\n── Registering Doctors ──");
        List<String> slotsD1 = Arrays.asList(
                "9:00AM", "10:00AM", "11:00AM"
        );
        List<String> slotsD2 = Arrays.asList(
                "1:00PM", "2:00PM", "3:00PM"
        );

        Doctor d1 = new Doctor(
                "D001", "Dr. Smith",
                "Cardiology", slotsD1, 2000.00
        );
        Doctor d2 = new Doctor(
                "D002", "Dr. Perera",
                "Neurology", slotsD2, 2500.00
        );

        doctorRegistry.registerDoctor(d1);
        doctorRegistry.registerDoctor(d2);

        System.out.println();
        doctorRegistry.displayAll();

        // ── Search Doctor by Specialization ───────────────
        System.out.println(
                "\n── Search: Cardiology Doctors ──"
        );
        List<Doctor> cardiologists =
                doctorRegistry.searchBySpecialization(
                        "Cardiology"
                );
        cardiologists.forEach(System.out::println);

        // ── Book Appointments ──────────────────────────────
        System.out.println(
                "\n── Booking Appointments ──"
        );
        Appointment a1 = new Appointment(
                "A001", p1, d1, "9:00AM"
        );
        Appointment a2 = new Appointment(
                "A002", p2, d1, "10:00AM"
        );
        Appointment a3 = new Appointment(
                "A003", p3, d1, "11:00AM"
        );
        Appointment a4 = new Appointment(
                "A004", p4, d1, "9:00AM"
        );

        appointmentService.bookAppointment(a1);
        appointmentService.bookAppointment(a2);
        appointmentService.bookAppointment(a3);
        appointmentService.bookAppointment(a4);

        // ── Display All Appointments ───────────────────────
        System.out.println(
                "\n── All Scheduled Appointments ──"
        );
        appointmentService.displayAllAppointments();

        // ── Display Waiting List ───────────────────────────
        System.out.println(
                "\n── Current Waiting List ──"
        );
        appointmentService.displayWaitingList();

        // ── Cancel Appointment ─────────────────────────────
        System.out.println(
                "\n── Cancelling Appointment A001 ──"
        );
        appointmentService.cancelAppointment(a1);

        // ── Display Updated Appointments ───────────────────
        System.out.println(
                "\n── Updated Appointments ──"
        );
        appointmentService.displayAllAppointments();

        // ── Reschedule Appointment ─────────────────────────
        System.out.println(
                "\n── Rescheduling Appointment A002 ──"
        );
        appointmentService.rescheduleAppointment(a2);

        // ── Display Updated Waiting List ───────────────────
        System.out.println(
                "\n── Updated Waiting List ──"
        );
        appointmentService.displayWaitingList();

        // ── Display Appointment History ────────────────────
        System.out.println(
                "\n── Appointment History ──"
        );
        appointmentService.displayHistory();

        // ── Sort Patients by Age (Quick Sort) ─────────────
        System.out.println(
                "\n── Sorting Patients by Age ──"
        );
        List<Patient> allPatients = Arrays.asList(
                p1, p2, p3, p4, p5
        );
        List<Patient> sortedPatients =
                sortingService.quickSort(allPatients);
        sortingService.displaySorted(sortedPatients);

        // ── Home Visit Route Planning ──────────────────────
        System.out.println(
                "\n── Home Visit Route Planning ──"
        );
        String[] locations = {
                "Hospital", "A", "B", "C", "D", "E"
        };

        RoutingService routing =
                new RoutingService(6, locations);

        // Add edges based on your graph
        routing.addEdge(0, 1, 6);  // Hospital → A
        routing.addEdge(0, 2, 8);  // Hospital → B
        routing.addEdge(0, 3, 4);  // Hospital → C
        routing.addEdge(1, 2, 3);  // A → B
        routing.addEdge(1, 4, 7);  // A → E
        routing.addEdge(2, 3, 4);  // B → C
        routing.addEdge(2, 4, 1);  // B → E
        routing.addEdge(2, 5, 2);  // B → D
        routing.addEdge(3, 5, 9);  // C → D
        routing.addEdge(4, 5, 5);  // E → D

        routing.floydWarshall();
        // ── Error Handling Test Cases ──────────────────────
        System.out.println(
                "\n════════════════════════════════"
        );
        System.out.println("        Error Handling Tests        ");
        System.out.println(
                "════════════════════════════════\n"
        );

// TC002 — Duplicate patient
        try {
            System.out.println("TC002: Duplicate Patient");
            patientRegistry.registerPatient(p1);
        } catch (RuntimeException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

// TC003 — Patient not found
        try {
            System.out.println(
                    "\nTC003: Patient Not Found"
            );
            patientRegistry.searchPatient("P999");
        } catch (RuntimeException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

// TC005 — Duplicate doctor
        try {
            System.out.println(
                    "\nTC005: Duplicate Doctor"
            );
            doctorRegistry.registerDoctor(d1);
        } catch (RuntimeException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

// TC011 — Empty waiting list
        try {
            System.out.println(
                    "\nTC011: Empty Waiting List"
            );
            WaitingList emptyList = new WaitingList();
            emptyList.dequeue();
        } catch (RuntimeException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

// TC012 — Empty stack
        try {
            System.out.println(
                    "\nTC012: Empty History Stack"
            );
            PatientStack emptyStack = new PatientStack();
            emptyStack.pop();
        } catch (RuntimeException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        // ── Activity 3 — Patient Record Stack ─────────────────
        System.out.println(
                "\n════════════════════════════════"
        );
        System.out.println(
                "   Activity 3 — Patient Record Stack   "
        );
        System.out.println(
                "════════════════════════════════\n"
        );

// Create the stack
        PatientRecordStack recordStack =
                new PatientRecordStack();

// Push patients in registration order
// oldest first just like the system stores them
        System.out.println("── Registering patients to stack ──");
        recordStack.push(p1); // Ali — registered first (oldest)
        recordStack.push(p2); // Sara
        recordStack.push(p3); // John
        recordStack.push(p4); // Emma
        recordStack.push(p5); // Raj — registered last (newest)

// Display all records newest to oldest
        System.out.println(
                "\n── Displaying all records ──"
        );
        recordStack.displayAll();

// Peek at most recent without removing
        System.out.println(
                "── Peek at most recent record ──"
        );
        Patient topPatient = recordStack.peek();
        System.out.println(
                "Most recent patient: " + topPatient.getName()
        );

// Retrieve newest to oldest one by one
        System.out.println(
                "\n── Retrieving records newest to oldest ──"
        );
        while (!recordStack.isEmpty()) {
            Patient retrieved = recordStack.pop();
            System.out.println(
                    "Retrieved: " + retrieved.getName() +
                            " (Age: " + retrieved.getAge() + ")"
            );
        }

// Error handling — pop from empty stack
        System.out.println(
                "\n── Error Test: Pop from empty stack ──"
        );
        try {
            recordStack.pop();
        } catch (RuntimeException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

// Error handling — push duplicate patient
        System.out.println(
                "\n── Error Test: Push duplicate patient ──"
        );
        recordStack.push(p1); // push Ali first
        try {
            recordStack.push(p1); // push Ali again
        } catch (RuntimeException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
