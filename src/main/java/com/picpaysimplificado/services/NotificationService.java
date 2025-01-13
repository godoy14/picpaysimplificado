package com.picpaysimplificado.services;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.dtos.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {
    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception {
        String email = user.getEmail();

        NotificationDTO notificationRequest = new NotificationDTO(email, message);

        ResponseEntity<String> notificationResponse = this.restTemplate.postForEntity("https://util.devi.tools/api/v1/notify", notificationRequest, String.class);

        boolean isNotified = notificationResponse.getStatusCode().is2xxSuccessful();

        if(!isNotified) {
            System.out.println("Serviço de notificação está fora do ar");
            throw new Exception("Serviço de notificação está fora do ar");
        }

    }
}
