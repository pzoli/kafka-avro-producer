package hu.infokristaly.kafkaproducer;

import hu.infokristaly.kafkaconsumer.avro.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ComponentScan(basePackages = "hu.infokristaly.kafkaproducer")
@ActiveProfiles("test")
class KafkaproducerApplicationTests {

    @Autowired
    private UserMapping userMapping;

    @Test
	void contextLoads() {
        assert userMapping != null;
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Teszt Elek");
        userDTO.setFavoriteColor("piros");
        userDTO.setFavoriteNumber(13);
        User user = userMapping.from(userDTO);
        assert user.getName().equals(userDTO.getName()) : "The name doesn't equal";
        assert user.getFavoriteColor().equals(userDTO.getFavoriteColor()) : "The favourite color doesn't match";
        assert user.getFavoriteNumber() == userDTO.getFavoriteNumber() : "The favourite number doesn't match";
	}

}
