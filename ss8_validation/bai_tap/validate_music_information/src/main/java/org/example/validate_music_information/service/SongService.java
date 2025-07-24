package org.example.validate_music_information.service;

import org.example.validate_music_information.entity.Song;
import org.example.validate_music_information.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService{
    
    @Autowired
    private ISongRepository songRepository;
    
    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song findById(Integer id) {
        return null;
    }

    @Override
    public void edit(Song song, Integer id) {

    }
}
