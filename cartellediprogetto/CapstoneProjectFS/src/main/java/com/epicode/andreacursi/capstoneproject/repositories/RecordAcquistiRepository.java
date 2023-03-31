package com.epicode.andreacursi.capstoneproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epicode.andreacursi.capstoneproject.entities.RecordAcquisti;

@Repository
public interface RecordAcquistiRepository extends JpaRepository<RecordAcquisti, Integer>{

}
