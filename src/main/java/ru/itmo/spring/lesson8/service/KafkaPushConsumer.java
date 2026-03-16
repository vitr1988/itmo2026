package ru.itmo.spring.lesson8.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.itmo.spring.lesson8.dto.EventDto;

import static ru.itmo.spring.lesson8.constant.KafkaConstants.ITMO_PUSH_EVENTS;

@Slf4j
@Service
public class KafkaPushConsumer {

    @KafkaListener(topics = ITMO_PUSH_EVENTS)
    public void handlePushEvents(EventDto eventDto) {
        log.info("Consume message {}", eventDto);
    }
}
