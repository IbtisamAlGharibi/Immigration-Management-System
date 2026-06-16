package com.Immigration.Management.Services;

import com.Immigration.Management.Entities.Applicant;
import com.Immigration.Management.Entities.VisaApplication;
import com.Immigration.Management.Repositories.ApplicantRepository;
import com.Immigration.Management.Repositories.VisaApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisaApplicationService {
    VisaApplicationRepository visaApplicationRepository;
    @Autowired
    public VisaApplicationService(VisaApplicationRepository visaApplicationRepository) {
        this.visaApplicationRepository = visaApplicationRepository;
    }
    ApplicantRepository applicantRepository;
    @Autowired
    public VisaApplicationService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
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
}
