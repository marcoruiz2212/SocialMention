package com.appgate.SocialMention.service.strategy;

import com.appgate.SocialMention.model.SocialMention;
import org.springframework.stereotype.Service;

@Service("twitter")
public class TwitterSocialMention implements SocialMediaMentionStrategy{
    @Override
    public String analyze(SocialMention socialMention) {
        return "twitter";
    }
}
