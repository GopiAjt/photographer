package com.capturenoww.photographer.repository;

import com.capturenoww.photographer.model.Albums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbumRepo extends JpaRepository<Albums, String>{

	Optional<Albums> findByName(String fileName);

	void deleteById(Integer id);

	Optional<Albums> findById(String id);
}
