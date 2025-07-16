package org.example.ungdungnghenhac.repository;

import org.example.ungdungnghenhac.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepo {
    private final List<Song> songs = new ArrayList<>();
    
    public void save(Song song){
        songs.add(song);
    }
    
    public List<Song> findAll(){
        return songs;
    }
}
