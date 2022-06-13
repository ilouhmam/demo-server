package com.org.developer.demo.gatways.inbound.rest;

import com.org.developer.demo.core.domain.business.consumer.usecase.GetProcessInstanceHistoryCase;
import com.org.developer.demo.core.domain.business.consumer.usecase.GetProcessInstanceHistoryRequest;
import com.org.developer.demo.core.domain.business.consumer.usecase.ProcessInstance;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@AllArgsConstructor
public class DemoEndpoint {

    private final GetProcessInstanceHistoryCase getProcessInstanceHistoryCase;

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/history-process-instance")
    public ResponseEntity<Collection<ProcessInstance>> handleProcessHistory(GetProcessInstanceHistoryRequest request) {
        return ResponseEntity.ok(getProcessInstanceHistoryCase.handle(request));
    }
}
