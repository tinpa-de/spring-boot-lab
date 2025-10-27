package de.tinpa.springbootlab.service;

import de.tinpa.springbootlab.config.NotificationProperties;
import lombok.extern.slf4j.Slf4j;

/**
 * SMS implementation of NotificationService
 */
@Slf4j
public class SmsNotificationService implements NotificationService {

    private final NotificationProperties properties;

    public SmsNotificationService(NotificationProperties properties) {
        this.properties = properties;
//        log.info("SmsNotificationService initialized with provider: {}",
//                properties.getSms().getProvider());
    }

    @Override
    public void sendNotification(String recipient, String message) {
//        log.info("Sending SMS to {} via {}: {}",
//                recipient,
//                properties.getSms().getProvider(),
//                message);
//        // Actual SMS sending logic would go here
    }

    @Override
    public String getServiceType() {
        return "SMS";
    }
}