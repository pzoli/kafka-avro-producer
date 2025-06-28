package hu.infokristaly.kafkaproducer;
import java.util.HashMap;
import java.util.Map;

import hu.infokristaly.kafkaconsumer.avro.User;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Value("${spring.kafka.properties.sasl.jaas.config}")
    private String KAFKA_JAAS_CONFIG;

    @Bean
    public ProducerFactory<String, User> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        
        configProps.put(
          ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, 
          bootstrapAddress);
        configProps.put(
          ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, 
          StringSerializer.class);
        configProps.put(
          ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                KafkaAvroSerializer.class);
        configProps.put(
            ProducerConfig.PARTITIONER_CLASS_CONFIG,
            "org.apache.kafka.clients.producer.internals.DefaultPartitioner");
        configProps.put(
          SaslConfigs.SASL_MECHANISM,"PLAIN");
        configProps.put(
          CommonClientConfigs.SECURITY_PROTOCOL_CONFIG,
          "SASL_PLAINTEXT");
        configProps.put(
          SaslConfigs.SASL_JAAS_CONFIG,
          KAFKA_JAAS_CONFIG);
        configProps.put(
                "schema.registry.url", "http://schema-registry-headless.kafka.svc.cluster.local:8081");
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, User> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}