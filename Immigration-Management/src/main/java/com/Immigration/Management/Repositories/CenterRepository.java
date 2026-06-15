package com.Immigration.Management.Repositories;

import com.Immigration.Management.Entities.ImmigrationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CenterRepository extends JpaRepository<ImmigrationCenter,Long> {

    @Query("select c from ImmigrationCenter c where c.id=:id")
    ImmigrationCenter findById(@Param("id") String id);

    @Query("select c from ImmigrationCenter c where c.name=:name")
    ImmigrationCenter findByName(@Param("name") String name);

}
