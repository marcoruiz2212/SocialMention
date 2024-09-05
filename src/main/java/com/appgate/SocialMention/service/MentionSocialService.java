package com.appgate.SocialMention.service;

import com.appgate.SocialMention.model.SocialMention;
import com.appgate.SocialMention.service.strategy.SocialMediaMentionStrategy;
import com.appgate.SocialMention.service.strategy.SocialMentionStrategyFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MentionSocialService {

    private final SocialMentionStrategyFactory socialMentionStrategyFactory;

    public String analyzeMentionSocial(final SocialMention socialMention){
        final SocialMediaMentionStrategy strategy = socialMentionStrategyFactory.getStrategy(socialMention.getAccount().name().toLowerCase());
        return strategy.analyze(socialMention);
    }
}
