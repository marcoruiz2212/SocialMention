package com.appgate.SocialMention.service.strategy;

import com.appgate.SocialMention.model.SocialMention;
import com.appgate.SocialMention.service.FacebookScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.appgate.SocialMention.model.RiskAccountEnum.HIGH_RISK;
import static com.appgate.SocialMention.model.RiskAccountEnum.LOW_RISK;
import static com.appgate.SocialMention.model.RiskAccountEnum.MEDIUM_RISK;

@Service("facebook")
@RequiredArgsConstructor
public class FacebookSocialMention implements SocialMediaMentionStrategy{

    private final FacebookScoreService facebookScoreService;

    @Override
    public String analyze(SocialMention socialMention) {
        final String comments = socialMention
                .getComments()
                .stream()
                 .reduce("", (h, c) -> h + " " + c);
        socialMention.setMessage(socialMention.getMessage() + " || comments: " + comments);
        return getRiskLevel(facebookScoreService.calculateScore(socialMention));
    }


    private String getRiskLevel(double facebookScore){
        if (facebookScore == -100d) {
            return HIGH_RISK.name();
        } else if (facebookScore > -100d && facebookScore < 50d) {
            return MEDIUM_RISK.name();
        }
        return LOW_RISK.name();
    }

}
