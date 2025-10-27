package de.tinpa.springbootlab.service;

import de.tinpa.springbootlab.config.NotificationProperties;
import lombok.extern.slf4j.Slf4j;

/**
 * Email implementation of NotificationService
 */
@Slf4j
public class EmailNotificationService implements NotificationService {

    final NotificationProperties properties;

    public EmailNotificationService(NotificationProperties properties) {
        this.properties = properties;
        log.info("EmailNotificationService initialized with host: {}, port: {}",
                properties.getEmail().getHost(),
                properties.getEmail().getPort());
    }

    @Override
    public void sendNotification(String recipient, String message) {
        log.info("Sending EMAIL to {} from {}: {}",
                recipient,
                properties.getEmail().getFrom(),
                message);
        // Actual email sending logic would go here
    }

    @Override
    public String getServiceType() {
        return "EMAIL";
    }
}
