package com.teja.kafkaui.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class KafkaServer {

    @Id
    private String id;
    private String kafkaServers;//comma separated servers list

}
