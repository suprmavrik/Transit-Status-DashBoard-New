package org.transitdashboard.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@Profile("local")
public class AutoCreateConfig {

    @Bean
    public NewTopic trainArrivalEvent(){
        return TopicBuilder.name("org.station.arrivals")
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic turnstilesEvent(){
        return TopicBuilder.name("org.station.turnstiles")
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic turnstilesEventConsumer(){
        return TopicBuilder.name("org.station.turnstilesCon")
                .partitions(3)
                .replicas(1)
                .build();
    }
}
