package com.Immigration.Management.Controllers;

import com.Immigration.Management.Entities.Interview;
import com.Immigration.Management.Services.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interview")
public class InterviewController {
    InterviewService interviewService;
    @Autowired
    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @PostMapping("/schedule/{applicantId}/{officerId}")
    public Interview scheduleInterview(@PathVariable Long applicantId,@PathVariable Long officerId, @RequestParam String date) {
        return interviewService.scheduleInterview(applicantId, officerId, date);
    }
    @PutMapping("/{id}/complete")
    public Interview completeInterview(@PathVariable Long id) {
        return interviewService.completeInterview(id);
    }
    @PutMapping("/{id}/cancel")
    public Interview cancelInterview(@PathVariable Long id) {
        return interviewService.cancelInterview(id);
    }
    @GetMapping("/officer/{officerId}/date/{date}")
    public List<Interview> getOfficerSchedule(@PathVariable Long officerId,@PathVariable String date) {
        return interviewService.getOfficerSchedule(officerId, date);
    }
}
