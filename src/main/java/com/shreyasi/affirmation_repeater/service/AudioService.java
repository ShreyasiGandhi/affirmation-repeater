package com.shreyasi.affirmation_repeater.service;

import com.shreyasi.affirmation_repeater.entity.AudioFile;
import com.shreyasi.affirmation_repeater.repository.AudioFileRepository;
import com.shreyasi.affirmation_repeater.service.tts.TextToSpeechStrategy;
import com.shreyasi.affirmation_repeater.service.tts.TtsStrategyResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AudioService {

    private final TtsStrategyResolver resolver;
    private final AudioFileRepository repository;

    @Value("${audio.tts.provider}")
    private String provider;

    public AudioService(TtsStrategyResolver resolver,
                        AudioFileRepository repository) {
        this.resolver = resolver;
        this.repository = repository;
    }

    public AudioFile generateAudio(Long affirmationId, String text) {
        TextToSpeechStrategy strategy = resolver.resolve(provider);

        String fileName = "affirmation_" + affirmationId + ".wav";
        String path = strategy.generateAudio(text, fileName);

        AudioFile audio = new AudioFile();
        audio.setAffirmationId(affirmationId);
        audio.setFilePath(path);
        audio.setFormat("wav");

        return repository.save(audio);
    }
}
