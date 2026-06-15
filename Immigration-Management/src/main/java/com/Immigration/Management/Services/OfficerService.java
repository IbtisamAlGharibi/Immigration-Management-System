package com.Immigration.Management.Services;

import com.Immigration.Management.Entities.ImmigrationOfficer;
import com.Immigration.Management.Repositories.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficerService {

    OfficerRepository officerRepository;
    @Autowired
    public OfficerService(OfficerRepository officerRepository) {
        this.officerRepository = officerRepository;
    }

    public ImmigrationOfficer promoteOfficer(Long officerId, String newRank, int newClearanceLevel ){
        ImmigrationOfficer immigrationOfficer = new ImmigrationOfficer();
        officerRepository.getOfficerById(String.valueOf(officerId));
        if (immigrationOfficer.isActive()){
        immigrationOfficer.setOfficerRank(newRank);
        immigrationOfficer.setClearanceLevel(newClearanceLevel);
        }else {
            throw new RuntimeException("Officer not exists");
        }
       return officerRepository.save(immigrationOfficer);
    }
}
