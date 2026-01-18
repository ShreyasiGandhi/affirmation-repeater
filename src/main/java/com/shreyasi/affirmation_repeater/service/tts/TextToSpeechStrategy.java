package com.shreyasi.affirmation_repeater.service.tts;
public interface TextToSpeechStrategy {

    /**
     * Converts text to speech and returns generated audio file path
     */
    String generateAudio(String text, String outputFileName);
}
