package com.teja.kafkaui.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TopicMeta {

    private long partitions;
    private String extra;

}
