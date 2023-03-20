package com.epicode.andreacursi.capstoneproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epicode.andreacursi.capstoneproject.entities.Videogioco;

@Repository
public interface VideogiocoRepository extends JpaRepository<Videogioco, Integer>{

}
