package org.example.repository;

import org.example.entity.CrimeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrimeRepository extends JpaRepository<CrimeRecord, Long> {}
