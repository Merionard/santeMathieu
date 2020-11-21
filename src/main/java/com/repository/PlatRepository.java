package com.repository;

import com.entites.Plat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatRepository extends JpaRepository<Plat,String> {

    Plat getByNom(String nom);
}
