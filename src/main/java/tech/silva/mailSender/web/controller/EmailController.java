package tech.silva.mailSender.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.silva.mailSender.service.EmailService;
import tech.silva.mailSender.web.dto.MailSendDto;

@RestController
@RequestMapping("/emails/v1")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<String> sendMail(@RequestBody MailSendDto mailSendDto){
        String mail = emailService.sendMail(mailSendDto.recipient(),
                mailSendDto.subject(),
                mailSendDto.message());
        return ResponseEntity.ok().body(mail);
    }
}
