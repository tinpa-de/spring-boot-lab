package de.tinpa.springbootlab.config;

import de.tinpa.springbootlab.service.EmailNotificationService;
import de.tinpa.springbootlab.service.NotificationService;
import de.tinpa.springbootlab.service.SmsNotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Custom AutoConfiguration for Notification Service
 */
@Configuration
public class CustomAutoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(CustomAutoConfiguration.class);

    public CustomAutoConfiguration() {
        log.info("CustomAutoConfiguration loaded");
    }

    /**
     * Creates EmailNotificationService bean when type is 'email'
     */
    @Bean
    public NotificationService emailNotificationService(NotificationProperties properties) {
        log.info("Creating EmailNotificationService bean");
        return new EmailNotificationService(properties);
    }

    /**
     * Creates SmsNotificationService bean when type is 'sms'
     */
    //@Bean
    public NotificationService smsNotificationService(NotificationProperties properties) {
        log.info("Creating SmsNotificationService bean");
        return new SmsNotificationService(properties);
    }
}
