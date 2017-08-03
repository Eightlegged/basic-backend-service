package com.eightlegged.smabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eightlegged.smabackend.entity.Meeting;
import com.eightlegged.smabackend.entity.User;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {

	Iterable<Meeting> findAllByUser(User user);
}