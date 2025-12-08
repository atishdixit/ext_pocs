package com.ext.ai.service.infc;

import java.util.List;

public interface SongsServiceInfc {
    String getSongsByArtist(String artist);
    List<String> getSongsByArtistAsJson(String artist);
}
