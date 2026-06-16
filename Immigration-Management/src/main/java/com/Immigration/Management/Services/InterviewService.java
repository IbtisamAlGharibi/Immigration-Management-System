package com.Immigration.Management.Services;

import com.Immigration.Management.Entities.Applicant;
import com.Immigration.Management.Entities.ImmigrationOfficer;
import com.Immigration.Management.Entities.Interview;
import com.Immigration.Management.Repositories.ApplicantRepository;
import com.Immigration.Management.Repositories.InterviewRepository;
import com.Immigration.Management.Repositories.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterviewService {
    InterviewRepository interviewRepository;
    @Autowired
    public InterviewService(InterviewRepository interviewRepository) {
        this.interviewRepository = interviewRepository;
    }

    ApplicantRepository applicantRepository;
    @Autowired
    public InterviewService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }
    OfficerRepository officerRepository;
    @Autowired
    public InterviewService(OfficerRepository officerRepository) {
        this.officerRepository = officerRepository;
    }

    public Interview scheduleInterview(Long applicantId, Long officerId, String Date){
        Interview interview = new Interview();
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));
        ImmigrationOfficer immigrationOfficer = officerRepository.getOfficerById(String.valueOf(officerId));
        if (!(interviewRepository.FindByOfficerIdAndInterviewDate(officerId,Date).isEmpty()) ){
            throw new RuntimeException("Officer is double-booked!");
        }else {
            interview.setApplicant(applicant);
            interview.setImmigrationOfficer(immigrationOfficer);
            interview.setInterviewDate(Date);
        }
        return interviewRepository.save(interview);
    }

    public Interview completeInterview(Long interviewId){
        Interview interview = interviewRepository.findById(interviewId)
                .orElseThrow(() -> new RuntimeException("Interview not found"));
        interview.setStatus("COMPLETED");
        return interviewRepository.save(interview);
    }
}
