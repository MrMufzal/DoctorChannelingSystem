package datastructures;

import java.util.LinkedList;
import models.Patient;
import models.Appointment;

public class WaitingList implements Queue<Appointment> {

    private LinkedList<Appointment> waitingList;

    // Constructor
    public WaitingList() {
        waitingList = new LinkedList<>();
    }

    @Override
    public void enqueue(Appointment appointment) {
        waitingList.addLast(appointment);
        System.out.println(
                appointment.getPatient().getName() +
                        " added to waiting list. Position: " +
                        waitingList.size()
        );
    }

    @Override
    public Appointment dequeue() {
        if (isEmpty()) {
            throw new RuntimeException(
                    "Waiting list is empty"
            );
        }
        Appointment next = waitingList.removeFirst();
        System.out.println(
                next.getPatient().getName() +
                        " moved from waiting list to " +
                        "appointment queue"
        );
        return next;
    }

    @Override
    public Appointment peek() {
        if (isEmpty()) {
            throw new RuntimeException(
                    "Waiting list is empty"
            );
        }
        return waitingList.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return waitingList.isEmpty();
    }

    @Override
    public int size() {
        return waitingList.size();
    }

    public void displayWaitingList() {
        if (isEmpty()) {
            System.out.println("Waiting list is empty");
            return;
        }
        System.out.println("Current Waiting List:");
        int position = 1;
        for (Appointment a : waitingList) {
            System.out.println(
                    "  " + position++ + ". " +
                            a.getPatient().getName() +
                            " (Age: " + a.getPatient().getAge() +
                            ") — Slot: " + a.getTimeSlot()
            );
        }
    }
}