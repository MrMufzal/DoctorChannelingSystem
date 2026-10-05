package datastructures;

import java.util.Stack;
import models.Appointment;

public class PatientStack {

    private Stack<Appointment> stack;

    // Constructor
    public PatientStack() {
        stack = new Stack<>();
    }

    // Push — save appointment to history
    public void push(Appointment appointment) {
        stack.push(appointment);
        System.out.println(
                "Appointment saved to history: " +
                        appointment.getAppointmentID()
        );
    }

    // Pop — retrieve and remove most recent
    public Appointment pop() {
        if (isEmpty()) {
            throw new RuntimeException(
                    "No appointment history found"
            );
        }
        return stack.pop();
    }

    // Peek — view most recent without removing
    public Appointment peek() {
        if (isEmpty()) {
            throw new RuntimeException(
                    "No appointment history found"
            );
        }
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public void displayHistory() {
        if (isEmpty()) {
            System.out.println(
                    "No appointment history"
            );
            return;
        }
        System.out.println(
                "Appointment History (Most Recent First):"
        );

        // Temporary stack to preserve order
        Stack<Appointment> temp = new Stack<>();

        while (!stack.isEmpty()) {
            Appointment a = stack.pop();
            System.out.println("  " + a);
            temp.push(a);
        }

        // Restore original stack
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }
}