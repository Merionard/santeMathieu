package com.repository;

import com.entites.ReleveInformations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleveInfosRepository extends JpaRepository<ReleveInformations,Long> {
}
