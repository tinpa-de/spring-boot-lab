package de.tinpa.springbootlab.config;

import de.tinpa.springbootlab.service.EmailNotificationService;
import de.tinpa.springbootlab.service.NotificationService;
import de.tinpa.springbootlab.service.SmsNotificationService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Custom AutoConfiguration for Notification Service
 */
@Configuration
@Slf4j
public class CustomAutoConfiguration {
    public CustomAutoConfiguration() {
        log.info("CustomAutoConfiguration loaded");
    }

    @PostConstruct
    public void init() {
        log.info("CustomAutoConfiguration initialized");
    }

    @PreDestroy
    public void destroy() {
        log.info("CustomAutoConfiguration destroyed");
    }

    /**
     * Creates EmailNotificationService bean when type is 'email'
     */
    @Bean
    @ConditionalOnProperty(prefix = "app.notification", name = "type", havingValue = "email", matchIfMissing = true)
    @ConditionalOnMissingBean(NotificationService.class)
    public NotificationService emailNotificationService(NotificationProperties properties) {
        log.info("Creating EmailNotificationService bean");
        return new EmailNotificationService(properties);
    }

    /**
     * Creates SmsNotificationService bean when type is 'sms'
     */
    @Bean
    @ConditionalOnProperty(prefix = "app.notification", name = "type", havingValue = "sms")
    @ConditionalOnMissingBean(NotificationService.class)
    public NotificationService smsNotificationService(NotificationProperties properties) {
        log.info("Creating SmsNotificationService bean");
        return new SmsNotificationService(properties);
    }
}
