package com.appgate.SocialMention.service;

import com.appgate.SocialMention.model.SocialMention;
import com.appgate.SocialMention.repository.FacebookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacebookScoreService {

    private final FacebookRepository facebookRepository;

    public double calculateScore(final SocialMention socialMention) {
        double facebookScore = 0d;
        double facebookCommentsScore = 0;
        // Analyze and score facebook comments if present
        if (socialMention.getMessage().contains("comments:")) {
            facebookCommentsScore = FacebookAnalyzer.calculateFacebookCommentsScore(
                    socialMention
                            .getMessage()
                            .substring(socialMention.getMessage().indexOf("comments:"))

            );
            if (facebookCommentsScore < 50d) {
                facebookScore = Double.sum(facebookScore, -100d);
            }
        }

        if(facebookScore > -100){
            facebookScore = FacebookAnalyzer.analyzePost(
                    socialMention.getMessage(),
                    socialMention.getTypeAccount()

            );
            facebookRepository.insertPost(facebookScore,
                    socialMention.getMessage(),
                    socialMention.getAccount());
        }

        return facebookScore;
    }
}

