package com.appgate.SocialMention.service.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SocialMentionStrategyFactory {

    private final Map<String, SocialMediaMentionStrategy> strategies;

    @Autowired
    public SocialMentionStrategyFactory(Map<String, SocialMediaMentionStrategy> strategies){
        this.strategies = strategies;
    }

    public SocialMediaMentionStrategy getStrategy(String socialMention){
        return strategies.get(socialMention);
    }
}
