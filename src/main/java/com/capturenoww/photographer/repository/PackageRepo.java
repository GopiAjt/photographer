package com.capturenoww.photographer.repository;


import com.capturenoww.photographer.model.Packages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PackageRepo extends JpaRepository<Packages, String>{
    void delete(Packages entity);
}
