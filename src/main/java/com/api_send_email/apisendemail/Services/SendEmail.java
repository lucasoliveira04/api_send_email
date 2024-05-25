package com.api_send_email.apisendemail.Services;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SendEmail {
    private final JavaMailSender javaMailSender;

    @Value("${support.mail}")
    private String supportMail;

    public SendEmail(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void send(String message, String contact) {
        try{
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            messageHelper.setFrom(supportMail);
            messageHelper.setTo(supportMail);
            messageHelper.setSubject("Blog | Feedback");
            messageHelper.setText(getMessage(message, contact), true);
            javaMailSender.send(mimeMessage);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private String getMessage(String message, String contact) {
        String contactInfo;
        if (contact != null && !contact.isEmpty()) {
            contactInfo = contact;
        } else {
            contactInfo = "MENSAGEM ANÔNIMA";
        }

        return "<!DOCTYPE html>" +
                "<html lang='pt-BR'>" +
                "<head>" +
                "<meta charset='UTF-8'>" +
                "<meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                "<style>" +
                "body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }" +
                ".email-container { background-color: #ffffff; margin: 20px; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }" +
                ".header { background-color: #4CAF50; padding: 10px; color: white; text-align: center; border-radius: 10px 10px 0 0; }" +
                ".content { padding: 20px; }" +
                ".footer { text-align: center; padding: 10px; font-size: 12px; color: #888888; }" +
                "</style>" +
                "<script>" +
                "function displayContact() {" +
                "   document.getElementById('contact-info').innerText = '" + contactInfo + "';" +
                "}" +
                "window.onload = displayContact;" +
                "</script>" +
                "</head>" +
                "<body>" +
                "<div class='email-container'>" +
                "<div class='header'>" +
                "<h1>Feedback do Portfolio</h1>" +
                "</div>" +
                "<div class='content'>" +
                "<p>Contato: <span id='contact-info'>"+ contactInfo +"</span></p>" +
                "<p>Mensagem:</p>" +
                "<p>" + message + "</p>" +
                "</div>" +
                "<div class='footer'>" +
                "<p>&copy; " + java.time.LocalDate.now().getYear() + " Portfolio. Todos os direitos reservados.</p>" +
                "</div>" +
                "</div>" +
                "</body>" +
                "</html>";
    }



}

