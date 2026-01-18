package com.shreyasi.affirmation_repeater.service.tts;

import org.springframework.stereotype.Component;

@Component("offlineTts")
public class OfflineTtsStrategy implements TextToSpeechStrategy {

    @Override
    public String generateAudio(String text, String outputFileName) {
        String outputPath = "audio/" + outputFileName;

        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "espeak",
                    text,
                    "-w",
                    outputPath
            );
            pb.start().waitFor();
        } catch (Exception e) {
            throw new RuntimeException("Offline TTS failed", e);
        }

        return outputPath;
    }
}
