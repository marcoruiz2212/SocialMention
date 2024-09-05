package com.appgate.SocialMention.service.strategy;

import com.appgate.SocialMention.model.SocialMediaAccount;
import com.appgate.SocialMention.model.SocialMention;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("facebook")
public class FacebookSocialMention implements SocialMediaMentionStrategy{
    @Override
    public String analyze(SocialMention socialMention) {
        return "facebook";
    }
}
