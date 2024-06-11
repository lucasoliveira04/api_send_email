package com.api_send_email.apisendemail.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConfigurationMail {
    private String host;
    private String port;
    private String username;
    private String password;
    private String supportMail;
}
