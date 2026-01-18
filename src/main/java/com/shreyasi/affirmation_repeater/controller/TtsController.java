package com.shreyasi.affirmation_repeater.controller;

import com.shreyasi.affirmation_repeater.service.TextToSpeechService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/tts")
public class TtsController {

    private final TextToSpeechService ttsService;

    public TtsController(TextToSpeechService ttsService) {
        this.ttsService = ttsService;
    }

    @GetMapping("/speak")
    public String speak(@RequestParam String text) throws IOException {
        ttsService.speak(text);
        return "Speaking: " + text;
    }
}
