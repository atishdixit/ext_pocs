package com.ext.ai.controller;

import com.ext.ai.model.AppStatus;
import com.ext.ai.service.infc.SongsServiceInfc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongsController {

    @Autowired
    private SongsServiceInfc songsServiceInfc;

    @GetMapping("/status")
    public AppStatus checkStatus(){
        return new AppStatus(200, "Songs: Service Up");
    }

    @GetMapping("/by-artist")
    public String getSongsByArtist(@RequestParam(value = "artist", defaultValue = "Taylor swift") String artist){
        return songsServiceInfc.getSongsByArtist(artist);
    }

    @GetMapping("/by-artist-json")
    public List<String> getSongsByArtistAsJson(@RequestParam(value = "artist", defaultValue = "Taylor swift") String artist){
        return songsServiceInfc.getSongsByArtistAsJson(artist);
    }

}
