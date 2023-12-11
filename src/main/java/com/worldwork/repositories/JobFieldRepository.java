package com.worldwork.repositories;

import com.worldwork.entities.JobField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobFieldRepository extends JpaRepository<JobField, Integer> {
}
