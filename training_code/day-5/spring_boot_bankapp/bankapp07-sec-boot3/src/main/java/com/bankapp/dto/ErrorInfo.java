package com.bankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorInfo {
    private String message;
    private String toContact;
    private String statusCode;
    private LocalDateTime timestamp;
}
