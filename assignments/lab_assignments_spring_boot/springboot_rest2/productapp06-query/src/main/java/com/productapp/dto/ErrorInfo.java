package com.productapp.dto;

import lombok.*;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ErrorInfo {
    private String statusCode;
    private String errorMessage;
    private LocalDateTime timestamp;
    private String toContent;

}
