package home.learn.sb.kafka.controller;

import home.learn.sb.kafka.model.UserDetails;
import home.learn.sb.kafka.service.KafKaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {

    @Autowired
    KafKaProducerService producerService;

    @GetMapping("/publish/{message}")
    public String publishMessage(@PathVariable(name = "message") String message) {
        producerService.sendMessage(message);

        return "Message Published!";
    }

    @GetMapping("/publish/users")
    public String publishUser(@RequestParam("name") String name, @RequestParam("tech") String tech) {
        UserDetails user = new UserDetails(name, tech);
        producerService.publishUserDetails(user);

        return "User published: " + user.toString();
    }
}
