package com.teja.kafkaui.repo;

import com.teja.kafkaui.models.KafkaServer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerRepo extends MongoRepository<KafkaServer,String> {

}
