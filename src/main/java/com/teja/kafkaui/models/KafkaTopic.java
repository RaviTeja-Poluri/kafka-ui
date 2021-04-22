package com.teja.kafkaui.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "topics")
public class KafkaTopic {

    @Id
    private String topicId;
    private String kafkaServerId;
    private String topic;
}
