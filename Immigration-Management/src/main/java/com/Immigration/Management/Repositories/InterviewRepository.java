package com.Immigration.Management.Repositories;

import com.Immigration.Management.Entities.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InterviewRepository extends JpaRepository<Interview,Long> {
    @Query(" SELECT i FROM Interview i  WHERE i.immigrationOfficer.id =:officerId AND i.interviewDate =:date ")
    List<Interview> FindByOfficerIdAndInterviewDate(@Param("officerId") Long officerId ,  @Param("date") String date);
}
