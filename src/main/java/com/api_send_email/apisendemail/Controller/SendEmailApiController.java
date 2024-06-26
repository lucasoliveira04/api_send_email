package com.api_send_email.apisendemail.Controller;

import com.api_send_email.apisendemail.Request.EmailSendRequest;
import com.api_send_email.apisendemail.Services.SendEmail;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins= "*", allowedHeaders= "*")
@RestController
@RequestMapping("/api/send/email")
public class SendEmailApiController {
    private final SendEmail sendEmail;

    public SendEmailApiController(SendEmail sendEmail) {
        this.sendEmail = sendEmail;
    }

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailSendRequest emailSendRequest) {
        sendEmail.send(
                emailSendRequest.getEmailRequest().getMessage(),
                emailSendRequest.getEmailRequest().getContacts(),
                emailSendRequest.getEmailRequest().getSubject(),
                emailSendRequest.getEmailRequest().getTitle(),
                emailSendRequest.getEmailRequest().getNameProjectOrNameBusiness()
        );
        return "Email successfully sent";
    }
}
