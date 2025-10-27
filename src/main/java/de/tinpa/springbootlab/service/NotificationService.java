package de.tinpa.springbootlab.service;

/**
 * Interface for notification services
 */
public interface NotificationService {
    void sendNotification(String recipient, String message);
    String getServiceType();
}