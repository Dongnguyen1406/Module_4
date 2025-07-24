package org.example.validate_music_information.repository;

import org.example.validate_music_information.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ISongRepository extends JpaRepository<Song, Integer> {
}
