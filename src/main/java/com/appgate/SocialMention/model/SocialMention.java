package com.appgate.SocialMention.model;

import lombok.Data;

import java.util.List;

@Data
public class SocialMention {
    private String message;
    private SocialMediaAccount account;
    private String creationDate;
    private String url;
    private List<String> comments;
}
