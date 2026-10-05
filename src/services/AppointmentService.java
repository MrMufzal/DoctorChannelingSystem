package services;

import datastructures.AppointmentQueue;
import datastructures.WaitingList;
import datastructures.PatientStack;
import models.Appointment;
import models.Patient;

public class AppointmentService {

    private AppointmentQueue appointmentQueue;
    private WaitingList waitingList;
    private PatientStack appointmentHistory;
    private NotificationService notificationService;

    // Constructor
    public AppointmentService() {
        appointmentQueue = new AppointmentQueue();
        waitingList = new WaitingList();
        appointmentHistory = new PatientStack();
        notificationService = new NotificationService();
    }

    // Book an appointment
    public void bookAppointment(
            Appointment appointment) {
        if (appointmentQueue.isFull()) {
            waitingList.enqueue(appointment);
            notificationService.sendNotification(
                    appointment.getPatient(),
                    "Slots are full. You have been " +
                            "added to the waiting list"
            );
        } else {
            appointmentQueue.enqueue(appointment);
            notificationService.sendNotification(
                    appointment.getPatient(),
                    "Your appointment is confirmed for: " +
                            appointment.getTimeSlot()
            );
        }
    }

    // Cancel an appointment
    public void cancelAppointment(
            Appointment appointment) {
        appointment.setStatus("CANCELLED");
        appointmentHistory.push(appointment);

        notificationService.sendNotification(
                appointment.getPatient(),
                "Your appointment has been cancelled"
        );

        // Assign freed slot to next waiting patient
        if (!waitingList.isEmpty()) {
            Appointment next = waitingList.dequeue();
            appointmentQueue.enqueue(next);
            notificationService.sendNotification(
                    next.getPatient(),
                    "Good news! A slot is now available. " +
                            "Your appointment is confirmed for: " +
                            next.getTimeSlot()
            );
        }
    }

    // Reschedule — moves patient back to waiting list
    public void rescheduleAppointment(
            Appointment appointment) {
        appointment.setStatus("RESCHEDULED");
        waitingList.enqueue(appointment);
        notificationService.sendNotification(
                appointment.getPatient(),
                "Your reschedule request has been received." +
                        " You are now in the waiting list"
        );
    }

    // Display all current appointments
    public void displayAllAppointments() {
        appointmentQueue.displayAll();
    }

    // Display waiting list
    public void displayWaitingList() {
        waitingList.displayWaitingList();
    }

    // Display appointment history
    public void displayHistory() {
        appointmentHistory.displayHistory();
    }
}