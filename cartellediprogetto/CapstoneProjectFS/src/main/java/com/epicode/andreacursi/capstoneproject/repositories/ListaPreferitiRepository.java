package com.epicode.andreacursi.capstoneproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epicode.andreacursi.capstoneproject.entities.ListaPreferiti;

@Repository
public interface ListaPreferitiRepository extends JpaRepository<ListaPreferiti, Integer>{

}
