package home.learn.sb.kafka.service;

import home.learn.sb.kafka.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafKaProducerService {

    private final String _TOPICNAME = "my-first-topic";
    private final String USER_TOPIC = "user-detail-topic";

    /*
     * 'KafkaTemplate' is used to publish message into 'Kafka Topic'
     * We must specify the 'type' of 'Key' and 'Message'
     */
    @Autowired
    @Qualifier("kafkaTemplate")
    private KafkaTemplate<String, String> kafkaTemplate;

    /*
     * 'KafkaTemplate' to publish 'UserDetails' POJO as JSON
     */
    @Autowired
    @Qualifier("usersKafkaTemplate")
    private KafkaTemplate<String, UserDetails> usersKafkaTemplate;

    public boolean sendMessage(String message) {
        // We must specify the 'Topic' name to write the 'Message'
        this.kafkaTemplate.send(_TOPICNAME, message);

        return true;
    }

    public boolean publishUserDetails(UserDetails user) {
        this.usersKafkaTemplate.send(USER_TOPIC, user);

        return true;
    }
}
