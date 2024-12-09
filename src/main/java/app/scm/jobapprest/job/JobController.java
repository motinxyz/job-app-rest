package app.scm.jobapprest.job;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JobController {

    List<Job> getAllJobs();
    ResponseEntity<Job> getJobById(Long id);
    String addJob(Job job);
}
