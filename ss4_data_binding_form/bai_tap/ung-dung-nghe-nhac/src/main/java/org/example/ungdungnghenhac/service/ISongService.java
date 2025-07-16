package org.example.ungdungnghenhac.service;

import org.example.ungdungnghenhac.model.Song;

import java.util.List;

public interface ISongService {
    void save(Song song);

    List<Song> findAll();
}
