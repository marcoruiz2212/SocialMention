package com.appgate.SocialMention.service;

import com.appgate.SocialMention.model.SocialMention;
import com.appgate.SocialMention.repository.TwitterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TwitterScoreService {

    private final TwitterRepository twitterRepository;

    public double calculateScore(final SocialMention socialMention){
        double twitterScore = 0d;
        socialMention.setMessage("tweeterMessage: " + socialMention.getMessage());
        twitterScore = TwitterAnalyzer.analyzeTweet(
                socialMention.getUrl(),
                socialMention.getMessage(),
                socialMention.getAccount());
        twitterRepository.insertPost(twitterScore, socialMention);
        return twitterScore;
    }
}
