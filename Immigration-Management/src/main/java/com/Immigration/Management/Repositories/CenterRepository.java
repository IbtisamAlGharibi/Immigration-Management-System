package com.Immigration.Management.Repositories;

import com.Immigration.Management.Entities.ImmigrationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CenterRepository extends JpaRepository<ImmigrationCenter,Long> {
}
