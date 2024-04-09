package com.kafkademo.notificationservice.domain.request;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Getter
@Setter
public class SendEmailRequest {
    private ArrayList<String> cc;
    private String subject;
    private String body;

}
