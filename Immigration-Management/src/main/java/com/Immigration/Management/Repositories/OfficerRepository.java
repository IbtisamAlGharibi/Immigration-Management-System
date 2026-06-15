package com.Immigration.Management.Repositories;

import com.Immigration.Management.Entities.ImmigrationOfficer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OfficerRepository extends JpaRepository<ImmigrationOfficer,Long> {

    @Query("select o from ImmigrationOfficer o where o.isActive = true")
    List<ImmigrationOfficer> getAllOfficers();

    @Query("select o from ImmigrationOfficer o where o.id=:id ")
    ImmigrationOfficer getOfficerById(@Param("id") String id);

    @Query("select o from ImmigrationOfficer o where o.badgeNumber=:badgeNumber ")
    ImmigrationOfficer getOfficerByBadgeNumber(@Param("badgeNumber") String badgeNumber);
}
