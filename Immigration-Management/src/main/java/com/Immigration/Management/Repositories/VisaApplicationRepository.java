package com.Immigration.Management.Repositories;

import com.Immigration.Management.Entities.VisaApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisaApplicationRepository extends JpaRepository<VisaApplication,Long> {
}
