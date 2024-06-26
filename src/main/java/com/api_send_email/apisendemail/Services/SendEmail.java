package com.api_send_email.apisendemail.Services;

import com.api_send_email.apisendemail.Request.ConfigurationMail;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class SendEmail {
    private final JavaMailSender mailSender;
    private final ConfigurationMail configurationMail;

    public SendEmail(JavaMailSender mailSender, ConfigurationMail configurationMail) {
        this.mailSender = mailSender;
        this.configurationMail = configurationMail;
    }

    private JavaMailSender createMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(configurationMail.getHost());
        mailSender.setPort(Integer.parseInt(configurationMail.getPort()));
        mailSender.setUsername(configurationMail.getUsername());
        mailSender.setPassword(configurationMail.getPassword());

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");

        return mailSender;
    }

    public void send(String message, String contact, String subject, String title, String nameProjectOrNameBusiness) {
        try {
            JavaMailSender mailSender = createMailSender();
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            messageHelper.setFrom(configurationMail.getSupportMail());
            messageHelper.setTo(configurationMail.getSupportMail());
            messageHelper.setSubject(subject);
            messageHelper.setText(getMessage(message, contact, title, nameProjectOrNameBusiness), true);
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getMessage(String message, String contact, String title, String nameProjectOrNameBusiness) {
        String contactInfo = (contact != null && !contact.isEmpty()) ? contact : "MENSAGEM ANÔNIMA";

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
                "</head>" +
                "<body>" +
                "<div class='email-container'>" +
                "<div class='header'>" +
                "<h1>" + title + "</h1>" +
                "</div>" +
                "<div class='content'>" +
                "<p>Contato: " + contactInfo + "</p>" +
                "<p>Mensagem:</p>" +
                "<p>" + message + "</p>" +
                "</div>" +
                "<div class='footer'>" +
                "<p>&copy; " + java.time.LocalDate.now().getYear() + " " +nameProjectOrNameBusiness + " . Todos os direitos reservados.</p>" +
                "</div>" +
                "</div>" +
                "</body>" +
                "</html>";
    }
}
