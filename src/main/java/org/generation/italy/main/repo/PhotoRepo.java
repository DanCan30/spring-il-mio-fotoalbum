package org.generation.italy.main.repo;

import java.util.List;

import org.generation.italy.main.pojo.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepo extends JpaRepository<Photo, Integer>{

	List<Photo> findByTitleContainingOrTagContainingIgnoreCase(String title, String tag);
}
