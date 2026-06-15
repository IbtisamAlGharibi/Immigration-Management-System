package com.Immigration.Management.Repositories;

import com.Immigration.Management.Entities.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Interview,Long> {
}
