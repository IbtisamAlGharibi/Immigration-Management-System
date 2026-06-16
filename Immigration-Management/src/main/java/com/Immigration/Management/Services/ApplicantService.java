package com.Immigration.Management.Services;

import com.Immigration.Management.Entities.Applicant;
import com.Immigration.Management.Entities.Interview;
import com.Immigration.Management.Repositories.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {
    ApplicantRepository applicantRepository;

    @Autowired
    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }
     public List<Applicant> getAllApplicant() {
        return applicantRepository.findAll();

    }

    public Applicant saveApplicant(String firstName, String lastName, String passportNumber, String nationality){
        if (passportNumber == null || passportNumber.isBlank()){
            throw new RuntimeException("Passport Number can not be EMPTY");
        }
        if (firstName == null || firstName.isBlank()){
            throw new RuntimeException("First name can not be EMPTY");
        }
        if (lastName == null || lastName.isBlank()){
            throw new RuntimeException("Last name can not be EMPTY");
        }
        Applicant applicantToAdd = new Applicant();
        applicantToAdd.setFirstName(firstName);
        applicantToAdd.setLastName(lastName);
        applicantToAdd.setNationality(nationality);
        applicantToAdd.setPassportNumber(passportNumber);

        return  applicantRepository.save(applicantToAdd);
    }

    public Applicant saveApplicant(Applicant applicant){
        if (applicant.getPassportNumber() == null || applicant.getPassportNumber().isBlank()){
            throw new RuntimeException("Passport Number can not be EMPTY");
        }
        if (applicant.getFirstName() == null || applicant.getFirstName().isBlank()){
            throw new RuntimeException("First name can not be EMPTY");
        }
        if (applicant.getLastName() == null || applicant.getLastName().isBlank()){
            throw new RuntimeException("Last name can not be EMPTY");
        }
        Applicant applicantToAdd = new Applicant();
        applicantToAdd.setFirstName(applicant.getFirstName());
        applicantToAdd.setLastName(applicant.getLastName());
        applicantToAdd.setPhoneNumber(applicant.getPhoneNumber());
        applicantToAdd.setGender(applicant.getGender());
        applicantToAdd.setEmail(applicant.getEmail());
        return applicantRepository.save(applicantToAdd);
    }

    public Applicant flagCriminalRecord(Long applicantId){
        Applicant applicant = new Applicant();
        applicantRepository.findById(applicantId);
        applicant.setCriminalRecord(true);

        for (Interview interview : applicant.getInterviews()){
            interview.setStatus("SCHEDULED");
        }
        return applicantRepository.save(applicant);
    }
}
