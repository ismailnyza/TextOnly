package cheapDrugs.services;

import cheapDrugs.DTO.requests.Requests.JobDTO;
import cheapDrugs.DTO.requests.Requests.jobFilterCriteria;
import cheapDrugs.Entitys.Job;
import cheapDrugs.Repositories.jobRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class jobService {

    jobRepository jobRepo;

    public jobService(jobRepository jobRepo) {
        this.jobRepo = jobRepo;
    }

    public Optional<List<Job>> getAllJobs() {
        return Optional.of(jobRepo.findAll());
    }

    public Job addJob(JobDTO jobDTO) {
        Job job = new Job();
        job.setJobTitle(jobDTO.getJobTitle());
        job.setJobDescription(jobDTO.getJobDescription());
        job.setMessage(jobDTO.getMessage());
        job.setSalary(jobDTO.getSalary() != null ? Long.valueOf(jobDTO.getSalary()) : 350000);
        return jobRepo.save(job);
    }

    public Optional<List<Job>> SearchJobsbyFilterCriteria(jobFilterCriteria jobFilterCriteria) {
        //how to implement this
//        how to implement this
        return null;

    }

    public List<Job> SearchJobsFuzzy(String searchTerm) {
        return jobRepo.fuzzyFind(searchTerm);
    }


    public List<Job> bulkAddJobs(List<JobDTO> jobDTOList) {
        ArrayList<Job> jobsList = new ArrayList<>();
        for (JobDTO job: jobDTOList){
            Job jobTemp = new Job();
            BeanUtils.copyProperties(job , jobTemp);
            jobsList.add(jobTemp);
        }
        return jobRepo.saveAll(jobsList);
    }

}