package com.ext.ai.service.impl;

import com.ext.ai.client.SongsClient;
import com.ext.ai.service.infc.SongsServiceInfc;
import com.ext.ai.utils.PromptUtil;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.ext.ai.ApplicationConstant.APP_CONSTANT_ARTIST;
import static com.ext.ai.ApplicationConstant.APP_CONSTANT_OUTPUT_FORMAT;
import static com.ext.ai.queries.Queries.SONGS_BY_GIVEN_ARTIST;

@Service
public class SongsService implements SongsServiceInfc {

    @Autowired
    private ListOutputConverter converter;

    @Autowired
    private SongsClient songsClient;

    @Override
    public String getSongsByArtist(String artist) {
        Prompt prompt = PromptUtil.preparePrompt(SONGS_BY_GIVEN_ARTIST, Map.of(APP_CONSTANT_ARTIST, artist));
       return songsClient.call(prompt);
    }

    @Override
    public List<String> getSongsByArtistAsJson(String artist) {
        Prompt prompt = PromptUtil.preparePrompt(SONGS_BY_GIVEN_ARTIST, Map.of(APP_CONSTANT_ARTIST, artist, APP_CONSTANT_OUTPUT_FORMAT, converter.getFormat()));
        return converter.convert(songsClient.call(prompt));
    }
}
