package com.org.developer.demo.core.usecase.business.consumer;

import com.org.developer.demo.core.domain.business.consumer.usecase.GetProcessInstanceHistoryCase;
import com.org.developer.demo.core.domain.business.consumer.usecase.GetProcessInstanceHistoryRequest;
import com.org.developer.demo.core.domain.business.consumer.usecase.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GetProcessInstanceHistoryCaseImpl implements GetProcessInstanceHistoryCase {

    private final RestTemplate restTemplate;


    public GetProcessInstanceHistoryCaseImpl( RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<ProcessInstance> handleList(GetProcessInstanceHistoryRequest request) {
        return restTemplate.getForObject("http://localhost:8080/engine-rest/history/process-instance",List.class);
    }

    @Override
    public ProcessInstance handle(String id) {
        return restTemplate.getForObject("http://localhost:8080/engine-rest/history/process-instance/"+id,ProcessInstance.class);
    }
}
