package ru.itmo.spring.lesson8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.spring.lesson8.dto.EventDto;
import ru.itmo.spring.lesson8.service.PushService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pushes")
public class PushController {

    private final PushService pushService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void sendPush(@RequestBody EventDto eventDto) {
        pushService.sendPush(eventDto);
    }
}
