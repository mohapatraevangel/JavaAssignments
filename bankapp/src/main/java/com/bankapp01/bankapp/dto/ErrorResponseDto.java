package com.bankapp01.bankapp.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponseDto {
    private String errorCode;
    private String errorMessge;
    private String timeStamp;
    private String toContact;
}
