package hu.infokristaly.kafkaproducer;

import hu.infokristaly.kafkaconsumer.avro.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class MyController {
    
    @Autowired
    private MessageProducer messageProducer;
    
    @GetMapping("/send")
    public String sendMessage(@RequestParam(name = "msg") User msg) {
        messageProducer.sendMessage(msg);
        return "ok";
    }    
}
