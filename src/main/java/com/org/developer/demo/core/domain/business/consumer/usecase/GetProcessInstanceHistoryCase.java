package com.org.developer.demo.core.domain.business.consumer.usecase;

import java.util.List;

public interface GetProcessInstanceHistoryCase {

    List<ProcessInstance> handleList(GetProcessInstanceHistoryRequest request);
    ProcessInstance handle(String id);

}
