package com.Immigration.Management.Repositories;

import com.Immigration.Management.Entities.ImmigrationOfficer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficerRepository extends JpaRepository<ImmigrationOfficer,Long> {
}
