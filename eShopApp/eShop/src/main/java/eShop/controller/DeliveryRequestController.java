package eShop.controller;

import eShop.email.EmailCfg;
import eShop.model.DeliveryRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/deliveryRequest")
public class DeliveryRequestController {

    private EmailCfg emailCfg;

    public DeliveryRequestController(EmailCfg emailCfg) {
        this.emailCfg = emailCfg;
    }


    public void sendDeliveryRequest( DeliveryRequest deliveryRequest) {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailCfg.getHost());
        mailSender.setPort(this.emailCfg.getPort());
        mailSender.setUsername(this.emailCfg.getUserName());
        mailSender.setPassword(this.emailCfg.getPassord());

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(deliveryRequest.getEmail());
        simpleMailMessage.setTo("supplier@email.com");
        simpleMailMessage.setSubject("New Message from : "+ deliveryRequest.getName());
        simpleMailMessage.setText(deliveryRequest.getRequestContent());

        mailSender.send(simpleMailMessage);

    }
}
