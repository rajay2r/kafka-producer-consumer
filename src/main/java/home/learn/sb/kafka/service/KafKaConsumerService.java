package home.learn.sb.kafka.service;

import home.learn.sb.kafka.model.UserDetails;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafKaConsumerService {

    private final String _TOPICNAME = "my-first-topic";
    private final String USER_TOPIC = "user-detail-topic";

    @KafkaListener(topics = {_TOPICNAME}, groupId = "group-id-1")
    public void listener1(String message) {
        System.out.println("Message Received :"+message);
    }

    @KafkaListener(topics = {USER_TOPIC}, groupId = "group_json",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(UserDetails user) {
        System.out.println("Consumed JSON Message: " + user);
    }
}
