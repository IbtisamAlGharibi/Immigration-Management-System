package com.Immigration.Management.Repositories;

import com.Immigration.Management.Entities.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant,Long> {
}
