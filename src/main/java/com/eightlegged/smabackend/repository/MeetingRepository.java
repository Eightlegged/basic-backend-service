package com.eightlegged.smabackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eightlegged.smabackend.entity.Meeting;
import com.eightlegged.smabackend.entity.Status;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
	List<Meeting> findByStatus(Status status);
}