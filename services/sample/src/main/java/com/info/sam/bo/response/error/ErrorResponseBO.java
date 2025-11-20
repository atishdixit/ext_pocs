package com.info.sam.bo.response.error;

import com.info.sam.constant.Severity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseBO {
    private Integer errorCode;
    private String errorMessage;
    private Severity serSeverity;
}
