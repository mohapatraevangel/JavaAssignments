package com.employee.dto;


import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ErrorDetails {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private String toContact;
}
