package com.appgate.SocialMention.model;

import lombok.Data;

import java.util.List;

@Data
public class SocialMention {
    private String message;
    private SocialMediaEnum typeAccount;
    private String account;
    private String creationDate;
    private String url;
    private List<String> comments;
}
