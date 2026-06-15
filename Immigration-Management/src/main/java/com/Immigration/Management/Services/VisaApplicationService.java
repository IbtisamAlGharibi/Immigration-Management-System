package com.Immigration.Management.Services;

import com.Immigration.Management.Repositories.VisaApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisaApplicationService {
    VisaApplicationRepository visaApplicationRepository;
    @Autowired
    public VisaApplicationService(VisaApplicationRepository visaApplicationRepository) {
        this.visaApplicationRepository = visaApplicationRepository;
    }

}
