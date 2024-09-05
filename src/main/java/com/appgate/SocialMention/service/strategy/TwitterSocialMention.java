package com.appgate.SocialMention.service.strategy;

import com.appgate.SocialMention.model.SocialMention;
import com.appgate.SocialMention.repository.TwitterRepository;
import com.appgate.SocialMention.service.TwitterAnalyzer;
import com.appgate.SocialMention.service.TwitterScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.appgate.SocialMention.model.RiskAccountEnum.HIGH_RISK;
import static com.appgate.SocialMention.model.RiskAccountEnum.LOW_RISK;
import static com.appgate.SocialMention.model.RiskAccountEnum.MEDIUM_RISK;

@Service("twitter")
@RequiredArgsConstructor
public class TwitterSocialMention implements SocialMediaMentionStrategy{

    private final TwitterScoreService twitterScoreService;
    @Override
    public String analyze(SocialMention socialMention) {
        return getRiskLevel(twitterScoreService.calculateScore(socialMention));
    }

    private String getRiskLevel(double twitterScore){
        if (twitterScore >= -1 && twitterScore <= -0.5d) {
            return HIGH_RISK.name();
        } else if (twitterScore > -0.5d && twitterScore < 0.7d) {
            return MEDIUM_RISK.name();
        }
        return  LOW_RISK.name();
    }
}
