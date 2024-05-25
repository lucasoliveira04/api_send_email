package com.api_send_email.apisendemail.Controller;

import com.api_send_email.apisendemail.Request.EmailRequest;
import com.api_send_email.apisendemail.Services.SendEmail;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/send/email")
public class SendEmailApiController {
    private final SendEmail sendEmail;

    public SendEmailApiController(SendEmail sendEmail) {
        this.sendEmail = sendEmail;
    }

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        sendEmail.send(emailRequest.getMessage(), emailRequest.getContacts());
        return "Email sent successfully";
    }
}
