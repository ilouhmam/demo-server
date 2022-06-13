package com.org.developer.demo.core.domain.business.consumer.usecase;

import java.util.List;

@FunctionalInterface
public interface GetProcessInstanceHistoryCase {

    List<ProcessInstance> handle(GetProcessInstanceHistoryRequest request);

}
