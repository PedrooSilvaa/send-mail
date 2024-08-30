package tech.silva.mailSender.web.dto;

public record MailSendDto(
        String recipient,
        String subject,
        String message
) {
}
