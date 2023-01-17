package com.example.Sp1.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ErrorMessage {
    private HttpStatus status;
    private String Message;
}
