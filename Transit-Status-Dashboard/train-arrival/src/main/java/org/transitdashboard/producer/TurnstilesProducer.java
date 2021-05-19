package org.transitdashboard.producer;


import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Printed;
import org.springframework.stereotype.Component;
import org.transitdashboard.domain.Turnstiles;
import org.transitdashboard.domain.TurnstilesEvent;

import javax.validation.constraints.NotBlank;

@Component
@Slf4j
public class TurnstilesProducer {

    String topic = "org.station.turnstiles";

    String targetTopic = "org.station.turnstilesCon";

    public void processTurnstilesEvent(TurnstilesEvent turnstilesEvent) {

        StreamsBuilder streamsBuilder = new StreamsBuilder();
        KStream<Integer, Turnstiles> kStream = streamsBuilder.stream(topic);

        KTable<String, Long> kTable = kStream
                .groupBy((k, v) -> v.getStation_name())
                .count();

        //kTable.toStream().print(Printed.<String,Long>toSysOut().withLabel("Turnstiles"));

        kTable.toStream().to(targetTopic);

    }
}
