package com.eightlegged.smabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eightlegged.smabackend.entity.Meeting;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {

}