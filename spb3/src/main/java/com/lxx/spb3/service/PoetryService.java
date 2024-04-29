package com.lxx.spb3.service;

import org.springframework.ai.client.AiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoetryService {
    private final AiClient aiClient;

    @Autowired
    public PoetryService(AiClient aiClient) {
        this.aiClient = aiClient;
    }

    public String generatePoetry(String theme, String genre) {
        // 使用AI生成诗歌的逻辑
        return aiClient.generate(theme + " " + genre);
    }
}
