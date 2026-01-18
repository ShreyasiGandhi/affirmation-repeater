package com.shreyasi.affirmation_repeater.service.tts;

import org.springframework.stereotype.Component;

@Component("apiTts")
public class ApiTtsStrategy implements TextToSpeechStrategy {

    @Override
    public String generateAudio(String text, String outputFileName) {
        // Placeholder for future cloud/API integration
        throw new UnsupportedOperationException("API TTS not enabled yet");
    }
}