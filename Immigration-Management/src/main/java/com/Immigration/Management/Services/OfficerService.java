package com.Immigration.Management.Services;

import com.Immigration.Management.Entities.ImmigrationCenter;
import com.Immigration.Management.Entities.ImmigrationOfficer;
import com.Immigration.Management.Repositories.CenterRepository;
import com.Immigration.Management.Repositories.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficerService {

    CenterRepository centerRepository;
    OfficerRepository officerRepository;
    @Autowired
    public OfficerService(CenterRepository centerRepository) {
        this.centerRepository = centerRepository;
        this.officerRepository = officerRepository;
    }

    public ImmigrationOfficer saveOfficer(ImmigrationOfficer immigrationOfficer){
        return officerRepository.save(immigrationOfficer);
    }
    public ImmigrationOfficer getOfficerById(String id){
        return officerRepository.getOfficerById(id);
    }
    public ImmigrationOfficer promoteOfficer(Long officerId, String newRank, int newClearanceLevel ){
        ImmigrationOfficer immigrationOfficer = officerRepository.getOfficerById(String.valueOf(officerId));
        if (!(newClearanceLevel>1 & newClearanceLevel < 5)){
            throw new RuntimeException("New Clearance Level must be between 1 to 5");
        }
        if (immigrationOfficer.isActive()){
        immigrationOfficer.setOfficerRank(newRank);
        immigrationOfficer.setClearanceLevel(newClearanceLevel);
        }else {
            throw new RuntimeException("Officer not exists");
        }
       return officerRepository.save(immigrationOfficer);
    }

    public ImmigrationOfficer transferOfficer(Long officerId, Long newCenterId){
        ImmigrationOfficer immigrationOfficer = officerRepository.getOfficerById(String.valueOf(officerId));
        if (immigrationOfficer.isActive()){
            ImmigrationCenter immigrationCenter = centerRepository.findById(String.valueOf(newCenterId));
               immigrationCenter.setId(newCenterId);
        }else {
            throw new RuntimeException("Officer not exists");
        }
        return officerRepository.save(immigrationOfficer);
    }

    public ImmigrationOfficer FindOfficerByRank(String rank){
      return officerRepository.FindOfficerByRank(rank);
    }
}
