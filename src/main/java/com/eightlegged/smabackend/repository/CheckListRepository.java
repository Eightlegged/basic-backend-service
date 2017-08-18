package com.eightlegged.smabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eightlegged.smabackend.entity.CheckList;


@Repository
public interface CheckListRepository extends JpaRepository<CheckList, Long> {

}
