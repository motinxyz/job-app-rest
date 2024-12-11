package app.scm.jobapprest.job;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JobController {

    ResponseEntity<List<Job>> getAllJobs();
    ResponseEntity<Job> getJobById(Long id);
    ResponseEntity<String> addJob(Job job);
    ResponseEntity<String> deleteJobById(Long id);
    ResponseEntity<String> updateJobInfoById(Long id, Job job);
}
