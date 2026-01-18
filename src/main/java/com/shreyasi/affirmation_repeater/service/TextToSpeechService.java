package com.shreyasi.affirmation_repeater.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TextToSpeechService {

    private static final String ESPEAK_PATH =
            "C:\\Program Files\\eSpeak NG\\espeak-ng.exe";

    public void speak(String text) throws IOException {
        ProcessBuilder pb = new ProcessBuilder(ESPEAK_PATH, text);
        pb.start();
    }
}
