package hu.infokristaly.kafkaproducer;

import hu.infokristaly.kafkaconsumer.avro.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class MyController {
    
    @Autowired
    private MessageProducer messageProducer;
    @Autowired
    private UserMapping userMapping;

    @PostMapping("/send")
    public String sendMessage(@RequestBody UserDTO userDTO) {
        User user = userMapping.from(userDTO);
        messageProducer.sendMessage(user);
        return "ok";
    }    
}
