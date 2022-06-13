package com.org.developer.demo.core.domain.business.consumer.usecase;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ProcessInstance {

    private String id;
    private Object businessKey;
    private String processDefinitionId;
    private String processDefinitionKey;
    private String processDefinitionName;
    private Integer processDefinitionVersion;
    private Date startTime;
    private Object endTime;
    private Object removalTime;
    private Object durationInMillis;
    private Object startUserId;
    private String startActivityId;
    private Object deleteReason;
    private String rootProcessInstanceId;
    private Object superProcessInstanceId;
    private Object superCaseInstanceId;
    private Object caseInstanceId;
    private Object tenantId;
    private String state;
}
