package com.Immigration.Management.Repositories;

import com.Immigration.Management.Entities.VisaApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VisaApplicationRepository extends JpaRepository<VisaApplication,Long> {
    @Query("select v from VisaApplication v where v.id=:id ")
    VisaApplication getVisaById(@Param("id") String id);
}
