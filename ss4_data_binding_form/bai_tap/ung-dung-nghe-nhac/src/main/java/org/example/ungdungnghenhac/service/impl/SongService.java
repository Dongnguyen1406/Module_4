package org.example.ungdungnghenhac.service.impl;

import org.example.ungdungnghenhac.model.Song;
import org.example.ungdungnghenhac.repository.SongRepo;
import org.example.ungdungnghenhac.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    
    @Autowired
    private SongRepo songRepo;
    
    @Override
    public void save(Song song) {
        songRepo.save(song);
    }

    @Override
    public List<Song> findAll() {
        return songRepo.findAll();
    }
}
