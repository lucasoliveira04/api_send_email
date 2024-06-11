package com.api_send_email.apisendemail.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailSendRequest {
    private EmailRequest emailRequest;
    private ConfigurationMail configurationMail;
}
