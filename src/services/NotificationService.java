package services;

import java.util.LinkedList;
import models.Patient;

public class NotificationService {

    private LinkedList<String> notificationQueue;

    // Constructor
    public NotificationService() {
        notificationQueue = new LinkedList<>();
    }

    public void sendNotification(Patient patient,
                                 String message) {
        String notification =
                "SMS to " + patient.getMobile() +
                        " (" + patient.getName() + "): " + message;
        notificationQueue.add(notification);
        processNotifications();
    }

    private void processNotifications() {
        while (!notificationQueue.isEmpty()) {
            System.out.println(
                    "[NOTIFICATION] " +
                            notificationQueue.poll()
            );
        }
    }
}
