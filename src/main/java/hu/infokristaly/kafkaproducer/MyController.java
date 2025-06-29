package hu.infokristaly.kafkaproducer;

import hu.infokristaly.kafkaconsumer.avro.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class MyController {
    
    @Autowired
    private MessageProducer messageProducer;
    
    @PostMapping("/send")
    public String sendMessage(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setFavoriteColor(userDTO.getFavorite_color());
        user.setFavoriteNumber(userDTO.getFavorite_number());
        messageProducer.sendMessage(user);
        return "ok";
    }    
}
