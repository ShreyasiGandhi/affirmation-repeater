package com.shreyasi.affirmation_repeater.service.tts;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TtsStrategyResolver {

    private final Map<String, TextToSpeechStrategy> strategies;

    public TtsStrategyResolver(Map<String, TextToSpeechStrategy> strategies) {
        this.strategies = strategies;
    }

    public TextToSpeechStrategy resolve(String provider) {
        TextToSpeechStrategy strategy = strategies.get(provider);
        if (strategy == null) {
            throw new IllegalArgumentException("Invalid TTS provider: " + provider);
        }
        return strategy;
    }
}