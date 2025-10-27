package de.tinpa.springbootlab.core;

import de.tinpa.springbootlab.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
@ConditionalOnBean(NotificationService.class)
public class DemoController {
    private final NotificationService notificationService;

    @Autowired
    public DemoController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/notify")
    public ResponseEntity<Map<String, String>> sendNotification(
            @RequestParam String recipient,
            @RequestParam String message) {

        notificationService.sendNotification(recipient, message);

        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("serviceType", notificationService.getServiceType());
        response.put("recipient", recipient);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Map<String, String>> getConfigInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("serviceType", notificationService.getServiceType());
        info.put("status", "configured");

        return ResponseEntity.ok(info);
    }
}
