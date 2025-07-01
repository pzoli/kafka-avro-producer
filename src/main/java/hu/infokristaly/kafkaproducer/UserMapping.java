package hu.infokristaly.kafkaproducer;

import hu.infokristaly.kafkaconsumer.avro.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface UserMapping {
    @Mapping(target = "name", source = "name")
    @Mapping(target = "favoriteNumber", source = "favoriteNumber")
    @Mapping(target = "favoriteColor", source = "favoriteColor")
    User from(UserDTO userDTO);
}
