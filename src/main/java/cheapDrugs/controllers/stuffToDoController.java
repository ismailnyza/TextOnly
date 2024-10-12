package cheapDrugs.controllers;

import cheapDrugs.DTO.requests.Requests.JobDTO;
import cheapDrugs.Entitys.Job;
import cheapDrugs.DTO.requests.Requests.SearchRequest;
import cheapDrugs.services.jobService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class stuffToDoController {

    private final cheapDrugs.services.jobService jobService;

    public stuffToDoController(jobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/getALLJobs")
    public Optional<List<Job>> getAllJobs() {
        return jobService.getAllJobs();
    }

    @PostMapping("/addJob")
    public Job addJob(@RequestBody JobDTO jobDTO) {
        return jobService.addJob(jobDTO);
    }


    @PostMapping("/addJobBulk")
    public List<Job> addJob(@RequestBody List<JobDTO> jobDTOList) {
        return jobService.bulkAddJobs(jobDTOList);
    }

    @PostMapping("/find")
    public List<Job> findJob(@RequestBody SearchRequest searchRequest) {
        return jobService.SearchJobsFuzzy(searchRequest.getSearchTerm());
    }
}
