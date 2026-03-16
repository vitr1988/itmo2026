package ru.itmo.spring.lesson8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.itmo.spring.lesson8.dto.EventDto;

import static ru.itmo.spring.lesson8.constant.KafkaConstants.ITMO_PUSH_EVENTS;

@Service
@RequiredArgsConstructor
public class PushService {

    private final KafkaTemplate<String, EventDto> kafkaTemplate;

    public void sendPush(EventDto eventDto) {
        kafkaTemplate.send(ITMO_PUSH_EVENTS, eventDto);
    }
}
