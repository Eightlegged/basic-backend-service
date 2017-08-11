package com.eightlegged.smabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eightlegged.smabackend.entity.Part;


public interface PartRepository extends JpaRepository<Part, Long>{

}
