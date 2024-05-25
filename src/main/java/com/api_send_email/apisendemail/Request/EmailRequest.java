package com.api_send_email.apisendemail.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class EmailRequest {
    private String message;
    private String contacts;
}
