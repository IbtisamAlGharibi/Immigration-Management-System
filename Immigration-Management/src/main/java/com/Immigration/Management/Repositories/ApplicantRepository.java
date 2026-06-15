package com.Immigration.Management.Repositories;

import com.Immigration.Management.Entities.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicantRepository extends JpaRepository<Applicant,Long> {

    @Query("Select a.firstName, a.lastName , a.nationality from Applicant a where a.nationality=:nationality")
    List<Applicant> findByNationality(@Param("nationality") String nationality);

    @Query("Select a.firstName, a.lastName , a.passportNumber from Applicant a where a.passportNumber=:passportNumber")
    List<Applicant> findByPassportNumber(@Param("passportNumber") String passportNumber);

    @Query("Select a.firstName, a.lastName , a.id from Applicant a where a.id=:id")
    List<Applicant> findById(@Param("id") String  id);
}
