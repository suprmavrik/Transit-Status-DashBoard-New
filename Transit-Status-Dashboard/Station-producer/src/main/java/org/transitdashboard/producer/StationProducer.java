package org.transitdashboard.producer;


import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Properties;

@Slf4j
public class StationProducer {
    public static void main(String[] args)  {

        Properties props = new Properties();
        props.put(ProducerConfig.CLIENT_ID_CONFIG,"my-app-readcsv");
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);


        log.info("Producer has been created...Start sending Student Record ");

        KafkaProducer<String,student> producer = new KafkaProducer<String,student>(props);

        ReadCSV readCSV = new ReadCSV();
        List studentList = readCSV.ReadCSVFile(); //It will return the student list
        for (Object studentObject : studentList) {
            student stdobject = (student) studentObject;
            producer.send(new ProducerRecord<String, student>("student",stdobject.getDept(),stdobject));
        }
        log.info("Producer has sent all employee records successfully...");
        producer.close();
    }
}
