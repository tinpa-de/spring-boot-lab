package de.tinpa.springbootlab.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.notification")
@Data
public class NotificationProperties {
    /**
     * Type of notification service to use (email, sms)
     */
    private String type = "email";

    /**
     * Enable or disable notifications
     */
    private boolean enabled = true;


    @Data
    public static final class Email {
        String host;
        String port;
        String from;
    }

    /**
     * Email specific configuration
     */
    Email email;
}
