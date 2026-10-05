package datastructures;

import java.util.LinkedList;
import models.Appointment;

public class AppointmentQueue implements Queue<Appointment> {

    private LinkedList<Appointment> queue;
    private static final int MAX_CAPACITY = 10;

    // Constructor
    public AppointmentQueue() {
        queue = new LinkedList<>();
    }

    @Override
    public void enqueue(Appointment appointment) {
        if (isFull()) {
            throw new RuntimeException(
                    "Appointment queue is full"
            );
        }
        queue.addLast(appointment);
        System.out.println(
                "Appointment booked for: " +
                        appointment.getPatient().getName()
        );
    }

    @Override
    public Appointment dequeue() {
        if (isEmpty()) {
            throw new RuntimeException(
                    "No appointments in queue"
            );
        }
        return queue.removeFirst();
    }

    @Override
    public Appointment peek() {
        if (isEmpty()) {
            throw new RuntimeException(
                    "No appointments in queue"
            );
        }
        return queue.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }

    public boolean isFull() {
        return queue.size() >= MAX_CAPACITY;
    }

    public void displayAll() {
        if (isEmpty()) {
            System.out.println(
                    "No appointments scheduled"
            );
            return;
        }
        System.out.println("Current Appointments:");
        for (Appointment a : queue) {
            System.out.println("  " + a);
        }
    }
}