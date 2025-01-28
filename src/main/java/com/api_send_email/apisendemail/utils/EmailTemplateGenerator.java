package com.api_send_email.apisendemail.utils;

import com.api_send_email.apisendemail.enums.TypeMessage;

public class EmailTemplateGenerator {

    public static String generateEmailTemplate(TypeMessage typeMessage, String message, String title, String contactSection, String nameProjectOrNameBusiness) {
        switch (typeMessage) {
            case PORTFOLIO:
                return generatePortfolioTemplate(message, title, contactSection, nameProjectOrNameBusiness);
            case MESSAGE_PRESSURE:
                return generatePressureAlertTemplate();
            default:
                throw new IllegalArgumentException("Tipo de mensagem não suportado: " + typeMessage);
        }
    }

    private static String generatePortfolioTemplate(String message, String title, String contactSection, String nameProjectOrNameBusiness) {
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
                contactSection +
                "<p>Mensagem:</p>" +
                "<p>" + message + "</p>" +
                "</div>" +
                "<div class='footer'>" +
                "<p>&copy; " + java.time.LocalDate.now().getYear() + " " + nameProjectOrNameBusiness + ". Todos os direitos reservados.</p>" +
                "</div>" +
                "</div>" +
                "</body>" +
                "</html>";
    }

    private static String generatePressureAlertTemplate() {
        return "<!DOCTYPE html>" +
                "<html lang='pt-BR'>" +
                "<head>" +
                "<meta charset='UTF-8'>" +
                "<meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                "<style>" +
                "body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }" +
                ".email-container { background-color: #ffffff; margin: 20px; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }" +
                ".header { background-color: #FF6347; padding: 10px; color: white; text-align: center; border-radius: 10px 10px 0 0; }" +
                ".content { padding: 20px; text-align: center; font-size: 20px; font-weight: bold; color: red; }" +
                ".footer { text-align: center; padding: 10px; font-size: 12px; color: #888888; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='email-container'>" +
                "<div class='header'>" +
                "<h1>Alerta de Pressão!</h1>" +
                "</div>" +
                "<div class='content'>" +
                "<p><strong>TIRE A PRESSÃO! TIRE A PRESSÃO!</strong></p>" +
                "</div>" +
                "<div class='footer'>" +
                "<p>&copy; " + java.time.LocalDate.now().getYear() + " Sistema de Monitoramento de Pressão. Todos os direitos reservados.</p>" +
                "</div>" +
                "</div>" +
                "</body>" +
                "</html>";
    }
}
