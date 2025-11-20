package com.info.sam.bo;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
public class AuditLogBO {
    private String messageId;
    private String operationName;
    private String hostName;
    private String error;
    private String payload;
    private String response;
    private Instant startTime;
    private Instant endTime;
}
