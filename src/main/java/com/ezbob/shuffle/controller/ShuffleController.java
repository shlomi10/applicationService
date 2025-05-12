package com.ezbob.shuffle.controller;

import io.qameta.allure.Step;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/shuffle")
public class ShuffleController {

    @Value("${log.service.url}")
    private String logServiceUrl;

    private final RestTemplate restTemplate;

    public ShuffleController(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @PostMapping
    @Severity(SeverityLevel.NORMAL)
    @Description("Generates a shuffled array of integers from 1 to the given number and logs the request.")
    public ResponseEntity<List<Integer>> shuffle(@RequestBody InputNumber payload) {
        int number = payload.getNumber();
        List<Integer> result = shuffleNumbers(number);
        logAsync(payload.getNumber());
        return ResponseEntity.ok(result);
    }

    @Step("Shuffling numbers from 1 to {n}")
    private List<Integer> shuffleNumbers(int n) {
        List<Integer> list = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
        Collections.shuffle(list);
        return list;
    }

    @Step("Sending log request to service-log")
    private void logAsync(int number) {
        CompletableFuture.runAsync(() -> {
            try {
                restTemplate.postForEntity(logServiceUrl + "/log", number, Void.class);
            } catch (Exception ignored) {}
        });
    }
}
