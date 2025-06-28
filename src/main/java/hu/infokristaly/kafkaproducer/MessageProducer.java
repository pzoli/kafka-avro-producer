package hu.infokristaly.kafkaproducer;

import java.time.Instant;

import hu.infokristaly.kafkaconsumer.avro.User;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
   	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	public void sendMessage(User msg) {
    	//kafkaTemplate.send("test",0, Instant.now().toEpochMilli(),"0", msg);
        ProducerRecord<String, User> producerRecord = new ProducerRecord<String, User>(
                "avro-test", msg
        );

        kafkaTemplate.send(producerRecord);
	}

}
