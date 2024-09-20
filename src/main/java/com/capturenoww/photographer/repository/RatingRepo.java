package com.capturenoww.photographer.repository;


import com.capturenoww.photographer.model.Photographer;
import com.capturenoww.photographer.model.PhotographerRatings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepo extends JpaRepository<PhotographerRatings, String> {

    @Query("SELECT AVG(r.ratings) FROM PhotographerRatings r WHERE r.photographer = ?1")
    Double getAverageRatingByPhotographer(Photographer photographer);

    List<PhotographerRatings> getRatingsByPhotographer(Photographer photographer);
}
