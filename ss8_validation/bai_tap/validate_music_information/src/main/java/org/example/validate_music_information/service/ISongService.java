package org.example.validate_music_information.service;

import org.example.validate_music_information.entity.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);

    Song findById(Integer id);

    boolean edit(Song song);
}
