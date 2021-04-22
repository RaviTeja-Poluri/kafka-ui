package com.teja.kafkaui.repo;

import com.teja.kafkaui.models.KafkaTopic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepo extends MongoRepository<KafkaTopic,String> {

}
