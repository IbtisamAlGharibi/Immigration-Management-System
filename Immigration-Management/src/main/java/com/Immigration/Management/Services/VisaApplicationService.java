package com.Immigration.Management.Services;

import com.Immigration.Management.Entities.Applicant;
import com.Immigration.Management.Entities.ImmigrationOfficer;
import com.Immigration.Management.Entities.VisaApplication;
import com.Immigration.Management.Repositories.ApplicantRepository;
import com.Immigration.Management.Repositories.OfficerRepository;
import com.Immigration.Management.Repositories.VisaApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisaApplicationService {
    VisaApplicationRepository visaApplicationRepository;
    ApplicantRepository applicantRepository;
    OfficerRepository officerRepository;
    @Autowired
    public VisaApplicationService(VisaApplicationRepository visaApplicationRepository) {
        this.visaApplicationRepository = visaApplicationRepository;
        this.applicantRepository = applicantRepository;
        this.officerRepository = officerRepository;
    }
    public List<VisaApplication> getVisasByApplicantId(Long applicantId) {
        return visaApplicationRepository.findByApplicantId(applicantId);
    }
    public List<VisaApplication> getVisasByStatus(String status) {
        return visaApplicationRepository.findByStatus(status);
    }

    public VisaApplication SubmitApplication(Long applicantId, String visaType){
        List<Applicant> applicant = applicantRepository.findById(String.valueOf(applicantId));
        VisaApplication visaApplication = visaApplicationRepository.getVisaByType(visaType);
        if (applicant.getFirst().isCriminalRecord()){
           visaApplication.setStatus("REJECTED");
           throw new RuntimeException("Auto rejected due to criminal flag");
        }
        return visaApplicationRepository.save(visaApplication);
    }

    public VisaApplication assignOfficer(Long visaId,Long officerId){
        ImmigrationOfficer immigrationOfficer = officerRepository.getOfficerById(String.valueOf(officerId));
        VisaApplication visaApplication = visaApplicationRepository.getVisaById(String.valueOf(visaId));

        if (visaApplication.getVisaType().equalsIgnoreCase("Asylum")){
            if (immigrationOfficer.getClearanceLevel()== 4 ||  immigrationOfficer.getClearanceLevel()== 5){
                visaApplication.setImmigrationOfficer(immigrationOfficer);
            }else {
                throw  new RuntimeException("Clearance Level Must Be 4 or 5");
            }
        }
        return visaApplicationRepository.save(visaApplication);
    }

    public VisaApplication ProcessVisa(Long visaId, String newStatus, String notes){
        VisaApplication visaApplication = visaApplicationRepository.getVisaById(String.valueOf(visaId));
        if (!(visaApplication.getStatus().equalsIgnoreCase("APPROVED"))
                || !(visaApplication.getStatus().equalsIgnoreCase( "REJECTED"))){
            throw new RuntimeException("Status Must Be APPROVED or REJECTED");
        }
        visaApplication.setStatus(newStatus);
        visaApplication.setOfficerNotes(notes);
        return visaApplicationRepository.save(visaApplication);
    }
}
