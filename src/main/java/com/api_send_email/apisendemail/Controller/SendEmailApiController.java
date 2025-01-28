package com.api_send_email.apisendemail.Controller;

import com.api_send_email.apisendemail.Request.EmailSendRequest;
import com.api_send_email.apisendemail.Services.SendEmail;
import com.api_send_email.apisendemail.enums.TypeMessage;
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
        TypeMessage typeMessage = emailSendRequest.getTypeMessage();

        if (typeMessage == null){
            typeMessage = TypeMessage.PORTFOLIO;
        }

        sendEmail.send(
                emailSendRequest.getEmailRequest().getMessage(),
                emailSendRequest.getEmailRequest().getContacts(),
                emailSendRequest.getEmailRequest().getSubject(),
                emailSendRequest.getEmailRequest().getTitle(),
                emailSendRequest.getEmailRequest().getNameProjectOrNameBusiness(),
                typeMessage
        );


        return "Email successfully sent";
    }

}
