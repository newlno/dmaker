package com.programming.dmaker.repository;

import com.programming.dmaker.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DMakerRepository extends JpaRepository<Developer, Long> {

}
