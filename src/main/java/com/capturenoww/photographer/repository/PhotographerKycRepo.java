package com.capturenoww.photographer.repository;


import com.capturenoww.photographer.model.PhotographerKycDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotographerKycRepo extends JpaRepository<PhotographerKycDetails, String> {

}
