package com.Immigration.Management.Repositories;

import com.Immigration.Management.Entities.VisaApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VisaApplicationRepository extends JpaRepository<VisaApplication,Long> {
    List<VisaApplication> findByApplicantId(Long applicantId);
    List<VisaApplication> findByStatus(String status);
    @Query("select v from VisaApplication v where v.id=:id ")
    VisaApplication getVisaById(@Param("id") String id);

    @Query("select v from VisaApplication v where v.visaType=:visaType ")
    VisaApplication getVisaByType(@Param("visaType") String visaType);
}
