package com.api_send_email.apisendemail.Request;

import com.api_send_email.apisendemail.enums.TypeMessage;
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
    private TypeMessage typeMessage;
}
