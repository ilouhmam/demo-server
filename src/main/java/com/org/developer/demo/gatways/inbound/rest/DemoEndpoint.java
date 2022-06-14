package com.org.developer.demo.gatways.inbound.rest;

import com.org.developer.demo.core.domain.business.consumer.usecase.GetProcessInstanceHistoryCase;
import com.org.developer.demo.core.domain.business.consumer.usecase.GetProcessInstanceHistoryRequest;
import com.org.developer.demo.core.domain.business.consumer.usecase.ProcessInstance;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/processes")
public class DemoEndpoint {

    private final GetProcessInstanceHistoryCase getProcessInstanceHistoryCase;

    @GetMapping
    public ResponseEntity<Collection<ProcessInstance>> handleProcessHistory(GetProcessInstanceHistoryRequest request) {
        return ResponseEntity.ok(getProcessInstanceHistoryCase.handleList(request));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProcessInstance> handle(@PathVariable String id) {
        return ResponseEntity.ok(getProcessInstanceHistoryCase.handle(id));
    }
}
