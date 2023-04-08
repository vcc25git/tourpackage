package com.mycompany.tourpackage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.tourpackage.entity.TourPackage;

@Repository
public interface TourPackageRepository extends JpaRepository<TourPackage, Long> {

}
