package com.appgate.SocialMention.controller;

import com.appgate.SocialMention.model.SocialMention;
import com.appgate.SocialMention.service.MentionSocialService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class SocialMentionController {


    private final MentionSocialService mentionSocialService;


    @PostMapping("/analyzeSocialMention")
    public String analize(@RequestBody SocialMention socialMention){
        return mentionSocialService.analyzeMentionSocial(socialMention);
    }
}
